package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WaterStick extends ItemFood {

	public WaterStick() {
		super(1, 1, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("waterstick");
		this.setCreativeTab(TabLoader.tab);
		this.setContainerItem(ItemTown.ds);
		this.bFull3D=true;
		
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.clearActivePotions();
		player.dropItem(new ItemStack(ItemTown.ds,1), false, true);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.waterstick.tooltip"));
	}
}
