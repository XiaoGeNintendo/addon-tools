package com.hhs.xgn.AddonTools.block;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader {
	public static final String ReturnerID="returner";
	public static final String CheapBlockID="cheapblock";
	
	public static Returner r = new Returner();
	public static CheapBlock cb=new CheapBlock();

    public BlockLoader(FMLPreInitializationEvent event)
    {
        register(r,ReturnerID);
        register(cb,CheapBlockID);
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(r);
        registerRender(cb);
    }
    
    private static void register(Block block, String name)
    {
        GameRegistry.registerBlock(block, name);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        String name = GameData.getBlockRegistry().getNameForObject(block).toString();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
    }
}
