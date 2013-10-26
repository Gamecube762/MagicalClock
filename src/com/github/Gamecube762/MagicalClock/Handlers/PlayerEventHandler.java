package com.github.Gamecube762.MagicalClock.Handlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class PlayerEventHandler implements Listener {
	
	public Plugin plugin;
	
	public PlayerEventHandler(Plugin p){
		this.plugin = p;
	}
	
	@EventHandler
	public void clickClock(PlayerInteractEvent e) {
		if ( (e.getItem().getType() == Material.WATCH) & e.getPlayer().hasPermission("magicalclock.use") ) {
			Player p = e.getPlayer();
			World w = p.getWorld();
			
			if (e.getAction() == Action.LEFT_CLICK_AIR | e.getAction() == Action.LEFT_CLICK_BLOCK) {
				for (Player v : w.getPlayers()){
					if ( !v.hasPermission("magicalclock.donthide") ) p.hidePlayer(v);
					if ( p.hasPermission("magicalclock.use.hidefromrest") ) v.hidePlayer(p);
				}
				p.sendMessage(ChatColor.AQUA + "Hiding Players");
			}	
			
			if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				for (Player v : w.getPlayers()) p.showPlayer(v);
				p.sendMessage(ChatColor.AQUA + "Showing Players");
			}
		}
	}
}
