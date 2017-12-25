package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class SatisfiedSteak extends ItemFood {
	
	public SatisfiedSteak() {
		// TODO Auto-generated constructor stub
		super(1,1,false);
		this.setUnlocalizedName("satisfiedsteak");
		this.setCreativeTab(TabLoader.tab);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumAction.EAT;
	}
//	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		// TODO Auto-generated method stub
		return 99999;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		
		tooltip.add(i18nHelper.translate("item.satisfiedsteak.tooltip"));
		tooltip.add(i18nHelper.translate("item.satisfiedsteak.category"));
		tooltip.add(i18nHelper.translate("item.satisfiedsteak.help"));
	}
	
}
