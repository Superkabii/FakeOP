package net.legitmine;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.java.JavaPlugin;

public class FakeOP extends JavaPlugin {

	public Set<String> isFakeOP = new HashSet<String>();

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CommandCanceller(this), this);
		getCommand("fakeop").setExecutor(new FakeOPCommand(this));
		getCommand("fakedeop").setExecutor(new FakeDEOPCommand(this));
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
