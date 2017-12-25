package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DrinkingStick extends Item {
	public DrinkingStick(){
		this.setCreativeTab(TabLoader.tab);
		this.setUnlocalizedName("drinkingstick");
		this.bFull3D=true;
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.drinkingstick.tooltip"));
	}
}
