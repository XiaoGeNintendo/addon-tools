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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BookWood extends Item {
	public BookWood() {
		super();
		this.setUnlocalizedName("bookwood");
		this.setCreativeTab(TabLoader.tab);
		this.setContainerItem(Items.book);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.bookwood.tooltip"));
		tooltip.add(i18nHelper.translate("item.bookwood.category"));
		tooltip.add(i18nHelper.translate("item.bookwood.help"));
		
	}
	
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(!ConfigWriter.canUseBookWood){
			if(!worldIn.isRemote)playerIn.addChatComponentMessage(new ChatComponentTranslation("item.fail"));
			return itemStackIn;
		}
		EntityLiving en=(EntityLiving)worldIn.findNearestEntityWithinAABB(EntityLiving.class,AxisAlignedBB.fromBounds(playerIn.posX-10, playerIn.posY-10, playerIn.posZ-10, playerIn.posX+10, playerIn.posY+10, playerIn.posZ+10), playerIn);
		if(worldIn.isRemote==false){
			if(en!=null){
				playerIn.heal(en.getHealth());
				if(en.getHealth()>=300){
					playerIn.triggerAchievement(MoreAch.j);
				}
				playerIn.addChatComponentMessage(new ChatComponentTranslation("item.bookwood.heal",en.getHealth(),en.getDisplayName().getFormattedText()));
				en.setDead();
			}else{
				playerIn.addChatComponentMessage(new ChatComponentTranslation("item.bookwood.fail"));
			}
		}
		return itemStackIn;
	};
}
