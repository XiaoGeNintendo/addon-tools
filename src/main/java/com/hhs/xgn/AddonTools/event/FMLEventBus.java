package com.hhs.xgn.AddonTools.event;

import com.hhs.xgn.AddonTools.achievement.AchievementMainClass;
import com.hhs.xgn.AddonTools.achievement.MoreAch;
import com.hhs.xgn.AddonTools.block.BlockLoader;
import com.hhs.xgn.AddonTools.item.ItemTown;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FMLEventBus {
	public FMLEventBus(){
		FMLCommonHandler.instance().bus().register(this);
	}
	
	@SubscribeEvent
	public void ItemCraftedEvent(net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent event){
		if(event.crafting.getItem().equals(ItemTown.dh)){
			event.player.triggerAchievement(AchievementMainClass.a);
		}
		if(event.crafting.getItem().equals(ItemTown.fw)){
			event.player.triggerAchievement(AchievementMainClass.b);
		}
		if(event.crafting.getItem().equals(ItemTown.ls)){
			event.player.triggerAchievement(AchievementMainClass.c);
		}
		if(event.crafting.getItem().equals(ItemTown.up)){
			event.player.triggerAchievement(AchievementMainClass.d);
		}
		if(event.crafting.getItem().equals(ItemTown.ln)){
			event.player.triggerAchievement(AchievementMainClass.e);
		}
		Item i=event.crafting.getItem();
		EntityPlayer p=event.player;
		if(i.equals(ItemTown.uc)){
			p.triggerAchievement(AchievementMainClass.f);
		}
		if(i.equals(ItemTown.ic)){
			p.triggerAchievement(AchievementMainClass.g);
		}
		if(i.equals(ItemTown.imc)){
			p.triggerAchievement(AchievementMainClass.h);
		}
		if(i.equals(ItemTown.ne)){
			p.triggerAchievement(AchievementMainClass.i);
		}
		if(i.equals(ItemTown.vb)){
			p.triggerAchievement(AchievementMainClass.j);
		}
		if(i.equals(ItemTown.ew)){
			p.triggerAchievement(AchievementMainClass.k);
		}
		if(i.equals(ItemTown.el)){
			p.triggerAchievement(AchievementMainClass.l);
		}
		if(i.equals(ItemTown.ds)){
			p.triggerAchievement(AchievementMainClass.m);
		}
		if(i.equals(ItemTown.ws)){
			p.triggerAchievement(AchievementMainClass.n);
		}
		if(i.equals(ItemTown.ls_)){
			p.triggerAchievement(AchievementMainClass.o);
		}
		if(i.equals(ItemTown.ms)){
			p.triggerAchievement(AchievementMainClass.p);
		}
		if(i.equals(ItemTown.rc)){
			p.triggerAchievement(AchievementMainClass.q);
		}
		if(i.equals(ItemTown.is)){
			p.triggerAchievement(AchievementMainClass.r);
		}
		if(i.equals(Item.getItemFromBlock(BlockLoader.r))){
			p.triggerAchievement(AchievementMainClass.s);
		}
		if(i.equals(ItemTown.sb)){
			p.triggerAchievement(MoreAch.a);
		}
		if(i.equals(ItemTown.sf)){
			p.triggerAchievement(MoreAch.b);
		}
		if(i.equals(ItemTown.bf)){
			p.triggerAchievement(MoreAch.c);
		}
		if(i.equals(ItemTown.ss)){
			p.triggerAchievement(AchievementMainClass.y);
		}
		if(i.equals(ItemTown.sw)){
			p.triggerAchievement(MoreAch.d);
		}
		if(i.equals(ItemTown.ba)){
			p.triggerAchievement(MoreAch.e );
		}
		if(i.equals(ItemTown.sw)){
			p.triggerAchievement(MoreAch.f);
		}
		if(i.equals(ItemTown.bw)){
			p.triggerAchievement(MoreAch.g);
		}
		if(i.equals(ItemTown.sv)){
			p.triggerAchievement(MoreAch.h);
		}
		if(i.equals(ItemTown.bv)){
			p.triggerAchievement(MoreAch.i);
		}
		if(i.equals(Item.getItemFromBlock(BlockLoader.cb))){
			p.triggerAchievement(AchievementMainClass.z);
		}
		if(i.equals(ItemTown.ss_)){
			p.triggerAchievement(AchievementMainClass.aa);
		}
		if(i.equals(ItemTown.hes)){
			p.triggerAchievement(AchievementMainClass.ab);
		}
		if(i.equals(ItemTown.as)){
			p.triggerAchievement(MoreAch.k);
		}
		if(i.equals(ItemTown.hnp)){
			p.triggerAchievement(AchievementMainClass.ad);
		}
		if(i.equals(ItemTown.mm)){
			p.triggerAchievement(AchievementMainClass.ae);
		}
		if(i.equals(ItemTown.ps)){
			p.triggerAchievement(AchievementMainClass.af);
		}
		if(i.equals(ItemTown.ns)){
			p.triggerAchievement(AchievementMainClass.ag);
		}
		if(i.equals(ItemTown.sg)){
			p.triggerAchievement(AchievementMainClass.ah);
		}
	}
}
