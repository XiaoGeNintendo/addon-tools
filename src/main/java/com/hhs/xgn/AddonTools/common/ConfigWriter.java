package com.hhs.xgn.AddonTools.common;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigWriter {

	private static Logger logger;
	private static Configuration config;
	
	public static boolean getJoinAchievement;
	public static boolean getNewJoinAch;
	public static boolean canUseBookWood;
	public static boolean canUseBookVoid;
	public static boolean canUseBookAqua;
	public static boolean canUseSoulGemKillMobs;
	
	public static int NamedSwordP;
	public static int NamedSwordMod;
	
	public static CategoryEntry category;
	public ConfigWriter(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		load();
	}

	public static void load() {
		logger.info("[Addon Tools Logger]Started loading config. ");
		String comment;
		//ACHIEVEMENT
		comment = "Will the player get the join-in achievement 'Welcome to Minecraft with Addon Tools'? true for yes and false for no";
		getJoinAchievement = config.get("achievement", "getJoinAchievement", true, comment).getBoolean();
		
		comment = "Will the player get the join-in achievement 'Hello,Addon Tools'? true for yes and false for no";
		getNewJoinAch = config.get("achievement", "getNewJoinAchievement", true, comment).getBoolean();
		
		config.addCustomCategoryComment("achievement", "This category will help you to get some hidden achievements.\n Change them into 'true' so that you can trigger them with the tasks below the achievement name.");
		
		//ITEMS
		comment="Can the player use Book Of Wood to kill other mobs?";
		canUseBookWood=config.get("items", "canUseBookWood",true,comment).getBoolean();
		
		comment="Can the player use Book Of Void to Destory blocks include Bedrock?";
		canUseBookVoid=config.get("items", "canUseBookVoid", true,comment).getBoolean();
		
		comment="Can the player use Book Of Aqua to get hunger point?";
		canUseBookAqua=config.get("items","canUseBookAqua", true,comment).getBoolean();
		
		comment="Can the player use Soul Gem to kill mobs?";
		canUseSoulGemKillMobs=config.get("items","canUseSoulGemKillMobs",true,comment).getBoolean();
		
		comment="The prime used for hashing Named Sword.(default 999983)";
		NamedSwordP=config.get("items", "NamedSwordP", 999983,comment).getInt();
		
		comment="The mod used for hashing Named Sword.(default 120)";
		NamedSwordMod=config.get("items", "NamedSwordMod", 120,comment).getInt();
		
		
		config.addCustomCategoryComment("items", "This category will help you to on/off some items' using");
		config.save();
		logger.info("[Addon Tools Logger]Finished loading config. ");
	}

	public static Logger logger() {
		return logger;
	}
}
