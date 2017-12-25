package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.achievement.MoreAch;
import com.hhs.xgn.AddonTools.common.ConfigWriter;
import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundList.SoundEntry;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BookAqua extends Item {
	public BookAqua() {
		super();
		this.setUnlocalizedName("bookaqua");
		this.setCreativeTab(TabLoader.tab);
		this.setContainerItem(Items.book);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.bookaqua.tooltip"));
		tooltip.add(i18nHelper.translate("item.bookaqua.category"));
		tooltip.add(i18nHelper.translate("item.bookaqua.help"));
		tooltip.add(i18nHelper.translate("item.bookaqua.addition"));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(!ConfigWriter.canUseBookAqua){
			if(!worldIn.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.fail"));
			return itemStackIn;
		}
		
		if(playerIn.isWet()){
			if(worldIn.getBlockState(playerIn.getPosition())==Blocks.water.getDefaultState() || worldIn.getBlockState(playerIn.getPosition())==Blocks.flowing_water.getDefaultState()) worldIn.setBlockToAir(playerIn.getPosition());
			playerIn.getFoodStats().setFoodLevel(playerIn.getFoodStats().getFoodLevel()+1);
			worldIn.playSoundAtEntity(playerIn, "random.drink", 1.0f, 1.0f);
		}
		
		/*if(playerIn.isWet() && (worldIn.getBlockState(playerIn.getPosition())!=Blocks.water.getBlockState() || worldIn.getBlockState(playerIn.getPosition())!=Blocks.flowing_water.getBlockState())){
			playerIn.triggerAchievement(MoreAch.f);
		}*/
		
		return itemStackIn;
	}
		
		
}
