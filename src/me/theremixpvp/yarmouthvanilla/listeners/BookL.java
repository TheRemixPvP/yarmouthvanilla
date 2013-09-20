package me.theremixpvp.yarmouthvanilla.listeners;

import me.theremixpvp.yarmouthvanilla.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.BookMeta;

public class BookL implements Listener {
	
	Main main;
	
	public BookL(Main plugin) {
		plugin = main;
	}
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType() == Material.WRITTEN_BOOK) {
				BookMeta bm = (BookMeta) p.getItemInHand().getItemMeta();
				String ptn = bm.getTitle();
				if(Bukkit.getPlayer(ptn) != null) {
					final Player pt = Bukkit.getPlayer(ptn);
					p.sendMessage(ChatColor.GREEN + "Teleporting to " + pt.getName() + " in 5 seconds.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
						@Override
                        public void run() {
	                        p.teleport(pt);  
	                        p.sendMessage(ChatColor.GREEN + "Successfully teleported to " + pt.getName() + "!");
	                        return;
                        }
					}, 100);
				}
				if(Bukkit.getOfflinePlayer(ptn) != null) {
					p.sendMessage(ChatColor.RED + "Player not online!");
					return;
				}
				p.sendMessage(ChatColor.RED + "Player has never been on the server!");
				return;
			}
		}
	}

}
