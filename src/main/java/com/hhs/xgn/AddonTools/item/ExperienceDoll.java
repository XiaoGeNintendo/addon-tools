package com.hhs.xgn.AddonTools.item;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;
import com.hhs.xgn.AddonTools.utils.xgn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ExperienceDoll extends Item {

	public ExperienceDoll() {
		this.setUnlocalizedName("experiencedoll");
		this.setCreativeTab(TabLoader.tab);
		this.setMaxStackSize(1);
		
	}
	
	public void addInformation(net.minecraft.item.ItemStack stack, net.minecraft.entity.player.EntityPlayer playerIn, java.util.List tooltip, boolean advanced) {
		
		float lv;
		int exp;
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setFloat("level", 1.0f);
			stack.getTagCompound().setInteger("exp", 0);
			lv=1.0f;
			exp=0;
		}else{
			lv=stack.getTagCompound().getFloat("level");
			exp=stack.getTagCompound().getInteger("exp");
		}
		
		tooltip.add(i18nHelper.translate("item.experiencedoll.tooltip"));
		tooltip.add(i18nHelper.translate("item.experiencedoll.category"));
		tooltip.add(i18nHelper.translate("item.experiencedoll.help"));
		tooltip.add(new ChatComponentTranslation("item.experiencedoll.lv", lv).getFormattedText());
		tooltip.add(new ChatComponentTranslation("item.experiencedoll.exp",exp,getNeedExp(lv)).getFormattedText());
	};
	
	/**
	 * Get from lv -> lv+0.1 will need how many experience
	 * @param lv
	 * @return
	 */
	public static int getNeedExp(double lv) {
		return (int)(Math.ceil(Math.pow(2, lv)));
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setFloat("level", 1.0f);
		stack.getTagCompound().setInteger("exp", 0);
		
		super.onCreated(stack, worldIn, playerIn);
	}
	
	
}


