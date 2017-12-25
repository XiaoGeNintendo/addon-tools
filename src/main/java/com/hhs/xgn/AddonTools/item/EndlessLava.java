package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EndlessLava extends Item {
	public EndlessLava() {
		super();
		this.setUnlocalizedName("endlesslava");
		this.setCreativeTab(TabLoader.tab);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(new ChatComponentTranslation("item.endlesslava.tooltip").getFormattedText());
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(side.equals(EnumFacing.DOWN)){
			worldIn.setBlockState(pos.add(0, -1, 0), Blocks.flowing_lava.getDefaultState());
		}
		if(side.equals(EnumFacing.UP)){
			worldIn.setBlockState(pos.add(0, 1, 0), Blocks.flowing_lava.getDefaultState());
		}
		if(side.equals(EnumFacing.EAST)){
			worldIn.setBlockState(pos.add(1, 0, 0), Blocks.flowing_lava.getDefaultState());
		}
		if(side.equals(EnumFacing.WEST)){
			worldIn.setBlockState(pos.add(-1, 0, 0), Blocks.flowing_lava.getDefaultState());
		}
		if(side.equals(EnumFacing.NORTH)){
			worldIn.setBlockState(pos.add(0, 0, -1), Blocks.flowing_lava.getDefaultState());
		}
		if(side.equals(EnumFacing.SOUTH)){
			worldIn.setBlockState(pos.add(0, 0, 1), Blocks.flowing_lava.getDefaultState());
		}
		return true;
	}
}
