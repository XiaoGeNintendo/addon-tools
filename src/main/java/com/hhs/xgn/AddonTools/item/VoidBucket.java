package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class VoidBucket extends ItemBucket {

	public VoidBucket() {
		super(Blocks.air);
		this.setUnlocalizedName("voidbucket");
		this.setCreativeTab(TabLoader.tab);
		
	}
	
	/*IBlockState it=worldIn.getBlockState(pos);
	if(it.equals(Blocks.flowing_water.getDefaultState())
			|| it.equals(Blocks.flowing_lava.getDefaultState())
			|| it.equals(Blocks.water.getDefaultState())
			|| it.equals(Blocks.lava.getDefaultState())){
		worldIn.setBlockToAir(pos);
		return true;
	}else{
		playerIn.addChatComponentMessage(new ChatComponentText("FAILED!"));
		return true;
	}*/
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.voidbucket.tooltip"));
	}

	@Override
	public boolean tryPlaceContainedLiquid(World worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
}
