package com.alatfa.gps.Socket;

import com.alatfa.gps.repositories.*;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class Socket_tk103 {
	private int serverPort = 0;
	private ServerSocket serverSock = null;
	private Socket sock = null;

	private VehiculeRepository vehiculeRepository;
	private PositionRepository positionRepository;
	private NotificationRepository notificationRepository;
	private GeoZoneLimitRepository geoZoneLimitRepository;
	private GeoZoneAlertRepository geoZoneAlertRepository;

	public Socket_tk103(int serverPort, VehiculeRepository vehiculeRepository, PositionRepository positionRepository, NotificationRepository notificationRepository, GeoZoneLimitRepository geoZoneLimitRepository, GeoZoneAlertRepository geoZoneAlertRepository) throws IOException {
		this.serverPort = serverPort;
		serverSock = new ServerSocket(serverPort);
		this.vehiculeRepository = vehiculeRepository;
		this.positionRepository=positionRepository;
		this.notificationRepository=notificationRepository;
		this.geoZoneLimitRepository = geoZoneLimitRepository;
		this.geoZoneAlertRepository = geoZoneAlertRepository;
	}

	public void waitForConnections() {
		while (true) {
			try {
				sock = serverSock.accept();
				System.out
						.println("Server: Nouveau socket a été crée .");
				Socket_tk103Handler handler = new Socket_tk103Handler(sock,vehiculeRepository,positionRepository,notificationRepository,geoZoneLimitRepository,geoZoneAlertRepository);
				handler.start();

			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
		}
	}
/*
	public static void main(String argv[]) {
		int port = 9090;
		System.out.println("sockeeeeeeeeeeeeeeeeeeeeeeeeeet");
		LServer server = null;
		try {
			server = new LServer(port);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
		server.waitForConnections();
	}*/
}