package com.hhs.xgn.AddonTools.item;

import java.util.List;
import java.util.UUID;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;
import com.hhs.xgn.AddonTools.utils.xgn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class PilotStick extends Item {

	public PilotStick() {
		this.setUnlocalizedName("pilotstick");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.pilotstick.tooltip"));
		tooltip.add(i18nHelper.translate("item.pilotstick.category"));
		tooltip.add(i18nHelper.translate("item.pilotstick.help"));
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setBoolean("pilot", false);
		stack.getTagCompound().setInteger("entity", -1);
		stack.getTagCompound().setInteger("x", 0);
		stack.getTagCompound().setInteger("y", 0);
		stack.getTagCompound().setInteger("z", 0);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if(!playerIn.isSneaking()){
			return itemStackIn;
		}
		
		if(!itemStackIn.hasTagCompound()){
			itemStackIn.setTagCompound(new NBTTagCompound());
			itemStackIn.getTagCompound().setBoolean("pilot", false);
			itemStackIn.getTagCompound().setInteger("entity", -1);
			itemStackIn.getTagCompound().setInteger("x", 0);
			itemStackIn.getTagCompound().setInteger("y", 0);
			itemStackIn.getTagCompound().setInteger("z", 0);
		}
		
		Entity e=worldIn.getEntityByID(itemStackIn.getTagCompound().getInteger("entity"));
		if(e==null){
			xgn.chat(playerIn,i18nHelper.translate("item.pilotstick.fail"));
			
			return itemStackIn;
		}
		
		itemStackIn.getTagCompound().setBoolean("pilot", !itemStackIn.getTagCompound().getBoolean("pilot"));
		
		if(itemStackIn.getTagCompound().getBoolean("pilot")){
			itemStackIn.getTagCompound().setInteger("x", (int) (playerIn.posX-e.posX));
			itemStackIn.getTagCompound().setInteger("y", (int) (playerIn.posY-e.posY));
			itemStackIn.getTagCompound().setInteger("z", (int) (playerIn.posZ-e.posZ));
		}
		
		playerIn.addChatComponentMessage(new ChatComponentTranslation("item.pilotstick.change", itemStackIn.getTagCompound().getBoolean("pilot")));
		return itemStackIn;
	}
	
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if(!stack.hasTagCompound()){
			return;
		}
		if(stack.getTagCompound().getBoolean("pilot")==false){
			return;
		}
		Entity e=worldIn.getEntityByID(stack.getTagCompound().getInteger("entity"));
		if(e==null){
			stack.getTagCompound().setBoolean("pilot", false);
			return;
		}
		
		int x=stack.getTagCompound().getInteger("x");
		int y=stack.getTagCompound().getInteger("y");
		int z=stack.getTagCompound().getInteger("z");
		double sx=(entityIn.posX-x);
		double sy=(entityIn.posY-y);
		double sz=(entityIn.posZ-z);
		double dx= (sx-e.posX);
		double dy=(sy-e.posY);
		double dz=(sz-e.posZ);
		
		e.setVelocity(dx,dy,dz);
		worldIn.updateEntityWithOptionalForce(e, true);
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target) {
		
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
		}
		
		stack.getTagCompound().setBoolean("pilot", false);
		stack.getTagCompound().setInteger("entity", target.getEntityId());
		
		
		//xgn.chat(playerIn, stack.getTagCompound().toString());
		
		playerIn.addChatComponentMessage(new ChatComponentTranslation("item.pilotstick.set", target.getName()));
		playerIn.setCurrentItemOrArmor(0, stack);
		//target.setAIMoveSpeed(0);
		
		return true;
	}
	
	
}
