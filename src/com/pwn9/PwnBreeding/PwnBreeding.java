package com.pwn9.PwnBreeding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class PwnBreeding extends JavaPlugin 
{
	// Init vars
	public static File dataFolder;
	public final Logger logger = Logger.getLogger("Minecraft.PwnBreeding");   	
	public static List<String> enabledWorlds;
	public static Boolean logEnabled;
	static Random randomNumberGenerator = new Random();
	public static PluginDescriptionFile pdfFile;
	
	// Default chances - do we need this?
	public static int ChickenChance;
	public static int CowChance;
	public static int HorseChance;
	public static int OcelotChance;
	public static int PigChance;
	public static int SheepChance;
	public static int WolfChance;	
	
	@Override
	public void onEnable() 
	{
    	this.saveDefaultConfig();
    	
    	// Init Listener
    	new CreatureSpawnListener(this);
    	new FeedListener(this);
    	
    	// Get Data Folder
    	PwnBreeding.dataFolder = getDataFolder();
    	
    	// Load Config File
    	this.loadConfig();
    	
    	// Load plugin.yml
    	PwnBreeding.pdfFile = this.getDescription(); //Gets plugin.yml
    	 		
		// Start Metrics
		try 
		{
		    MetricsLite metricslite = new MetricsLite(this);
		    metricslite.start();
		} 
		catch (IOException e) 
		{
		    // Failed to submit the stats :-(
		}  
		
		if (PwnBreeding.logEnabled)
		{
			PwnBreeding.logToFile(PwnBreeding.pdfFile.getName() + " version " + PwnBreeding.pdfFile.getVersion() + " [enabled]");
		}	
	}
	
	public void onDisable() 
	{
		if (PwnBreeding.logEnabled)
		{		
			PwnBreeding.logToFile(PwnBreeding.pdfFile.getName() + " version " + PwnBreeding.pdfFile.getVersion() + " [disabled]");
		}	
	}	
	
	// Generate a random number and return bool
	static boolean random(int percentChance) 
	{
		return randomNumberGenerator.nextInt(100) > percentChance;
	}
	
	// Check enabled worlds list and return bool
	public static boolean isEnabledIn(String world) 
	{
		return enabledWorlds.contains(world);
	}	
	
	// Load all of our config file
	public void loadConfig() 
	{
		PwnBreeding.enabledWorlds = getConfig().getStringList("enabled_worlds");
		PwnBreeding.logEnabled = getConfig().getBoolean("debug_log");
		
		// Load default chances - do we even need this?
		PwnBreeding.ChickenChance = getConfig().getInt("default.CHICKEN.spawnChance", 50);
		PwnBreeding.CowChance = getConfig().getInt("default.COW.spawnChance", 50);
		PwnBreeding.HorseChance = getConfig().getInt("default.HORSE.spawnChance", 50);
		PwnBreeding.OcelotChance = getConfig().getInt("default.OCELOT.spawnChance", 50);
		PwnBreeding.PigChance = getConfig().getInt("default.PIG.spawnChance", 50);
		PwnBreeding.SheepChance = getConfig().getInt("default.SHEEP.spawnChance", 50);
		PwnBreeding.WolfChance = getConfig().getInt("default.WOLF.spawnChance", 50);
	}	
	
	// Debug logging
    public static void logToFile(String message) 
    {   
	    	try 
	    	{		    
			    if(!dataFolder.exists()) 
			    {
			    	dataFolder.mkdir();
			    }
			     
			    File saveTo = new File(dataFolder, "pwnbreeding.log");
			    if (!saveTo.exists())  
			    {
			    	saveTo.createNewFile();
			    }
			    
			    FileWriter fw = new FileWriter(saveTo, true);
			    PrintWriter pw = new PrintWriter(fw);
			    pw.println(getDate() +" "+ message);
			    pw.flush();
			    pw.close();
		    } 
		    catch (IOException e) 
		    {
		    	e.printStackTrace();
		    }
    }
    
    public static String getDate() 
    {
    	  String s;
    	  Format formatter;
    	  Date date = new Date(); 
    	  formatter = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
    	  s = formatter.format(date);
    	  return s;
    }		
	
}