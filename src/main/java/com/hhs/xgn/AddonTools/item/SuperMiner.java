package com.hhs.xgn.AddonTools.item;

import java.util.Queue;

import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.block.BlockAir;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class SuperMiner extends Item {

	public SuperMiner() {
		this.setUnlocalizedName("superminer");
		this.setCreativeTab(TabLoader.tab);
		this.setMaxDamage(5000);
		this.setMaxStackSize(1);
	}
	
	public void addInformation(net.minecraft.item.ItemStack stack, net.minecraft.entity.player.EntityPlayer playerIn, java.util.List tooltip, boolean advanced) {
		tooltip.add(i18nHelper.translate("item.superminer.tooltip"));
		tooltip.add(i18nHelper.translate("item.superminer.category"));
		tooltip.add(i18nHelper.translate("item.superminer.help"));
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setBoolean("dfs", true);
		}
		tooltip.add(new ChatComponentTranslation("item.superminer.mode", (stack.getTagCompound().getBoolean("dfs")?"DFS":"BFS")).getFormattedText());
	};
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setBoolean("dfs", true);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	private int[] dx={0,0,0,0,1,-1};
	private int[] dy={1,-1,0,0,0,0};
	private	int[] dz={0,0,1,-1,0,0};
	private int times=0;
	
	private void dfs(int x,int y,int z,ItemStack s,EntityPlayer p,IBlockState bs){
		//System.out.println("Running DFS:"+x+" "+y+" "+z+"With s="+s+" bs="+bs);
		s.damageItem(1, p);
		times--;
		if(times==0) return;
		
		EntityItem e=new EntityItem(p.worldObj, x, y, z);
		e.setEntityItemStack(new ItemStack(Item.getItemFromBlock(bs.getBlock())));
		
		if(p.worldObj.isRemote==false) p.worldObj.spawnEntityInWorld(e);
		
		p.worldObj.setBlockToAir(new BlockPos(x,y,z));
		
		if(s.getMaxDamage()-s.getItemDamage()<=0) return;
		for(int i=0;i<6;i++){
			int nx=x+dx[i],ny=y+dy[i],nz=z+dz[i];
			if(p.worldObj.getBlockState(new BlockPos(nx, ny, nz)).equals(Blocks.air.getDefaultState())){
				//System.out.println("Bad at "+nx+" "+ny+" "+nz+" :: block is air");
				continue;
			}
			if(p.worldObj.getBlockState(new BlockPos(nx,ny,nz)).equals(bs)==false){
				//System.out.println("Bad at "+nx+" "+ny+" "+nz+" :: block is"+p.worldObj.getBlockState(new BlockPos(nx,ny,nz)));
				continue;
			}
			if(s.getMaxDamage()-s.getItemDamage()<=0) return;
			if(times==0) return;
			dfs(nx,ny,nz,s,p,bs);
		}
	}
	
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setBoolean("dfs", true);
		}
		
		times=100;
		if(stack.getTagCompound().getBoolean("dfs")){
			dfs(pos.getX(),pos.getY(),pos.getZ(),stack,playerIn,worldIn.getBlockState(pos));
		}
		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}
	
	
}
