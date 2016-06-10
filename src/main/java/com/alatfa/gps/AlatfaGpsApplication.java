package com.alatfa.gps;

import com.alatfa.gps.Socket.Socket_tk103;
import com.alatfa.gps.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class AlatfaGpsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AlatfaGpsApplication.class, args);
	}


	@Autowired
	VehiculeRepository vehiculeRepository;

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private GeoZoneLimitRepository geoZoneLimitRepository;

	@Autowired
	private GeoZoneAlertRepository geoZoneAlertRepository;

	@Override
	public void run(String... args) throws Exception {

		//System.out.println(vehiculeRepository.findByEquipementGps_imei("868683023129806"));
		int port = 9090;
		System.out.println("sockeeeeeeeeeeeeeeeeeeeeeeeeeet");
		Socket_tk103 server = null;
		try {
			server = new Socket_tk103(port,vehiculeRepository,positionRepository,notificationRepository,geoZoneLimitRepository,geoZoneAlertRepository);
			server.waitForConnections();
		} catch (IOException e) {
			e.printStackTrace(System.err);
			server.waitForConnections();
		}
	}
}
