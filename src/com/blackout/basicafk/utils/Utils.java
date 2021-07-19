package com.blackout.basicafk.utils;

import java.io.File;
import java.io.IOException;


public class Utils {

	/**
	 * Create the plugin folder
	 * @throws IOException
	 */
	public static void createFile() throws IOException {
		File folder = new File("plugins/BasicAFK");
		if (!folder.exists())
			folder.mkdirs();
	}
	
}
