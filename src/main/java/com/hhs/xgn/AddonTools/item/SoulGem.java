package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.common.ConfigWriter;
import com.hhs.xgn.AddonTools.others.TabLoader;
import com.hhs.xgn.AddonTools.utils.i18nHelper;
import com.hhs.xgn.AddonTools.utils.xgn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class SoulGem extends Item{
	public SoulGem(){
		this.setUnlocalizedName("soulgem");
		this.setCreativeTab(TabLoader.tab);
		this.maxStackSize=1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(i18nHelper.translate("item.soulgem.tooltip"));
		tooltip.add(i18nHelper.translate("item.soulgem.category"));
		tooltip.add(i18nHelper.translate("item.soulgem.help"));
		if(stack.hasTagCompound()){
			NBTTagCompound nbt=stack.getTagCompound();
			float mxhp=nbt.getFloat("maxhp");
			float nowhp=nbt.getFloat("nowhp");
			String source=nbt.getString("source");
			if(mxhp==0 || nowhp==0 || source.equals("")){
				tooltip.add(i18nHelper.translate("item.soulgem.nonbt"));
				return;
			}
			tooltip.add(new ChatComponentTranslation("item.soulgem.maxhp", stack.getTagCompound().getInteger("maxhp")).getFormattedText());
			tooltip.add(new ChatComponentTranslation("item.soulgem.nowhp", stack.getTagCompound().getInteger("nowhp")).getFormattedText());
			tooltip.add(new ChatComponentTranslation("item.soulgem.source", stack.getTagCompound().getString("source")).getFormattedText());
		}else{
			tooltip.add(i18nHelper.translate("item.soulgem.nonbt"));
		}
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound nbt=new NBTTagCompound();
		nbt.setFloat("maxhp",20);
		nbt.setFloat("nowhp",20);
		nbt.setString("source", playerIn.getName());
		
		stack.setTagCompound(nbt);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(itemStackIn.hasTagCompound()){
			NBTTagCompound nbt=itemStackIn.getTagCompound();
			float mxhp=nbt.getFloat("maxhp");
			float nowhp=nbt.getFloat("nowhp");
			String source=nbt.getString("source");
			
			//Nth was stored :(
			if(mxhp==0 || nowhp==0 || source.equals("")){
				xgn.chat(playerIn, i18nHelper.translate("item.soulgem.error"));
				return itemStackIn;
			}
			
			playerIn.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mxhp);
			playerIn.setHealth(nowhp);
			xgn.chat(playerIn,new ChatComponentTranslation("item.soulgem.acquire", source).getFormattedText());
			itemStackIn.stackSize--;
			return itemStackIn;
		}else{
			xgn.chat(playerIn, i18nHelper.translate("item.soulgem.error"));
			return itemStackIn;
		}
		
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target) {
		NBTTagCompound nbt=stack.getTagCompound();
		World world=playerIn.worldObj;
		if (!stack.hasTagCompound()) { // 判断ItemStack是否含有TagCompound 用来避免一些奇葩的特殊情况
            stack.setTagCompound(new NBTTagCompound());
            nbt=stack.getTagCompound();
            nbt.setFloat("maxhp",20);
    		nbt.setFloat("nowhp",20);
    		nbt.setString("source", playerIn.getName());
        }
		
		nbt.setFloat("maxhp",target.getMaxHealth());
		nbt.setFloat("nowhp", target.getHealth());
		nbt.setString("source", target.getName());
		
		xgn.chat(playerIn,i18nHelper.translate("item.soulgem.ok"));
		
		if(ConfigWriter.canUseSoulGemKillMobs){
			target.attackEntityFrom(new DamageSource("soulgem").setDamageAllowedInCreativeMode().setDamageBypassesArmor().setDamageIsAbsolute(), target.getMaxHealth()+10);
		}
		
		
		
		stack.setTagCompound(nbt); 
		playerIn.setCurrentItemOrArmor(0, stack);
		return true;
	}
}
