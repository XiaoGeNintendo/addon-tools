package com.hhs.xgn.AddonTools.others;

import com.hhs.xgn.AddonTools.item.ItemTown;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AddonToolsTab extends CreativeTabs{

	public AddonToolsTab() {
		super("addontools");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return ItemTown.up;
	}

}
