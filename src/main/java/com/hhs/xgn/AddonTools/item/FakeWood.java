package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.EnumHelper;

public class FakeWood extends ItemAxe {
	//AxeRealDamage=MaterialDamage+3
	public static final ToolMaterial FakeWood=EnumHelper.addToolMaterial("FAKEWOOD", 9, 0, 12.5f, 6.0f, 25);
	public FakeWood(){
		super(FakeWood);
		this.bFull3D=true;
		this.setUnlocalizedName("fakewood");
		this.setCreativeTab(TabLoader.tab);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// TODO Auto-generated method stub
		tooltip.add(new ChatComponentTranslation("item.fakewood.tooltip").getFormattedText());
	}
}
