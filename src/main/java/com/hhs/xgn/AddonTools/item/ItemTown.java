package com.hhs.xgn.AddonTools.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTown {
	
	public static final String TestItemID="testitem";
	public static final String UnbreakablePickaxeID="unbreakablepickaxe";
	public static final String NatureEaterID="natureeater";
	public static final String FakeWoodID="fakewood";
	public static final String LostSwordID="lostsword";
	public static final String DinnerHoeID="dinnerhoe";
	public static final String EndlessWaterID="endlesswater";
	public static final String EndlessLavaID="endlesslava";
	public static final String VoidBucketID="voidbucket";
	public static final String UpgradeCoreID="upgradecore";
	public static final String LapisNuggetID="lapisnugget";
	public static final String InstantCakeID="instantcake";
	public static final String InstantMeatCakeID="instantmeatcake";
	public static final String DrinkingStickID="drinkingstick";
	public static final String WaterStickID="waterstick";
	public static final String LavaStickID="lavastick";
	public static final String MilkStickID="milkstick";
	public static final String ReturnCellID="returncell";
	public static final String InkStickID="inkstick";
	public static final String SoulBasicID="soulbasic";
	public static final String SoulFireID="soulfire";
	public static final String BookFlameID="bookflame";
	public static final String SatisfiedSteakID="satisfiedsteak";
	public static final String SoulWaterID="soulwater";
	public static final String BookAquaID="bookaqua";
	public static final String BookWoodID="bookwood";
	public static final String SoulWoodID="soulwood";
	public static final String SoulVoidID="soulvoid";
	public static final String BookVoidID="bookvoid";
	public static final String SuperSaddleID="supersaddle";
	public static final String HandExpSpawnerID="handexpspawner";
	public static final String AngerStickID="angerstick";
	public static final String HandNetherPortalID="handnetherportal";
	public static final String MobMoverID="mobmover";
	public static final String PilotStickID="pilotstick";
	
	public static TestItem TestItem = new TestItem();
	public static UnbreakablePickaxe up=new UnbreakablePickaxe();//unbreakable pickaxe
	public static NatureEater ne=new NatureEater();//Nature Eater
	public static FakeWood fw=new FakeWood();//Fake Wood
	public static LostSword ls=new LostSword();//Lost Sword
	public static DinnerHoe dh=new DinnerHoe();//Dinner Hoe
	public static EndlessWater ew=new EndlessWater();//Endless Water (Bucket)
	public static EndlessLava el=new EndlessLava();//Endless Lava(Bucket)
	public static VoidBucket vb=new VoidBucket();//Void Bucket
	public static UpgradeCore uc=new UpgradeCore();//Upgrade Core
	public static LapisNugget ln=new LapisNugget();//Lapis Nugget
	public static InstantCake ic=new InstantCake();//instant cake
	public static InstantMeatCake imc=new InstantMeatCake();//Instant Meat Cake
	public static DrinkingStick ds=new DrinkingStick();//Drinking Stick
	public static WaterStick ws=new WaterStick();//Water Stick
	public static LavaStick ls_=new LavaStick();//Lava Stick
	public static MilkStick ms=new MilkStick();//Milk Stick
	public static ReturnCell rc=new ReturnCell();//Return Cell
	public static InkStick is=new InkStick();//Ink Stick
	public static SoulBasic sb=new SoulBasic();//Soul Basic
	public static SoulFire sf=new SoulFire();//Soul Fire
	public static BookFlame bf=new BookFlame();//Book Flame
	public static SatisfiedSteak ss=new SatisfiedSteak();//Satisfied Steak
	public static SoulWater sw=new SoulWater();//Soul Water
	public static BookAqua ba=new BookAqua();//Book Aqua
	public static SoulWood sw_=new SoulWood();//Soul Wood
	public static BookWood bw=new BookWood();//Book Wood
	public static SoulVoid sv=new SoulVoid();//Soul Void
	public static BookVoid bv=new BookVoid();//Book Void
	public static SuperSaddle ss_=new SuperSaddle();//Super Saddle
	public static HandExpSpawner hes=new HandExpSpawner();//Hand Exp Spawner
	public static AngerStick as=new AngerStick();//Anger Stick
	public static HandNetherPortal hnp=new HandNetherPortal();//Hand Nether Portal
	public static MobMover mm=new MobMover(); //Mob Mover
	public static PilotStick ps=new PilotStick(); //Pilot Stick
	
    public ItemTown(FMLPreInitializationEvent event)
    {
    	//TODO Register Items Here
        register(TestItem, TestItemID);
        register(up,UnbreakablePickaxeID);
        register(ne,NatureEaterID);
        register(fw,FakeWoodID);
        register(ls,LostSwordID);
        register(dh,DinnerHoeID);
        register(ew,EndlessWaterID);
        register(el,EndlessLavaID);
        register(vb,VoidBucketID);
        register(uc,UpgradeCoreID);
        register(ln,LapisNuggetID);
        register(ic,InstantCakeID);
        register(imc,InstantMeatCakeID);
        register(ds,DrinkingStickID);
        register(ws,WaterStickID);
        register(ls_,LavaStickID);
        register(ms,MilkStickID);
        register(rc,ReturnCellID);
        register(is,InkStickID);
        register(sb,SoulBasicID);
        register(sf,SoulFireID);
        register(bf,BookFlameID);
        register(ss,SatisfiedSteakID);
        register(sw,SoulWaterID);
        register(ba,BookAquaID);
        register(sw_,SoulWoodID);
        register(bw,BookWoodID);
        register(sv,SoulVoidID);
        register(bv,BookVoidID);
        register(ss_,SuperSaddleID);
        register(hes,HandExpSpawnerID);
        register(as,AngerStickID);
        register(hnp,HandNetherPortalID);
        register(mm,MobMoverID);
        register(ps,PilotStickID);
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item, name);
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
    	//TODO Register Renders here
        registerRender(TestItem);
        registerRender(up);
        registerRender(ne);
        registerRender(fw);
        registerRender(ls);
        registerRender(dh);
        registerRender(ew);
        registerRender(el);
        registerRender(vb);
        registerRender(uc);
        registerRender(ln);
        registerRender(ic);
        registerRender(imc);
        registerRender(ds);
        registerRender(ws);
        registerRender(ls_);
        registerRender(ms);
        registerRender(rc);
        registerRender(is);
        registerRender(sb);
        registerRender(sf);
        registerRender(bf);
        registerRender(ss);
        registerRender(sw);
        registerRender(ba);
        registerRender(sw_);
        registerRender(bw);
        registerRender(sv);
        registerRender(bv);
        registerRender(ss_);
        registerRender(hes);
        registerRender(as);
        registerRender(hnp);
        registerRender(mm);
        registerRender(ps);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        String name = GameData.getItemRegistry().getNameForObject(item).toString();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
    }

}
