package com.hhs.xgn.AddonTools.item;

import com.hhs.xgn.AddonTools.block.BlockLoader;

public class ItemRenderTown {
	 public ItemRenderTown(){
	     ItemTown.registerRenders();
	     BlockLoader.registerRenders();
	 }
}
