package com.pwn9.PwnBreeding;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
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
	// consider using playerinteractATentityevent
	@EventHandler(ignoreCancelled = true)
    public void onAnimalClick(PlayerInteractEntityEvent e)
    {
		// THIS EVENT FIRES TOO FAST WE NEED A TIMER
		
		
		World eworld = e.getPlayer().getLocation().getWorld();
		
		// If plugin is not enabled in this world, return
		if (!PwnBreeding.isEnabledIn(eworld.getName())) return; 

        Player player = e.getPlayer(); 
        String thisItem = player.getItemInHand().getType().toString();
		
        if(e.getRightClicked() instanceof Chicken)
        {          
        	
        	e.setCancelled(true);
        	
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
            if (player.getItemInHand().getType() == Material.WHEAT_SEEDS) 
            {
                if(player.getItemInHand().getAmount() > 1) 
                {
                    	player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                } 
                else 
                {
                    player.getItemInHand().setAmount(0);
                }
            }
        }
        else if(e.getRightClicked() instanceof Cow)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }
        else if(e.getRightClicked() instanceof Sheep)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }
        else if(e.getRightClicked() instanceof Pig)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }
        else if(e.getRightClicked() instanceof Horse)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }
        else if(e.getRightClicked() instanceof Wolf)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }
        else if(e.getRightClicked() instanceof Ocelot)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }
        else if(e.getRightClicked() instanceof Rabbit)
        {
            player.sendMessage(ChatColor.GOLD + "Player has " + thisItem + " for a " + e.getRightClicked().getType().toString());
        }        
    }
	
}
