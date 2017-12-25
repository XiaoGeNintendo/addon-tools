package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;
import com.hhs.xgn.AddonTools.utils.xgn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class MobMover extends Item {
	public MobMover(){
		this.setUnlocalizedName("mobmover");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.mobmover.tooltip"));
		tooltip.add(i18nHelper.translate("item.mobmover.category"));
		tooltip.add(i18nHelper.translate("item.mobmover.help"));
		
	}
	
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setInteger("entity",0);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		ItemStack itemStackIn=stack;
		if(!itemStackIn.hasTagCompound()){
			xgn.chat(playerIn,i18nHelper.translate("item.mobmover.fail2"));
			return false;
		}
		if(itemStackIn.getTagCompound().getInteger("entity")==0){
			xgn.chat(playerIn,i18nHelper.translate("item.mobmover.fail2"));
			return false;
		}
		
		Entity e=worldIn.getEntityByID(itemStackIn.getTagCompound().getInteger("entity"));
		
		if(e==null){
			xgn.chat(playerIn,i18nHelper.translate("item.mobmover.fail2"));
			itemStackIn.getTagCompound().setInteger("entity", 0);
			return false;
		}
		
		//e.resetEntityId();
//		e.posX=playerIn.posX;
//		e.posY=playerIn.posY;
//		e.posZ=playerIn.posZ;
		e.setPosition(pos.getX(), pos.getY()+1, pos.getZ());
		
		e.setInvisible(false);
		//xgn.chat(playerIn,e.toString());
		worldIn.updateEntityWithOptionalForce(e, true);
		
		//e.setDead();
		itemStackIn.getTagCompound().setInteger("entity", 0);
		return true;
		
	}
	
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target) {
		if(!stack.hasTagCompound() ){
			stack.setTagCompound(new NBTTagCompound());

			target.setInvisible(true);
			stack.getTagCompound().setInteger("entity", target.getEntityId());
			playerIn.setCurrentItemOrArmor(0, stack);
			//target.setDead();
			return true;
		}else{
			if(stack.getTagCompound().getInteger("entity")!=0){
				xgn.chat(playerIn, i18nHelper.translate("item.mobmover.fail"));
				return false;
			}else{
				target.setInvisible(true);
				stack.getTagCompound().setInteger("entity", target.getEntityId());
				playerIn.setCurrentItemOrArmor(0, stack);
				//target.setDead();
				return true;
			}
		}
	}
}
