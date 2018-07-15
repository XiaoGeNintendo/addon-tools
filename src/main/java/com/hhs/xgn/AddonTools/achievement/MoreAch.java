package com.hhs.xgn.AddonTools.achievement;

import com.hhs.xgn.AddonTools.item.ItemTown;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
/**
 * <b> table<b><br/>
 * Y(Negative)<br/>
 * ^<br/>
 * |<br/>
 * |<br/>
 * |<br/>
 * +------> X(Positive)<br/>
 * |<br/>
 * |<br/>
 * |<br/>
 * @author XGN
 *
 */
public class MoreAch {
	/**
	 * New starting
	 */
	public static Achievement a=ach("newstarting",0,0,ItemTown.sb,AchievementMainClass.e);
	/**
	 * Hot Heart
	 */
	public static Achievement b=ach("hotheart",0,2,ItemTown.sf,a);
	/**
	 * With the great flame!
	 * realname:flame
	 */
	public static Achievement c=ach("flame", 0,4, ItemTown.bf, b);
	/**
	 * Wave
	 */
	public static Achievement d=ach("wave",2,0,ItemTown.sw,a);
	/**
	 * Take a shower
	 * realname:shower
	 */
	public static Achievement e=ach("shower",4,0,ItemTown.ba,d);
	/**
	 * New Adventure
	 * realname:adv
	 */
	public static Achievement f=ach("adv",0,-2,ItemTown.sw_,a);
	/**
	 * KFG
	 */
	public static Achievement g=ach("kfg",0,-4,ItemTown.bw,f);
	/**
	 * Once the last
	 * realname:once
	 */
	public static Achievement h=ach("once",-2,0,ItemTown.sv,a);
	/**
	 * Eat
	 */
	public static Achievement i=ach("eat",-4,0,ItemTown.bv,h);
	/**
	 * Slain The God!
	 * realname:slay
	 */
	public static Achievement j=ach("slay",0,-6,ItemTown.ls,g);
	/**
	 * Angry Zombie
	 */
	public static Achievement k=ach("angryzombie",1,3,ItemTown.as,b);
	
	
	public AchievementPage page=new AchievementPage("Addon Tools Soul",a,b,c,d,e,f,g,h,i,j,k);
	public MoreAch(){
		page.registerAchievementPage(page);
		a.setSpecial().registerStat();
		b.registerStat();
		c.registerStat();
		d.registerStat();
		e.registerStat();
		//f.setSpecial().registerStat();
		f.registerStat();
		g.registerStat();
		h.setSpecial().registerStat();
		i.setSpecial().registerStat();
		j.setSpecial().registerStat();
		k.registerStat();
	}
	
	
	private static Achievement ach(String name,int x,int y,Item r2,Achievement before){
		return new Achievement("achievement.addontools."+name,"addontools."+name,x,y,r2,before);
	}
	private static Achievement ach(String name,int x,int y,Block r2,Achievement before){
		return new Achievement("achievement.addontools."+name,"addontools."+name,x,y,r2,before);
	}
}
