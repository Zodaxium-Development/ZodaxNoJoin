package me.zodaxium.nojoin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Listenerlogin implements Listener{

	NoJoin plugin;
	
	public Listenerlogin(NoJoin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e){
		String ip = e.getAddress().toString().replaceFirst("/", "");
		String uuid = e.getPlayer().getUniqueId().toString().replaceAll("-", "");
		if(plugin.ip.contains(ip) || plugin.pardons.contains(uuid)) return;
		e.disallow(Result.KICK_OTHER, plugin.kick_message);
	}
}