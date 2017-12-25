package com.hhs.xgn.AddonTools.item;

import java.util.List;
import java.util.Set;

import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.EnumHelper;

public class DinnerHoe extends ItemHoe {
	public static final ToolMaterial Dinner=EnumHelper.addToolMaterial("DINNER", 9, 0, 12.5f, 5.0f, 25);
	public DinnerHoe() {
		super(Dinner);
		this.setUnlocalizedName("dinnerhoe");
		this.bFull3D=true;
		this.setCreativeTab(TabLoader.tab);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(new ChatComponentTranslation("item.dinnerhoe.tooltip").getFormattedText());
	}

}
