package net.legitmine;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandCanceller implements Listener {

	private FakeOP plugin;

	public CommandCanceller(FakeOP plugin) {
		this.plugin = plugin;
	}

	  @EventHandler(ignoreCancelled=true)
	  public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
	    String c = e.getMessage().replaceFirst("/", "");
	    if (this.plugin.isFakeOP.contains(e.getPlayer().getName())) {
	      for (String command : this.plugin.getConfig().getStringList("allow-commands")) {
	        if (c.startsWith(command))
	          return;
	      }
	      for (String command : this.plugin.getConfig().getConfigurationSection("command-triggers").getKeys(false)) {
	        if (c.startsWith(command)) {
	          for (String exec : this.plugin.getConfig().getStringList("command-triggers." + command)) {
	            this.plugin.getServer().dispatchCommand(this.plugin.getServer().getConsoleSender(), exec.replace("%sender%", e.getPlayer().getName()));
	          }
	        }
	      }
	      for (String command : this.plugin.getConfig().getStringList("execute-commands"))
	        this.plugin.getServer().dispatchCommand(this.plugin.getServer().getConsoleSender(), command.replace("%sender%", e.getPlayer().getName()));
	      e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("command-message").replace("%sender%", e.getPlayer().getName())));
	      e.setCancelled(true);
	    }
	  }
}
