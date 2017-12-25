package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class InstantCake extends ItemFood {

	public InstantCake() {
		super(20,20,false);
		this.setUnlocalizedName("instantcake");
		this.setCreativeTab(TabLoader.tab);
		
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.instantcake.tooltip"));
	}
}
