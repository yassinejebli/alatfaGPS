package com.alatfa.gps.Socket;

import com.alatfa.gps.model.*;
import com.alatfa.gps.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Socket_tk103Handler implements Runnable {
	private Socket sock = null;
	private InputStream sockInput = null;
	private OutputStream sockOutput = null;
	private Thread myThread = null;
	private VehiculeRepository vehiculeRepository;
	private PositionRepository positionRepository;
	private NotificationRepository notificationRepository;
	private GeoZoneLimitRepository geoZoneLimitRepository;
	private GeoZoneAlertRepository geoZoneAlertRepository;

	public Socket_tk103Handler(Socket sock, VehiculeRepository vehiculeRepository, PositionRepository positionRepository, NotificationRepository notificationRepository, GeoZoneLimitRepository geoZoneLimitRepository, GeoZoneAlertRepository geoZoneAlertRepository) throws IOException {
		this.sock = sock;
		sockInput = sock.getInputStream();
		sockOutput = sock.getOutputStream();
		this.myThread = new Thread(this);
		this.vehiculeRepository = vehiculeRepository;
		this.positionRepository = positionRepository;
		this.notificationRepository = notificationRepository;
		this.geoZoneLimitRepository = geoZoneLimitRepository;
		this.geoZoneAlertRepository = geoZoneAlertRepository;
	}
	Notification oldNotificationSurVitesse = null;
	Notification oldNotificationGeoZoneLimit = null;
	Notification oldNotificationGeoZoneAlert = null;
	boolean positionAffected= false;

	public void start() {
		myThread.start();
	}

	public void run() {
		while (true) {

			byte[] buf = new byte[1024];
			int bytes_read = 0;

			try {
				bytes_read = sockInput.read(buf, 0, buf.length);

				if (bytes_read < 0) {
					System.err
							.println("Paquet recu invalide bytes_read<0");
					break;
				}

				System.out.println("Paquet recu: "
						+ new String(buf, 0, buf.length));



				String paquete = new String(buf, 0, bytes_read);
				String[] splitted = paquete.split("[,]");
				if(splitted.length > 10)
				{
					String imei = splitted[0].split(":")[1];
					String datetime = splitted[2];// en milliseconde
					String latitude = splitted[7];
					String longitude = splitted[9];


					System.out.println("imei : "+imei+ ", date : "+datetime+", latitude : "+parseLatitude(latitude,splitted[8])+", longitude : "+parseLongitude(longitude,splitted[10]));


					System.out.println("iiiiiiiiiiiiiiiiiiiiiimei : "+imei);


					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

					Long milliSeconds= Long.valueOf(datetime).longValue();//Long.parseLong("1289375173771");



					Position position = new Position();

					position.setVehicule(vehiculeRepository.findByEquipementGps_imei(imei));
					position.setId(UUID.randomUUID().toString());
					position.setDate(new Date());
					position.setLatitude(parseLatitude(latitude,splitted[8]));
					position.setLongitude(parseLongitude(longitude,splitted[10]));
					position.setVitesse(Double.parseDouble(splitted[11]));

					Position oldPosition = positionRepository.findTopByVehicule_IdOrderByDateDesc(position.getVehicule().getId());


					/*if(!positionAffected)
					{
						oldPosition = position;
						positionAffected = true;
					}*/

					if(oldPosition != null)
					{

						/*
						* oldVehicule = v1
						* newVehicule = v2
						* position du v1 je vais la comparer avec oldPosition du v1
						* position du v2 je vais la comparer avec oldPosition du v2
						*
						* */

						//if(oldPosition.getVehicule().getId() == position.getVehicule().getId())
						double maDistanceParcourue = getDistance(new Coordonnee(position.getLatitude(),position.getLongitude()),new Coordonnee(oldPosition.getLatitude(),oldPosition.getLongitude()));
						System.out.println("ma distance = "+maDistanceParcourue);
						/*double diffSec = ((new Date().getTime() - oldPosition.getDate().getTime())/1000)%60;
						System.out.println(new Date().getTime()+" /" +oldPosition.getDate().getTime());*/
						System.out.println("diffSec ="+(new Date().getTime() - oldPosition.getDate().getTime()));

						if(maDistanceParcourue >= position.getVehicule().getEquipementGps().getDistanceEnvoi() && (new Date().getTime() - oldPosition.getDate().getTime()) >= position.getVehicule().getEquipementGps().getSecondsEnvoi()*1000)//5metres puis sauvegarde
						{
							positionRepository.save(position);
							System.out.println("Position inserée !");
							//positionAffected = true;
							position.getVehicule().setKilometrage(position.getVehicule().getKilometrage()+maDistanceParcourue);//en métre
							vehiculeRepository.save(position.getVehicule());//kilometrage est mis à jour
						}
					}else
					{
						positionRepository.save(position);
						System.out.println("Position inserée pour la 1ére fois !");

					}


					//Surviteeeeeeeeeeeeeeeeeeeeeesse
					if(position.getVitesse() > position.getVehicule().getLimitVitesse()){

						if(oldNotificationSurVitesse != null)
						{
							if(new Date().getTime() - oldNotificationSurVitesse.getDate().getTime() > 10000 ) {
								Notification notificationVitesse = new Notification();
								notificationVitesse.setId(UUID.randomUUID().toString());
								notificationVitesse.setVehicule(position.getVehicule());
								notificationVitesse.setVitesse(position.getVitesse());
								notificationVitesse.setDate(position.getDate());
								notificationVitesse.setLatitude(position.getLatitude());
								notificationVitesse.setLongitude(position.getLongitude());
								notificationVitesse.setType("Survitesse");
								notificationVitesse.setVu(false);
								notificationRepository.save(notificationVitesse);
								System.out.println("Notification survitesse : " + notificationVitesse);
								oldNotificationSurVitesse = notificationVitesse;
							}
						}else
						{
							Notification notificationVitesse = new Notification();
							notificationVitesse.setId(UUID.randomUUID().toString());
							notificationVitesse.setVehicule(position.getVehicule());
							notificationVitesse.setVitesse(position.getVitesse());
							notificationVitesse.setDate(position.getDate());
							notificationVitesse.setLatitude(position.getLatitude());
							notificationVitesse.setLongitude(position.getLongitude());
							notificationVitesse.setType("Survitesse");
							notificationVitesse.setVu(false);
							notificationRepository.save(notificationVitesse);
							System.out.println("Notification survitesse : " + notificationVitesse);
							oldNotificationSurVitesse = notificationVitesse;
						}
					}


					Coordonnee pos = new Coordonnee(position.getLatitude(),position.getLongitude());

					//Gardiennage virtuel --->
					GeoZoneLimit geoZoneLimit = geoZoneLimitRepository.findByVehicule_Id(position.getVehicule().getId());

					double distance = getDistance(pos,new Coordonnee(geoZoneLimit.getLatitude(),geoZoneLimit.getLongitude()));
					System.out.println("Distance entre "+position.getVehicule().getIntitule() +" et gard virt : "+geoZoneLimit.getNom() +" est = "+distance);

					//distance (entre centre dyal geozone m3a la position actuelle) > rayon ===> insertion dans notification
					if(distance > geoZoneLimit.getRayon()){

							if(oldNotificationGeoZoneLimit != null && geoZoneLimit.isActive())
							{
								if(new Date().getTime() - oldNotificationGeoZoneLimit.getDate().getTime() > 10000) {
									Notification notificationGeoZone = new Notification();
									notificationGeoZone.setId(UUID.randomUUID().toString());
									notificationGeoZone.setVehicule(position.getVehicule());
									notificationGeoZone.setVitesse(position.getVitesse());
									notificationGeoZone.setDate(position.getDate());
									notificationGeoZone.setLatitude(position.getLatitude());
									notificationGeoZone.setLongitude(position.getLongitude());
									notificationGeoZone.setType("Hors Zone");
									notificationGeoZone.setVu(false);
									notificationRepository.save(notificationGeoZone);
									System.out.println("Notification hors zone : " + notificationGeoZone);
									oldNotificationGeoZoneLimit = notificationGeoZone;
								}
							}else
							{
								Notification notificationGeoZone = new Notification();
								notificationGeoZone.setId(UUID.randomUUID().toString());
								notificationGeoZone.setVehicule(position.getVehicule());
								notificationGeoZone.setVitesse(position.getVitesse());
								notificationGeoZone.setDate(position.getDate());
								notificationGeoZone.setLatitude(position.getLatitude());
								notificationGeoZone.setLongitude(position.getLongitude());
								notificationGeoZone.setType("Hors Zone");
								notificationGeoZone.setVu(false);
								notificationRepository.save(notificationGeoZone);
								System.out.println("Notification hors zone 2 : " + notificationGeoZone);
								oldNotificationGeoZoneLimit = notificationGeoZone;
							}
						}


					List<GeoZoneAlert> geoZoneAlerts = geoZoneAlertRepository.findByVehicule_Id(position.getVehicule().getId());

					for(GeoZoneAlert g : geoZoneAlerts)
					{
						if(!g.isActive()) continue;
						//pos = position actuelle
						double distanceAlert = getDistance(pos,new Coordonnee(g.getLatitude(),g.getLongitude()));
						System.out.println("Distance alerte entre "+position.getVehicule().getIntitule() +" et gard virt : "+g.getNom() +" est = "+distanceAlert);

						//distance (entre centre dyal geozone et la position actuelle) < rayon ===> insertion dans notification (type = "zone alerte"
						if(distanceAlert < g.getRayon()){

							if(oldNotificationGeoZoneLimit != null)
							{
								if(new Date().getTime() - oldNotificationGeoZoneAlert.getDate().getTime() > 10000 ) {
									Notification notificationGeoZoneAlert = new Notification();
									notificationGeoZoneAlert.setId(UUID.randomUUID().toString());
									notificationGeoZoneAlert.setVehicule(position.getVehicule());
									notificationGeoZoneAlert.setVitesse(position.getVitesse());
									notificationGeoZoneAlert.setDate(position.getDate());
									notificationGeoZoneAlert.setLatitude(position.getLatitude());
									notificationGeoZoneAlert.setLongitude(position.getLongitude());
									notificationGeoZoneAlert.setType("Zone d'alerte");
									notificationGeoZoneAlert.setVu(false);
									notificationRepository.save(notificationGeoZoneAlert);
									System.out.println("Notification zone alerte : " + notificationGeoZoneAlert);
									oldNotificationGeoZoneAlert = notificationGeoZoneAlert;
								}
							}else
							{
								Notification notificationGeoZoneAlert = new Notification();
								notificationGeoZoneAlert.setId(UUID.randomUUID().toString());
								notificationGeoZoneAlert.setVehicule(position.getVehicule());
								notificationGeoZoneAlert.setVitesse(position.getVitesse());
								notificationGeoZoneAlert.setDate(position.getDate());
								notificationGeoZoneAlert.setLatitude(position.getLatitude());
								notificationGeoZoneAlert.setLongitude(position.getLongitude());
								notificationGeoZoneAlert.setType("Zone d'alerte");
								notificationGeoZoneAlert.setVu(false);
								notificationRepository.save(notificationGeoZoneAlert);
								System.out.println("Notification zone alerte : " + notificationGeoZoneAlert);
								oldNotificationGeoZoneAlert = notificationGeoZoneAlert;
							}
						}


					}


					System.out.println("Position : "+position);
				}
				if (splitted[0].equals("##")) {
					System.out.println("login coban tk103.");
					String ack_packet = "LOAD";
					//ack_packet = "**,imei:868683023129806,C,10s";
					//ack_packet = "**,imei:868683023129806,I,+1";//**,imei:359586018966098,I,+1
					byte[] ack = ack_packet.getBytes();
					sockOutput.write(ack, 0, ack.length);
					sockOutput.flush();

					System.out.println("connexion avec t103 ...");
					ack = null;
					ack_packet = "";
				} else {
					String IMEI = splitted[0];
					IMEI = IMEI.replace(";","");//bug
					if(!IMEI.contains("imei")) IMEI = "imei:"+IMEI;
					String ack_packet = "**," + IMEI + ",B;";
					//ack_packet = "**,imei:868683023129806,I,+1";//**,imei:359586018966098,I,+1
					//ack_packet = "**,imei:868683023129806,C,10s";
					byte[] ack = ack_packet.getBytes();
					sockOutput.write(ack, 0, ack.length);
					sockOutput.flush();

					System.out.println("ACK envoyé: "
							+ new String(ack, 0, ack.length));
					ack = null;
					ack_packet = "";
				}

			} catch (Exception e) {
				e.printStackTrace(System.err);
				break;
			}
		}

		try {
			System.out.println("Handler: fermeture du socket.");
			sock.close();
		} catch (Exception e) {
			System.err.println("Erreeeeeeeeeeur : " + e);
			e.printStackTrace(System.err);
		}

	}

	private double parseLatitude(String s, String d)
	{
		double _lat = Double.parseDouble(s);
		if (_lat < 99999.0) {
			double lat = (double)((long)_lat / 100L);
			lat += (_lat - (lat * 100.0)) / 60.0;
			return d.equals("S")? -lat : lat;
		} else {
			return 90.0;
		}
	}
	private double parseLongitude(String s, String d)
	{
		double _lon = Double.parseDouble(s);
		if (_lon < 99999.0) {
			double lon = (double)((long)_lon / 100L);
			lon += (_lon - (lon * 100.0)) / 60.0;
			return d.equals("W")? -lon : lon;
		} else {
			return 180.0; // longitude invalide
		}
	}


	private double getDistance(Coordonnee p1,Coordonnee p2) {
		double R = 6378137; // Earth’s mean radius in meter
		double dLat = Math.toRadians(p2.getLat() - p1.getLat());
		double dLong = Math.toRadians(p2.getLng() - p1.getLng());
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
				Math.cos(Math.toRadians(p1.getLat())) * Math.cos(Math.toRadians(p2.getLat())) *
						Math.sin(dLong / 2) * Math.sin(dLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d; // returns the distance in meter
	}


}