package com.blackout.basicafk.utils;

import java.io.File;
import java.io.IOException;


public class Utils {

	/**
	 * Create all needed files if they don't exist
	 * Also create the plugin folder
	 * @throws IOException
	 */
	public static void createFile() throws IOException {
		File folder = new File("plugins/BasicAFK");
		File seatFile = new File("plugins/BasicAFK/seats.yml");
		
		if (!folder.exists())
			folder.mkdirs();
		if (!seatFile.exists())
			seatFile.createNewFile();
	}
	
}
