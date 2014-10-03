package com.pwn9.PwnBreeding;

import org.bukkit.ChatColor;
import org.bukkit.World;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class FeedListener implements Listener 
{
    private final PwnBreeding plugin;
    
	public FeedListener(PwnBreeding plugin) 
	{
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    this.plugin = plugin;
	}

	// Listen for the Event and then do stuff with it
	@EventHandler(ignoreCancelled = true)
    public void onAnimalClick(PlayerInteractEntityEvent e)
    {
		World eworld = e.getPlayer().getLocation().getWorld();
		
		// If plugin is not enabled in this world, return
		if (!PwnBreeding.isEnabledIn(eworld.getName())) return; 

        if(e.getRightClicked() instanceof Pig)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
        if(e.getRightClicked() instanceof Cow)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
        if(e.getRightClicked() instanceof Sheep)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
        if(e.getRightClicked() instanceof Chicken)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
        if(e.getRightClicked() instanceof Horse)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
        if(e.getRightClicked() instanceof Wolf)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
        if(e.getRightClicked() instanceof Ocelot)
        {
            Player player = e.getPlayer(); // no need to store player earlier than needed, but if you're going to use it once, for a message, it's not needed to store it at all.
            player.sendMessage(ChatColor.GOLD + "Sent");
        }
    }
	
}
