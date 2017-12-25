package com.hhs.xgn.AddonTools.others;

import com.hhs.xgn.AddonTools.block.BlockLoader;
import com.hhs.xgn.AddonTools.item.ItemTown;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingStation {
	public CraftingStation(){
		ItemStack lapis=new ItemStack(Item.getByNameOrId("351"));
		lapis.setItemDamage(4);
		//TODO ADD CRAFTING HERE
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.up,1),new Object[]{"aaa","aaa","aaa",'a',Items.diamond_pickaxe});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ne,1), new Object[]{"aaa","aaa","aaa",'a',Items.diamond_shovel});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.fw,1), new Object[]{"aaa","aaa","aaa",'a',Items.diamond_axe});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ls,1), new Object[]{"aaa","aaa","aaa",'a',Items.diamond_sword});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.dh,1), new Object[]{"aaa","aaa","aaa",'a',Items.diamond_hoe});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ew), new Object[]{"aaa","aaa","aaa",'a',Items.water_bucket});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.el), new Object[]{"aaa","aaa","aaa",'a',Items.lava_bucket});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.ln,9),lapis);
		GameRegistry.addShapedRecipe(lapis, new Object[]{"aaa","aaa","aaa",'a',ItemTown.ln});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.uc,3), new Object[]{
				"aba",
				"bcb",
				"aba",
				'a',Items.gold_nugget,
				'b',ItemTown.ln,
				'c',Item.getItemFromBlock(Blocks.iron_block)
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.vb,1),new Object[]{
			"aaa",
			"aba",
			"aaa",
			'a',Items.bucket,
			'b',ItemTown.uc
		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.ic),new ItemStack(Items.cake,1),new ItemStack(ItemTown.uc,1));
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ic),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',Items.bread,
				'b',ItemTown.uc
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ws,8),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',ItemTown.ds,
				'b',Items.water_bucket
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ls_,8),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',ItemTown.ds,
				'b',Items.lava_bucket
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ms,8),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',ItemTown.ds,
				'b',Items.milk_bucket
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.rc),new Object[]{
			"aab",
			"aab",
			"bbc",
			'a',Items.gold_ingot,
			'b',Items.nether_star,
			'c',Item.getItemFromBlock(Blocks.iron_block)
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.is,8),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',ItemTown.ds,
				'b',Items.dye
		});
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.r,1),new Object[]{
				"aba",
				"aca",
				"aba",
				'a',ItemTown.rc,
				'b',ItemTown.uc,
				'c',Blocks.iron_block
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.sb,2), new Object[]{
				"aa ",
				"abc",
				" cc",
				'a',ItemTown.ln,
				'b',ItemTown.uc,
				'c',Items.gold_nugget
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.sf,1),new Object[]{
				"aaa",
				"bcb",
				"ded",
				'a',ItemTown.ls_,
				'b',Items.lava_bucket,
				'c',ItemTown.sb,
				'd',Blocks.netherrack,
				'e',ItemTown.uc
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.sw,1),new Object[]{
				"aaa",
				"bcb",
				"aaa",
				'a',Blocks.sponge,
				'b',Items.water_bucket,
				'c',ItemTown.sb
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.sw_,1),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',Blocks.sapling,
				'b',ItemTown.sb 
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.sv,1),new Object[]{
				"aba",
				"cde",
				"afa",
				'a',ItemTown.sb,
				'b',Items.emerald,
				'c',Blocks.sponge,
				'd',Items.nether_star,
				'e',Blocks.obsidian,
				'f',ItemTown.uc,
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ss_,1),new Object[]{
				"aaa",
				"aaa",
				"aaa",
				'a',Items.saddle
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.hes,1),new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',Items.book,
				'b',ItemTown.uc
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.as), new Object[]{
				" a ",
				" b ",
				" b ",
				'a',ItemTown.sf,
				'b',Items.stick
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.hnp), new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',Blocks.obsidian,
				'b',ItemTown.uc
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.mm), new Object[]{
				"aaa",
				"aba",
				"aaa",
				'a',Blocks.iron_bars,
				'b',ItemTown.uc
		});
		GameRegistry.addShapedRecipe(new ItemStack(ItemTown.ps),new Object[]{
				" a ",
				" b ",
				" b ",
				'a',ItemTown.bw,
				'b',Items.stick
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.cb,64),new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.bv),new ItemStack(Items.book,1),new ItemStack(ItemTown.uc,1),new ItemStack(ItemTown.sv),new ItemStack(ItemTown.bf,1),new ItemStack(ItemTown.ba,1),new ItemStack(ItemTown.bw,1));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.bw),new ItemStack(Items.book,1),new ItemStack(ItemTown.uc,1),new ItemStack(ItemTown.sw_));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.bf),new ItemStack(Items.book,1),new ItemStack(ItemTown.uc,1),new ItemStack(ItemTown.sf));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.ba),new ItemStack(Items.book,1),new ItemStack(ItemTown.uc,1),new ItemStack(ItemTown.sw));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.imc),new ItemStack(ItemTown.uc,1),new ItemStack(Items.bone,1),new ItemStack(ItemTown.ic));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.imc),new ItemStack(ItemTown.uc,1),new ItemStack(Items.beef,1),new ItemStack(ItemTown.ic));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.imc),new ItemStack(ItemTown.uc,1),new ItemStack(Items.porkchop,1),new ItemStack(ItemTown.ic));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.imc),new ItemStack(ItemTown.uc,1),new ItemStack(Items.mutton,1),new ItemStack(ItemTown.ic));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.ds),new ItemStack(Items.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemTown.ss), new ItemStack(Items.cooked_beef),new ItemStack(ItemTown.uc),new ItemStack(Items.slime_ball));
		
	}
	private void sr(ItemStack i,Object... o){
		GameRegistry.addShapedRecipe(i, o);
	}
}
