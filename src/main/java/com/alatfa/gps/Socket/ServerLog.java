package com.alatfa.gps.Socket;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Date;

public class ServerLog {
	public void WriteToLog(String args, String file, String tipo)
			throws IOException {
		Logger logger = Logger.getLogger(ServerLog.class.getName());

		FileHandler fileHandler = new FileHandler(file, true);
		logger.addHandler(fileHandler);

		Date d = new Date();

		if (tipo == "INFO") {
			logger.info(d + " | MENSAJE: " + args);
		} else if (tipo == "ERROR") {
			logger.warning(d + " | ERROR: " + args);
		}

	}
}