package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.EnumHelper;

public class NatureEater extends ItemSpade{
	//ShovelRealDamage=MaterialDamage+1
	public static final ToolMaterial NatureEater=EnumHelper.addToolMaterial("NATUREEATER", 9, 0, 12.5f, 5.0f, 25);
	public NatureEater() {
		super(NatureEater);
		this.setUnlocalizedName("natureeater");
		this.setCreativeTab(TabLoader.tab);
		this.bFull3D=true;
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(new ChatComponentTranslation("item.natureeater.tooltip").getFormattedText());
	}
	
}
