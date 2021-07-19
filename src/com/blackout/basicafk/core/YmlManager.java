package com.blackout.basicafk.core;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import com.blackout.basicafk.main.Main;

public class YmlManager {

	/**
	 * Create a new configuration file with default value
	 * @throws IOException
	 */
	public static void createConfigFile() throws IOException {
		File configFile = new File("plugins/BasicAFK/config.yml");
		
		if (!configFile.exists()) {
			configFile.createNewFile();
			YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
			
			config.set("afkDelay", 60);
			config.set("afkDisplay", Main.afkDisplay);
			config.save(configFile);
		} else {
			try {
				load();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Load the configuration file value
	 */
	public static void load() throws Exception {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/BasicAFK/config.yml"));
		
		Main.afkDelay = config.getInt("afkDelay");
		Main.afkDisplay = config.getString("afkDisplay").replace("&", "§");
	}
	
	/**
	 * Save the configuration file
	 */
	public static void save() {
		File configFile = new File("plugins/BasicAFK/config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		
		config.set("afkDelay", Main.afkDelay);
		config.set("afkDisplay", Main.afkDisplay);
		
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
