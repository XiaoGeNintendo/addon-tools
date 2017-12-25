package com.hhs.xgn.AddonTools.block;

import java.util.Random;

import com.hhs.xgn.AddonTools.AddonTools;
import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class CheapBlock extends Block {

	public CheapBlock() {
		super(new DefaultMaterial());
		this.stepSound=soundTypeMetal;
		this.setUnlocalizedName("cheapblock");
		this.setCreativeTab(TabLoader.tab);
		this.setHardness(0.1F);
		this.setResistance(0);
		
		//this.setTickRandomly(true);
		
	}

	
	
	/*@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX(), pos.getY(), pos.getZ(), 1, 1, 1, 0);
	}*/
	
	
}
