package com.hhs.xgn.AddonTools.item;

import java.util.List;

import com.hhs.xgn.AddonTools.others.TabLoader;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.util.EnumHelper;

public class UnbreakablePickaxe extends ItemPickaxe{
	//PickaxeRealDamage=MaterialDamage+2
	public static final ToolMaterial Unbreakable=EnumHelper.addToolMaterial("UNBREAKABLE", 5, 0, 12.5f, 6.0f, 25);
	public UnbreakablePickaxe(){
		super(Unbreakable);
		this.setUnlocalizedName("unbreakablepickaxe");
		this.setMaxDamage(0);
		
		this.setHarvestLevel("pickaxe", 9);
		this.bFull3D=true;
		//this.maxStackSize=1;
		this.setCreativeTab(TabLoader.tab);
	}


	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(new ChatComponentTranslation("item.unbreakablepickaxe.tooltip").getFormattedText());
	}
	
}
