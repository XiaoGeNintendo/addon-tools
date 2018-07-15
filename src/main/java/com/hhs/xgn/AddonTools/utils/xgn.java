package com.hhs.xgn.AddonTools.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class xgn {
	public static void chat(EntityPlayer playerIn,String w){
		if(!playerIn.worldObj.isRemote)playerIn.addChatComponentMessage(new ChatComponentText(w));
	}
	public static void PlaySound(World w,EntityPlayer p,String asset){
		w.playSoundEffect((double)p.posX + 0.5D, (double)p.posY + 0.5D, (double)p.posZ + 0.5D, asset, 1.0F, w.rand.nextFloat() * 0.4F + 0.8F);
	}
}
