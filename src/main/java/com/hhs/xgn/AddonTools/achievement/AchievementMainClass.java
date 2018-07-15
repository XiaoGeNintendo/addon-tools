package com.hhs.xgn.AddonTools.achievement;

import com.hhs.xgn.AddonTools.block.BlockLoader;
import com.hhs.xgn.AddonTools.block.Returner;
import com.hhs.xgn.AddonTools.item.ItemTown;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementMainClass {
	/**
	 * For dinner
	 */
	public static Achievement a=new Achievement("achievement.addontools.fordinner","addontools.fordinner", -2, 0, (ItemTown.dh),null);
	/**
	 * Not wood
	 */
	public static Achievement b=new Achievement("achievement.addontools.notwood","addontools.notwood",-1,0,(ItemTown.fw),null);
	/**
	 * Lost and found
	 */
	public static Achievement c=new Achievement("achievement.addontools.lostandfound","addontools.lostandfound",1,0,(ItemTown.ls),null);
	/**
	 * Mine Happily
	 */
	public static Achievement d=new Achievement("achievement.addontools.minehappily","addontools.minehappily",2,0,(ItemTown.up),null);
	/**
	 * Lucky Day
	 */
	public static Achievement e=new Achievement("achievement.addontools.luckyday","addontools.luckyday",0,2,ItemTown.ln,null);
	/**
	 * Upgrade Now
	 */
	public static Achievement f=new Achievement("achievement.addontools.upgradenow","addontools.upgradenow",0,0,ItemTown.uc,e);
	/**
	 * Best food ever
	 */
	public static Achievement g=new Achievement("achievement.addontools.bestfoodever","addontools.bestfoodever",0,-2,ItemTown.ic,f);
	/**
	 * Puppy Love
	 */
	public static Achievement h=new Achievement("achievement.addontools.puppylove","addontools.puppylove",2,-2,ItemTown.imc,g);
	/**
	 * !(Delicious)
	 * Realname:delicious
	 */
	public static Achievement i=new Achievement("achievement.addontools.delicious","addontools.delicious",-3,0,ItemTown.ne,null);
	/**
	 * Void's Calling
	 * Realname:voidcalling
	 */
	public static Achievement j=ach("voidcalling",-1,-1,ItemTown.vb,f);
	/**
	 * Swim Pool
	 */
	public static Achievement k=ach("swimpool",-2,-1,ItemTown.ew,null);
	/**
	 * No more nether
	 */
	public static Achievement l=ach("nomorenether",-3,-1,ItemTown.el,null);
	/**
	 * Clean and tidy
	 */
	public static Achievement m=ach("cleanandtidy",3,0,ItemTown.ds,null);
	/**
	 * Drinking good,feeling good
	 * Realname:dgfg
	 */
	public static Achievement n=ach("dgfg",3,2,ItemTown.ws,m);
	/**
	 * Nether Juice!
	 * Realname:netherjuice
	 */
	public static Achievement o=ach("netherjuice",5,0,ItemTown.ls_,m);
	/**
	 * MOO!
	 * Realname:moo
	 */
	public static Achievement p=ach("moo",4,-1,ItemTown.ms,m);
	/**
	 * Backup
	 */
	public static Achievement q=ach("backup",5,2,ItemTown.rc,null);
	/**
	 * 8=Inf.
	 * realname:inf
	 */
	public static Achievement s=ach("inf",3,3,BlockLoader.r,q);
	/**
	 * The sea of knowledge
	 * Realname:tsok
	 */
	public static Achievement r=ach("tsok",3,-2,ItemTown.is,m);
	/**
	 * Welcome to Minecraft with Addon Tools
	 * Realname:mc
	 */
	public static Achievement t=ach("mc",2,-1,Blocks.grass,null);
	/**
	 * Hello,Addon Tools!
	 * realname:mca
	 */
	public static Achievement u=ach("mca",1,-1,ItemTown.sb,null);
	
	
	/**
	 * I am eating!
	 * realname:iae
	 */
	public static Achievement y=ach("iae",-1,-2,ItemTown.ss,null);
	/**
	 * $s
	 * realname:strings
	 */
	public static Achievement z=ach("strings",5,1,BlockLoader.cb,null);
	/**
	 * Pig Rider!
	 */
	public static Achievement aa=ach("pigrider",4,1,ItemTown.ss_,null);
	/**
	 * Swing!
	 */
	public static Achievement ab=ach("swing",5,-1,ItemTown.hes,null);
	/**
	 * Full Of Experience
	 * realname:foe
	 */
	public static Achievement ac=ach("foe",7,-1,Items.experience_bottle,ab);
	/**
	 * GO DOWN THE HELL
	 * realname:hell
	 */
	public static Achievement ad=ach("hell",2,1,ItemTown.hnp,null);
	/**
	 * I'm movin' it
	 * realname:moving
	 */
	public static Achievement ae=ach("moving",1,1,ItemTown.mm,null);
	/**
	 * Get abroad
	 * realname:pilot 
	 */
	public static Achievement af=ach("pilot",1,2,ItemTown.ps,null);
	
	/**
	 * Sorry the sword is mine
	 * realname:minesword
	 */
	public static Achievement ag=ach("minesword",-1,1,ItemTown.ns,null);
	
	/**
	 * Master of romance
	 * realname:mor
	 */
	public static Achievement ah=ach("mor",-2,1,ItemTown.sg,null);
	
	public static AchievementPage page=new AchievementPage("Addon Tools", a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,y,z,aa,ab,ac,ad,ae,af,ag,ah);
	public AchievementMainClass(){
		a.initIndependentStat().registerStat();
		b.initIndependentStat().registerStat();
		c.initIndependentStat().registerStat();
		d.initIndependentStat().registerStat();
		e.initIndependentStat().registerStat();
		f.setSpecial().registerStat();
		g.registerStat();
		h.registerStat();
		i.initIndependentStat().registerStat();
		j.registerStat();
		k.initIndependentStat().registerStat();
		l.initIndependentStat().registerStat();
		m.initIndependentStat().registerStat();
		n.registerStat();
		o.registerStat();
		p.registerStat();
		q.initIndependentStat().registerStat();
		r.registerStat();
		s.setSpecial().registerStat();
		t.setSpecial().initIndependentStat().registerStat();
		u.setSpecial().initIndependentStat().registerStat();
		y.initIndependentStat().registerStat();
		z.initIndependentStat().registerStat();
		aa.initIndependentStat().registerStat();
		ab.initIndependentStat().registerStat();
		ac.setSpecial().registerStat();
		ad.initIndependentStat().registerStat();
		ae.initIndependentStat().registerStat();
		af.initIndependentStat().registerStat();
		ag.initIndependentStat().registerStat();
		ah.initIndependentStat().registerStat();
		AchievementPage.registerAchievementPage(page);
	}
	private static Achievement ach(String name,int x,int y,Item r2,Achievement before){
		return new Achievement("achievement.addontools."+name,"addontools."+name,x,y,r2,before);
	}
	private static Achievement ach(String name,int x,int y,Block r2,Achievement before){
		return new Achievement("achievement.addontools."+name,"addontools."+name,x,y,r2,before);
	}
}

