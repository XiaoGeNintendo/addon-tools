package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.AddonTools;
import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ReturnCell extends Item {
	public ReturnCell(){
		this.setUnlocalizedName("returncell");
		this.setCreativeTab(TabLoader.tab);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.returncell.tooltip"));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		if(!playerIn.capabilities.isCreativeMode){
			itemStackIn.stackSize--;
		}
		playerIn.openGui(AddonTools.instance, 1, worldIn,(int) playerIn.posX,(int) playerIn.posY,(int) playerIn.posZ);
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
}
