package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MinecraftCrasher extends Item {

	public MinecraftCrasher() {
		this.setUnlocalizedName("minecraftcrasher");
		this.setCreativeTab(TabLoader.tab);
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.minecraftcrasher.tooltip"));
		tooltip.add(i18nHelper.translate("item.minecraftcrasher.category"));
		tooltip.add(i18nHelper.translate("item.minecraftcrasher.help"));
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	@SuppressWarnings("null")
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		ItemStack is=null;
		is.hasTagCompound();
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
}

