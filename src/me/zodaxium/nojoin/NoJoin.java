package me.zodaxium.nojoin;

import java.io.File;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class NoJoin extends JavaPlugin{

	public String ip;
	public String kick_message;
	public List<String> pardons;
	
	public void onEnable(){
		saveDefaultConfig();
		
		ip = getConfig().getString("BungeeCord-Ip");
		kick_message = colorize(getConfig().getString("Kick-Message"));
		pardons = getConfig().getStringList("Pardons");
		
		new Commandreload(this, "njreload");
		new Listenerlogin(this);
	}
	
	private String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public boolean reloadConfigFile(){
		try{
			File file = new File(getDataFolder(), "config.yml");
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			ip = config.getString("BungeeCord-Ip");
			kick_message = colorize(config.getString("Kick-Message"));
			pardons = config.getStringList("Pardons");
			return true;
		}catch(Exception e){ return false; }
	}
}