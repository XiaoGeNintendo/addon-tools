package com.hhs.xgn.AddonTools.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ReturnerContainer extends Container {
	IInventory items = new InventoryBasic("returner", true, 2);
	// IInventory items2=new InventoryBasic("returner2",true,1);
	Slot s1;
	Slot s2;

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		return null;
	}

	public ReturnerContainer(EntityPlayer player) {
		super();

		this.addSlotToContainer(s1 = new Slot(items, 0, 56, 30) {

			@Override
			public void onSlotChanged() {
				super.onSlotChanged();
				if (this.getStack() != null) {
					s2.putStack(new ItemStack(this.getStack().getItem(), this.getStack().stackSize, 0));
				} else {
					s2.putStack(null);
				}
			}

		});
		this.addSlotToContainer(s2 = new Slot(items, 1, 110, 30) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
				s1.putStack(this.getStack());
			}
		});

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 74 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 132));
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		if (s1.getStack() != null) {
			playerIn.dropItem(s1.getStack(), false, true);
		}
	}

}
