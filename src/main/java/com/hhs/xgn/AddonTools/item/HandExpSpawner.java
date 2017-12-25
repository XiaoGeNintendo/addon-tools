package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.achievement.AchievementMainClass;
import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class HandExpSpawner extends Item{
	public HandExpSpawner(){
		this.setUnlocalizedName("handexpspawner");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.handexpspawner.tooltip"));
		tooltip.add(i18nHelper.translate("item.handexpspawner.category"));
		tooltip.add(i18nHelper.translate("item.handexpspawner.help"));
		if(stack.hasTagCompound()) tooltip.add(new ChatComponentTranslation("item.handexpspawner.addition",stack.getTagCompound().getInteger("exp"),(stack.getTagCompound().getBoolean("add")?"Add":"Get")).getFormattedText());
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound nbt=new NBTTagCompound();
		nbt.setInteger("exp", 0);
		nbt.setBoolean("add", true);
		
		
		stack.setTagCompound(nbt);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound nbt=itemStackIn.getTagCompound();
		
		if (!itemStackIn.hasTagCompound()) { // 判断ItemStack是否含有TagCompound 用来避免一些奇葩的特殊情况
            itemStackIn.setTagCompound(new NBTTagCompound());
            nbt=itemStackIn.getTagCompound();
            nbt.setBoolean("add",true);
            nbt.setInteger("exp", 0);
        }
		
		if(playerIn.isSneaking()){
			nbt.setBoolean("add",!nbt.getBoolean("add"));
			if(!worldIn.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.handexpspawner.mode", (itemStackIn.getTagCompound().getBoolean("add")?"Add":"Get")));
			return itemStackIn;
		}
		
		
		if(!nbt.getBoolean("add")){
			playerIn.addExperience(nbt.getInteger("exp"));
			if(!worldIn.isRemote) playerIn.addChatComponentMessage(new ChatComponentTranslation("item.handexpspawner.get",nbt.getInteger("exp")));
			nbt.setInteger("exp", 0);
		}else{
			nbt.setInteger("exp", nbt.getInteger("exp")+1);
			worldIn.playSoundAtEntity(playerIn, "random.levelup", 1.0f, 1.0f);
			if(!worldIn.isRemote) playerIn.addChatComponentMessage(new ChatComponentTranslation("item.handexpspawner.add",nbt.getInteger("exp")));
			if(nbt.getInteger("exp")>=1000){
				playerIn.triggerAchievement(AchievementMainClass.ac);
			}
		}
		return itemStackIn;
	}
}
