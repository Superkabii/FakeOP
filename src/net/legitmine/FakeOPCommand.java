package net.legitmine;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeOPCommand implements CommandExecutor {

	private FakeOP plugin;
	
	public FakeOPCommand(FakeOP plugin) {
		this.plugin = plugin;
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (args.length == 1) {
		      Player fakeop = plugin.getServer().getPlayer(args[0]);
		      if (fakeop != null) {
		        if (!plugin.isFakeOP.contains(fakeop.getName())) {
		          fakeop.sendMessage(ChatColor.YELLOW + "You are now op!");
		          sender.sendMessage(ChatColor.YELLOW + "You have set " + fakeop.getName() + " as a fake op.");
		          plugin.isFakeOP.add(fakeop.getName()); } else {
		          sender.sendMessage(ChatColor.YELLOW + fakeop.getName() + " is already a fake op.");
		        } } else sender.sendMessage(ChatColor.YELLOW + "'" + args[0] + "' not found."); 
		    } else { sender.sendMessage(ChatColor.YELLOW + "Invalid usage! Syntax: /fakeop [Player]"); }
		    return true;
		  }
}
