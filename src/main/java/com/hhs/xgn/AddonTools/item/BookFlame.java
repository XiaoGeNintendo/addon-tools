package com.hhs.xgn.AddonTools.item;

import java.util.List;

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

public class BookFlame extends Item {
	public BookFlame() {
		super();
		this.setUnlocalizedName("bookflame");
		this.setCreativeTab(TabLoader.tab);
		this.setContainerItem(Items.book);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.bookflame.tooltip"));
		tooltip.add(i18nHelper.translate("item.bookflame.category"));
		tooltip.add(i18nHelper.translate("item.bookflame.help"));
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(side.equals(EnumFacing.DOWN)){
			worldIn.setBlockState(pos.add(0, -1, 0), Blocks.fire.getDefaultState());
		}
		if(side.equals(EnumFacing.UP)){
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.fire.getDefaultState());
		}
		if(side.equals(EnumFacing.EAST)){
			worldIn.setBlockState(pos.add(1, 0, 0), Blocks.fire.getDefaultState());
		}
		if(side.equals(EnumFacing.WEST)){
			worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.fire.getDefaultState());
		}
		if(side.equals(EnumFacing.NORTH)){
			worldIn.setBlockState(pos.add(0, 0, -1), Blocks.fire.getDefaultState());
		}
		if(side.equals(EnumFacing.SOUTH)){
			worldIn.setBlockState(pos.add(0, 0, 1), Blocks.fire.getDefaultState());
		}
		worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
		return true;
	}
}
