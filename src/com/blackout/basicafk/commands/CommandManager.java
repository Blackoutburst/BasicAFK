package com.blackout.basicafk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandManager {

	/**
	 * The command manager
	 * Execute the right command using
	 * the command name or alias
	 * @param sender
	 * @param command
	 * @param label
	 * @param args
	 */
	public void execute(CommandSender sender, Command command, String label, String[] args) {
		switch(label.toLowerCase()) {
			case "basicafk:setafktime": case "setafktime": new CommandSetAfkTime().run(sender, args); break;
			case "basicafk:reload": case "reload": new CommandReload().run(sender); break;
			case "basicafk:afk": case "afk": new CommandAFK().run(sender); break;
			default: break;
		}
	}
}
