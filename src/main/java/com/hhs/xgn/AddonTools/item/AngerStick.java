package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class AngerStick extends Item{
	public AngerStick(){
		this.setUnlocalizedName("angerstick");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.angerstick.tooltip"));
		tooltip.add(i18nHelper.translate("item.angerstick.category"));
		tooltip.add(i18nHelper.translate("item.angerstick.help"));
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound nbt=new NBTTagCompound();
		nbt.setInteger("mob",-1);
		stack.setTagCompound(nbt);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(playerIn.isSneaking()){
			itemStackIn.getTagCompound().setInteger("mob", -1);
			
			if(!worldIn.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.reset"));
			return itemStackIn;
		}
		return itemStackIn;
	}
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target) {
		NBTTagCompound nbt=stack.getTagCompound();
		World world=playerIn.worldObj;
		if (!stack.hasTagCompound()) { // 判断ItemStack是否含有TagCompound 用来避免一些奇葩的特殊情况
            stack.setTagCompound(new NBTTagCompound());
              nbt=stack.getTagCompound();
              nbt.setInteger("mob", -1);

        }
		
		if(nbt.getInteger("mob")==-1){
			nbt.setInteger("mob", target.getEntityId());
			if(!world.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.set",target.getName()));
		}else{
			EntityLiving e=(EntityLiving)playerIn.worldObj.getEntityByID(nbt.getInteger("mob"));
			
			if(e==null){
				if(!world.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.miss"));
				return false;
			}
			
			if(!(target instanceof EntityLiving)){
				if(!world.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.fail"));
				return false;
			}
			
			EntityLiving f=(EntityLiving) target;
			e.setAttackTarget(f);
			f.setAttackTarget(e);
			if(!world.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.ok",e.getName(),f.getName()));
		}
		stack.setTagCompound(nbt);
		//Fu*king Minecraft will not automatically change the player heldItem() 
		playerIn.setCurrentItemOrArmor(0, stack);
		
		return true;
	}
}
