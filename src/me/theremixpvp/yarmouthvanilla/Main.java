package me.theremixpvp.yarmouthvanilla;

import me.theremixpvp.yarmouthvanilla.listeners.BookL;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
	public void onEnable() {
		pm.registerEvents(new BookL(this), this);
	}

}
