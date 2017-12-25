package com.hhs.xgn.AddonTools.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
//test Only!
public class TestItem extends Item{
	public TestItem(){
		super();
		this.setUnlocalizedName("testitem");
		this.setCreativeTab(TabLoader.tab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(new ChatComponentTranslation("item.testitem.testtext").getFormattedText());
		tooltip.add("To the translationers:How can you translate this text???It has no language file!");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		if (playerIn.isSneaking()) { // 如果玩家还按住Shift(潜行状态) 则直接返回 什么也不做
            return itemStackIn;
        }
        if (!itemStackIn.hasTagCompound()) { // 判断ItemStack是否含有TagCompound 用来避免一些奇葩的特殊情况
            itemStackIn.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound nbt=itemStackIn.getTagCompound();
        nbt.setInteger("times", nbt.getInteger("times")+1);
        playerIn.addChatComponentMessage(new ChatComponentText("LALA:"+nbt.getInteger("times")));
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		NBTTagCompound nbt=stack.getTagCompound();
		nbt.setInteger("times",0);
		super.onCreated(stack, worldIn, playerIn);
	}
}
