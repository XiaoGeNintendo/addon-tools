package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulWood extends Item{
	public SoulWood(){
		this.setUnlocalizedName("soulwood");
		this.setCreativeTab(TabLoader.tab);
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.soulwood.tooltip"));
		tooltip.add(i18nHelper.translate("item.soulwood.category"));
		tooltip.add(i18nHelper.translate("item.soulwood.help"));
	}
}
