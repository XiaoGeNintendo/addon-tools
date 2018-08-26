package com.hhs.xgn.AddonTools.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
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
		tooltip.add("To the translators: How can you translate this text???It has no language file!");
	}
	
	private void setNoAI(EntityAITasks eat){
		List copy=Lists.newArrayList();
		
		for(Object obj:eat.taskEntries){
			copy.add(obj);
		}
		
		for(Object obj:copy){
			eat.removeTask(((EntityAITaskEntry) obj).action);
		}
		
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target) {
		
		if(target instanceof EntityLiving){
			
			setNoAI(((EntityLiving) target).targetTasks);
			setNoAI(((EntityLiving) target).tasks);
			
			return true;
		}else{
			return false;
		}
	}
}
