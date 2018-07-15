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

public class DrainStick extends Item {

	public DrainStick() {
		this.setUnlocalizedName("drainstick");
		this.setCreativeTab(TabLoader.tab);
		this.setMaxStackSize(1);
		
	}
	
	public void addInformation(net.minecraft.item.ItemStack stack, net.minecraft.entity.player.EntityPlayer playerIn, java.util.List tooltip, boolean advanced) {
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setInteger("soul", 0);
			stack.getTagCompound().setInteger("blood", 0);
		}
		tooltip.add(i18nHelper.translate("item.drainstick.tooltip"));
		tooltip.add(i18nHelper.translate("item.drainstick.category"));
		tooltip.add(i18nHelper.translate("item.drainstick.help"));
		tooltip.add(new ChatComponentTranslation("item.drainstick.soul", stack.getTagCompound().getInteger("soul")).getFormattedText());
		tooltip.add(new ChatComponentTranslation("item.drainstick.blood", stack.getTagCompound().getInteger("blood")).getFormattedText());
	};
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setInteger("soul", 0);
		stack.getTagCompound().setInteger("blood", 0);
		
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		playerIn.setItemInUse(itemStackIn, getMaxItemUseDuration(itemStackIn));
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumAction.BOW;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		// TODO Auto-generated method stub
		return (int) 1e5;
	}
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		if(count%10!=0) return;
		if(player.worldObj.isRemote) return;
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setInteger("soul", 0);
			stack.getTagCompound().setInteger("blood", 0);
		}
		
		World w=player.worldObj;
		EntityLiving e=(EntityLiving) w.findNearestEntityWithinAABB(EntityLiving.class, new AxisAlignedBB(player.posX-20, player.posY-20, player.posZ-20, player.posX+20, player.posY+20, player.posZ+20), player);
		if(e==null){
			xgn.PlaySound(w, player, "random.anvil_break");
			return;
		}
		e.attackEntityFrom(new DamageSource("drainstick").setDamageIsAbsolute().setDamageBypassesArmor(), 1);
		if(e.isEntityAlive()){
			xgn.PlaySound(w, player, "random.orb");
			stack.getTagCompound().setInteger("blood", stack.getTagCompound().getInteger("blood")+1);
		}else{
			xgn.PlaySound(w, player, "random.levelup");
			stack.getTagCompound().setInteger("soul", stack.getTagCompound().getInteger("soul")+1);
		}
		super.onUsingTick(stack, player, count);
	}
}


