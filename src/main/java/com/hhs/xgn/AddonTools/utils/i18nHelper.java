package com.hhs.xgn.AddonTools.utils;

import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.ChatComponentTranslation;

public class i18nHelper {
	/**
	 * Translate the language file.
	 * @param ls-the key
	 * @return the string
	 */
	public static String translate(String ls){
		return new ChatComponentTranslation(ls).getFormattedText();
	}
}
