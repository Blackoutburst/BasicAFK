package com.blackout.basicafk.core;

import org.bukkit.entity.Player;

import com.blackout.basicafk.main.Main;

public class AfkPlayer {

	protected Player player;
	protected boolean afk;
	protected int delay;
	
	public AfkPlayer(Player player, boolean afk, int delay) {
		this.player = player;
		this.afk = afk;
		this.delay = delay;
	}

	public boolean isAfk() {
		return afk;
	}

	public AfkPlayer setAfk(boolean afk) {
		this.afk = afk;
		return (this);
	}

	public int getDelay() {
		return delay;
	}

	public AfkPlayer setDelay(int delay) {
		this.delay = delay;
		return (this);
	}

	public Player getPlayer() {
		return player;
	}
	
	public static AfkPlayer get(Player player) {
		for (AfkPlayer p : Main.players)
			if (p.player.getUniqueId().equals(player.getUniqueId()))
				return (p);
		return (null);
	}
	
}
