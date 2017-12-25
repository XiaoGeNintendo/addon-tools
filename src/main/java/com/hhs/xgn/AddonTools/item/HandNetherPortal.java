package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HandNetherPortal extends Item {
	public HandNetherPortal(){
		this.setUnlocalizedName("handnetherportal");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.handnetherportal.tooltip"));
		tooltip.add(i18nHelper.translate("item.handnetherportal.category"));
		tooltip.add(i18nHelper.translate("item.handnetherportal.help"));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		playerIn.travelToDimension(-1);
		playerIn.timeUntilPortal=5;
		return itemStackIn;
	}
	
}
