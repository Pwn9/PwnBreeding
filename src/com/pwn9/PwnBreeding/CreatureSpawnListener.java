package com.pwn9.PwnBreeding;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
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

	// Listen for the SpawnEvent and then do stuff with it
	@EventHandler(ignoreCancelled = true)
	public void onSpawn(CreatureSpawnEvent event) 
	{
		World eworld = event.getLocation().getWorld();
		
		// If plugin is not enabled in this world, return
		if (!PwnBreeding.isEnabledIn(eworld.getName())) return; 
		
		// Get the spawn reason, if breeding we'll continue
		String reason = event.getSpawnReason().toString();
		
		// We only care about breeding reason
		if (!reason.equalsIgnoreCase("BREEDING")) return;

		// Getting the world name
		String world = eworld.getName();
		
		// Getting the biome
		String biome = event.getLocation().getBlock().getBiome().toString();
		
		// Getting the entity type
		String mob = event.getEntityType().toString();
	
		// Time to figure out this guys chance setting
		int spawnChance;
		
		if (plugin.getConfig().isSet(world+"."+mob+"."+biome+".spawnChance")) 
		{
			spawnChance = plugin.getConfig().getInt(world+"."+mob+"."+biome+".spawnChance");
		}
		else if (plugin.getConfig().isSet(world+"."+mob+".spawnChance")) 
		{
			spawnChance = plugin.getConfig().getInt(world+"."+mob+".spawnChance");
		}
		else 
		{
			spawnChance = plugin.getConfig().getInt("default."+mob+".spawnChance", 50);
		}
		
		if (PwnBreeding.random(spawnChance)) 
		{			
			// Cancel the event and no baby is born
			event.setCancelled(true);
			
			if (PwnBreeding.logEnabled) 
			{
				PwnBreeding.logToFile("Cancelled spawn of "+mob+" in "+biome+" in world: "+world+". Spawn chance: "+spawnChance);
			}
		}
		
	}
	
}
