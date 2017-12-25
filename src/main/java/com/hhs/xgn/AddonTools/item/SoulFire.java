package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulFire extends Item {
	public SoulFire(){
		this.setUnlocalizedName("soulfire");
		this.setCreativeTab(TabLoader.tab);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.soulfire.tooltip"));
		tooltip.add(i18nHelper.translate("item.soulfire.category"));
		tooltip.add(i18nHelper.translate("item.soulfire.help"));
	}
}
