package com.hhs.xgn.AddonTools.gui;

import com.hhs.xgn.AddonTools.AddonTools;
import com.hhs.xgn.AddonTools.client.gui.ReturnerGuiContainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiElementLoader implements IGuiHandler{
	public static final int ReturnerGuiID = 1;

	public GuiElementLoader()
	{
	        NetworkRegistry.INSTANCE.registerGuiHandler(AddonTools.instance, this);
	}

    @Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
	        switch(ID){
	        	case ReturnerGuiID:
	        		return new ReturnerContainer(player);
	        	default:
	        		return null;
	        }
	        	
	        		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(ID){
    	case ReturnerGuiID:
    		return new ReturnerGuiContainer(new ReturnerContainer(player));
    	default:
    		return null;
    }
    }

	
}
