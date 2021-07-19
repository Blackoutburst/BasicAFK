package com.blackout.basicafk.commands;

import org.bukkit.command.CommandSender;

import com.blackout.basicafk.core.YmlManager;


public class CommandReload {

	public void run(CommandSender sender) {
		try {
			YmlManager.load();
			sender.sendMessage("§bConfiguration reloaded successfully");
		} catch (Exception e) {
			sender.sendMessage("§cImpossible to reload the configuration please check the console");
			e.printStackTrace();
		}
	}
}
