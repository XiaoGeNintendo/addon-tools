package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.common.ConfigWriter;
import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class NamedSword extends Item {

	public NamedSword() {
		this.setUnlocalizedName("namedsword");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	public int getMaxDamage() {
		return 1000;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.namedsword.tooltip"));
		tooltip.add(i18nHelper.translate("item.namedsword.category"));
		tooltip.add(i18nHelper.translate("item.namedsword.help"));
		tooltip.add(new ChatComponentTranslation("item.namedsword.atk", getAttack(stack,playerIn)).getFormattedText());
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	/**
	 * Return the attack damage
	 * @param playerIn 
	 * @param stack 
	 * @return
	 */
	private Integer getAttack(ItemStack stack, EntityLivingBase playerIn) {
		String s1=stack.getDisplayName();
		String s2=playerIn.getName();
		int p=ConfigWriter.NamedSwordP;
		int md=ConfigWriter.NamedSwordMod;
		int hsh=0;
		for(int i=0;i<s1.length();i++){
			hsh+=s1.charAt(i);
			hsh*=p;
			hsh%=md;
		}
		for(int i=0;i<s2.length();i++){
			hsh+=s2.charAt(i);
			hsh*=p;
			hsh%=md;
		}
		return hsh;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumAction.BLOCK;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return true;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		int atk=getAttack(stack,attacker);
		target.attackEntityFrom(new DamageSource("namedsword"), atk);
		return super.hitEntity(stack, target, attacker);
	}
}

