package net.legitmine;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeDEOPCommand implements CommandExecutor {

	private FakeOP plugin;
	
	public FakeDEOPCommand(FakeOP plugin) {
		this.plugin = plugin;
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (args.length == 1) {
		      Player fakeop = this.plugin.getServer().getPlayer(args[0]);
		      if (fakeop != null) {
		        if (this.plugin.isFakeOP.contains(fakeop.getName())) {
		          fakeop.sendMessage(ChatColor.YELLOW + "You are no longer op!");
		          sender.sendMessage(ChatColor.YELLOW + "You have removed fake op from " + fakeop.getName() + ".");
		          this.plugin.isFakeOP.remove(fakeop.getName()); } else {
		          sender.sendMessage(ChatColor.YELLOW + fakeop.getName() + " is not a fake op.");
		        } } else sender.sendMessage(ChatColor.YELLOW + "'" + args[0] + "' not found."); 
		    } else { sender.sendMessage(ChatColor.YELLOW + "Invalid usage! Syntax: /defakeop [Player]"); }
		    return true;
		  }
}
