package com.blackout.basicafk.commands;

import org.bukkit.command.CommandSender;

import com.blackout.basicafk.core.YmlManager;
import com.blackout.basicafk.main.Main;

public class CommandSetAfkTime {

	public void run(CommandSender sender, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("§cInvalid usage try /setAfkTime followed by a value §e(exemple /setAfkTime 60)");
			return;
		}
		
		int value = 0;
		
		try {
			value = Integer.valueOf(args[0]);
		} catch (Exception e) {
			sender.sendMessage("§cInvalid usage the value must be a number (integer)");
			return;
		}
		
		Main.afkDelay = value;
		
		try {
			YmlManager.save();
		} catch (Exception e) {
			sender.sendMessage("§cError while saving the configuration file please check the console");
			e.printStackTrace();
		}
	}
}
