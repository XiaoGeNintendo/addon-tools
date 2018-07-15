package com.hhs.xgn.AddonTools.common;

import com.hhs.xgn.AddonTools.achievement.AchievementMainClass;
import com.hhs.xgn.AddonTools.achievement.MoreAch;
import com.hhs.xgn.AddonTools.block.BlockLoader;
import com.hhs.xgn.AddonTools.event.EventBus;
import com.hhs.xgn.AddonTools.event.FMLEventBus;
import com.hhs.xgn.AddonTools.gui.GuiElementLoader;
import com.hhs.xgn.AddonTools.item.ItemTown;
import com.hhs.xgn.AddonTools.others.CraftingStation;
import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	new ConfigWriter(event);
    	new TabLoader();
    	new ItemTown(event);
    	new BlockLoader(event);
    	new CraftingStation();
    	new EventBus();
    	new FMLEventBus();
    	new AchievementMainClass();
    	new MoreAch();
    	new GuiElementLoader();
    	
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}