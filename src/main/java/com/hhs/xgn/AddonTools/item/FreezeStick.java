package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.google.common.collect.Lists;
import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;
import com.hhs.xgn.AddonTools.utils.xgn;

import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces.Torch;

public class FreezeStick extends Item{
	public FreezeStick(){
		this.setUnlocalizedName("freezestick");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.freezestick.tooltip"));
		tooltip.add(i18nHelper.translate("item.freezestick.category"));
		tooltip.add(i18nHelper.translate("item.freezestick.help"));
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
			
			xgn.PlaySound(playerIn.worldObj, playerIn, "random.levelup");
			
			return true;
		}else{
			return false;
		}
	}
}
