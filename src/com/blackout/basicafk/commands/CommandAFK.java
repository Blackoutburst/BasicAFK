package com.blackout.basicafk.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.blackout.basicafk.core.AfkPlayer;

public class CommandAFK {

	public void run(CommandSender sender) {
		if (sender instanceof Player) {
			AfkPlayer.get((Player) sender).setDelay(0);
		}
	}
}
