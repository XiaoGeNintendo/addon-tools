package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.EnumHelper;

public class LostSword extends ItemSword {
	public static final ToolMaterial Lost=EnumHelper.addToolMaterial("LOST", 9, 0, 12.5f, 6.0f, 25);
	public LostSword() {
		super(Lost);
		this.setUnlocalizedName("lostsword");
		this.setCreativeTab(TabLoader.tab);
		this.bFull3D=true;
		
	}
	

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(new ChatComponentTranslation("item.lostsword.tooltip").getFormattedText());
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumAction.BLOCK;
	}
}
