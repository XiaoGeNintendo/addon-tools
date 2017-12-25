package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class LavaStick extends ItemFood {

	public LavaStick() {
		super(3, 1, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("lavastick");
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
		player.setFire(60);
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5*60*20, 4));
		player.dropItem(new ItemStack(ItemTown.ds,1), false, true);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.lavastick.tooltip"));
	}
}
