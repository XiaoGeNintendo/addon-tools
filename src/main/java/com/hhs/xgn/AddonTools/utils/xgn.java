package com.hhs.xgn.AddonTools.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

public class xgn {
	public static void chat(EntityPlayer playerIn,String w){
		if(!playerIn.worldObj.isRemote)playerIn.addChatComponentMessage(new ChatComponentText(w));
	}
}
