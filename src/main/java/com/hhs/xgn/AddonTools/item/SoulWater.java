package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulWater extends Item{
	public SoulWater(){
		this.setUnlocalizedName("soulwater");
		this.setCreativeTab(TabLoader.tab);
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.soulwater.tooltip"));
		tooltip.add(i18nHelper.translate("item.soulwater.category"));
		tooltip.add(i18nHelper.translate("item.soulwater.help"));
	}
}
