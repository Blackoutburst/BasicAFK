package com.blackout.basicafk.core;

import org.bukkit.scheduler.BukkitRunnable;

import com.blackout.basicafk.main.Main;

public class Core {

	/**
	 * Repeat a task every second on a new thread
	 * This will be used to check when player are AFK
	 * And display it if this is the case
	 */
	public Core() {
		new BukkitRunnable(){
			@Override
			public void run(){
				try {
					afkTimer();
				} catch(Exception e) {}
			}
		}.runTaskTimerAsynchronously(Main.getPlugin(Main.class), 0L, 20L);
	}
	
	/**
	 * Decrease player count down every seconds
	 * Display is they are AFK or not
	 * @throws Exception
	 */
	private void afkTimer() throws Exception {
		for (AfkPlayer p : Main.players) {
			p.setDelay(p.getDelay() - 1);
			
			if (p.getDelay() <= 0) {
				p.getPlayer().setPlayerListName(p.getPlayer().getDisplayName()+" §4§lAFK§r");
			} else {
				p.getPlayer().setPlayerListName(p.getPlayer().getDisplayName().replace(" §4§lAFK§r", ""));
			}
		}
	}
}
