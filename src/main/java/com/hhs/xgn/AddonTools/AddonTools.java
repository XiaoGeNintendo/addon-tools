package com.hhs.xgn.AddonTools;

import com.hhs.xgn.AddonTools.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "addontools",name="Addon Tools",version="Post 5.4.0")
public class AddonTools {
	public static final String modid="addontools";
	public static final String name="Addon Tools";
	public static final String version="post 5.4.0";
	
	@SidedProxy(clientSide = "com.hhs.xgn.AddonTools.client.ClientProxy", 
	            serverSide = "com.hhs.xgn.AddonTools.common.CommonProxy")
	public static CommonProxy proxy;
	   
	public static final String TestItemID="testitem";
	
	@Instance(modid)
	public static AddonTools instance;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
