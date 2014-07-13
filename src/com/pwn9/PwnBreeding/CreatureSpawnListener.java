package com.pwn9.PwnBreeding;

import org.bukkit.Location;
import org.bukkit.World;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class CreatureSpawnListener implements Listener 
{
    private final PwnBreeding plugin;
    
	public CreatureSpawnListener(PwnBreeding plugin) 
	{
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    this.plugin = plugin;
	}

	// List for the ItemSpawnEvent and then do stuff with it
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSpawn(CreatureSpawnEvent event) 
	{
		World eworld = event.getLocation().getWorld();
		Location eLoc = event.getLocation();
		
		// If plugin is not enabled in this world, return
		if (!PwnBreeding.isEnabledIn(eworld.getName())) return; 

		String world = eworld.getName();
		
		
	}
	

}
