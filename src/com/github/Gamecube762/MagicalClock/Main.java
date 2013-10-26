package com.github.Gamecube762.MagicalClock;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.Gamecube762.MagicalClock.Handlers.PlayerEventHandler;

public class Main extends JavaPlugin{
	
	public Logger log;

	@Override
	public void onEnable() {
		this.log = this.getLogger();
		
		getServer().getPluginManager().registerEvents(new PlayerEventHandler(this), this);
		
		getLogger().info("By: Gamecube762");
		getLogger().info("For: Famous Guy");
	}
	
	@Override
	public void onDisable() { }
}
