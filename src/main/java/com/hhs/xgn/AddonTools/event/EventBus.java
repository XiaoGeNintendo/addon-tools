package com.hhs.xgn.AddonTools.event;

import com.hhs.xgn.AddonTools.AddonTools;
import com.hhs.xgn.AddonTools.achievement.AchievementMainClass;
import com.hhs.xgn.AddonTools.block.BlockLoader;
import com.hhs.xgn.AddonTools.common.ConfigWriter;
import com.hhs.xgn.AddonTools.item.ItemTown;
import com.hhs.xgn.AddonTools.utils.i18nHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventBus {
	public EventBus() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void FillBucketEvent(net.minecraftforge.event.entity.player.FillBucketEvent event) {
		if (event.current.getItem().equals(ItemTown.vb)) {
			// event.entityPlayer.addChatComponentMessage(new
			// ChatComponentText("YES!"));
			IBlockState it = event.world.getBlockState(event.target.getBlockPos());
			event.setResult(Result.ALLOW);
			if (it.equals(Blocks.flowing_water.getDefaultState()) || it.equals(Blocks.flowing_lava.getDefaultState())
					|| it.equals(Blocks.water.getDefaultState()) || it.equals(Blocks.lava.getDefaultState())) {
				event.world.setBlockToAir(event.target.getBlockPos());
			}
			event.result = new ItemStack(ItemTown.vb);

		}
		
		
	}
	
	@SubscribeEvent
	public void PlayerInteractEvent(net.minecraftforge.event.entity.player.PlayerInteractEvent event){
		if(event.pos!=null && event.world!=null && event.entityPlayer!=null){
			if(event.world.getBlockState(event.pos).getBlock().equals(BlockLoader.r) && event.action.equals(Action.RIGHT_CLICK_BLOCK)){
				event.entityPlayer.openGui(AddonTools.instance, 1, event.world,event.pos.getX(), event.pos.getY(), event.pos.getZ());
			}
		}
	}
	
//	@SubscribeEvent
//	public void EntityInteractEvent(net.minecraftforge.event.entity.player.EntityInteractEvent event){
//		if(event.entityPlayer.getHeldItem().getItem().equals(ItemTown.as) ){
//			ItemStack stack=event.entityPlayer.getHeldItem();
//			EntityPlayer playerIn=event.entityPlayer;
//			Entity target=event.target;
//			
//			if (!stack.hasTagCompound()) { // 判断ItemStack是否含有TagCompound 用来避免一些奇葩的特殊情况
//	            stack.setTagCompound(new NBTTagCompound());
//	        }
//			NBTTagCompound nbt=stack.getTagCompound();
//			
//			playerIn.addChatComponentMessage(new ChatComponentText("a"+nbt.getInteger("mob")));
//			if(nbt.getBoolean("has")==false){
//				nbt.setInteger("mob", target.getEntityId());
//				nbt.setBoolean("has",true);
//				playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.set",target.getName()));
//			}else{
//				EntityLiving e=(EntityLiving)playerIn.worldObj.getEntityByID(nbt.getInteger("mob1"));
//				
//				if(e==null){
//					playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.miss"));
//					return ;
//				}
//				if(!(target instanceof EntityLiving)){
//					playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.fail"));
//					return ;
//				}
//				
//				EntityLiving f=(EntityLiving) target;
//				e.setAttackTarget(f);
//				f.setAttackTarget(e);
//				playerIn.addChatComponentMessage(new ChatComponentTranslation("item.angerstick.ok",e.getName(),f.getName()));
//			}
//			//playerIn.addChatComponentMessage(new ChatComponentText("TES3T!"+nbt.getInteger("mob1")));
//			stack.setTagCompound(nbt);
//		}
//	}
	
	@SubscribeEvent
	public void EntityJoinWorldEvent(EntityJoinWorldEvent event){
		if(event.entity instanceof EntityPlayer){
			if(ConfigWriter.getJoinAchievement){
				EntityPlayer p=(EntityPlayer)event.entity;
				p.triggerAchievement(AchievementMainClass.t);
			}
			if(ConfigWriter.getNewJoinAch){
				EntityPlayer p=(EntityPlayer)event.entity;
				p.triggerAchievement(AchievementMainClass.u);
			}
		}
	}
}
