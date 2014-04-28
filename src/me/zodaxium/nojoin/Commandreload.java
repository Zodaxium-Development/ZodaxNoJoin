package me.zodaxium.nojoin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandreload implements CommandExecutor {

	NoJoin plugin;
	
	public Commandreload(NoJoin plugin, String cmd) {
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("nj.reload")){
			if(plugin.reloadConfigFile()){
				sender.sendMessage(ChatColor.GREEN + "Config reloaded successfully!");
			}else{
				sender.sendMessage(ChatColor.RED + "Config reload failed! Are there any illegal characters?");
			}
		}else{
			sender.sendMessage("Unknown command. Type \"/help\" for help.");
		}
		return true;
	}
}