package com.blackout.basicafk.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.blackout.basicafk.commands.CommandManager;
import com.blackout.basicafk.core.AfkPlayer;
import com.blackout.basicafk.core.Core;
import com.blackout.basicafk.core.YmlManager;
import com.blackout.basicafk.utils.Utils;

public class Main extends JavaPlugin implements Listener {

	public static List<AfkPlayer> players = new ArrayList<AfkPlayer>();
	public static int afkDelay = 60;
	public static String afkDisplay = " §4§lAFK§r";
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		new Core();
		
		try {
			Utils.createFile();
			YmlManager.createConfigFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		players.add(new AfkPlayer(event.getPlayer(), false, afkDelay));
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		players.remove(AfkPlayer.get(event.getPlayer()));
	}
	
	@EventHandler
	public void onMoveEvent(PlayerMoveEvent event) {
		AfkPlayer.get(event.getPlayer()).setDelay(afkDelay);
	}
	
	@EventHandler
	public void onBlockDamageEvent(BlockDamageEvent event) {
		AfkPlayer.get(event.getPlayer()).setDelay(afkDelay);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		AfkPlayer.get(event.getPlayer()).setDelay(afkDelay);
	}
	
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		AfkPlayer.get(event.getPlayer()).setDelay(afkDelay);
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		AfkPlayer.get(event.getPlayer()).setDelay(afkDelay);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		new CommandManager().execute(sender, command, label, args);
		return true;
	}
}
