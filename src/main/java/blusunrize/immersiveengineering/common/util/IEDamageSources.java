package blusunrize.immersiveengineering.common.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import blusunrize.immersiveengineering.common.entities.EntityRevolvershot;

import com.emoniph.witchery.util.EntityDamageSourceIndirectSilver;

public class IEDamageSources
{
	public static class IEDamageSource_Indirect extends EntityDamageSourceIndirect
	{
		public IEDamageSource_Indirect(String tag, Entity shot, Entity shooter)
		{
			super(tag, shot, shooter);
		}
	}
	public static class IEDamageSource_Direct extends EntityDamageSource
	{
		public IEDamageSource_Direct(String tag, Entity attacker)
		{
			super(tag, attacker);
		}
	}
	public static class IEDamageSource extends DamageSource
	{
		public IEDamageSource(String tag)
		{
			super(tag);
		}
	}

	public static DamageSource causeCasullDamage(EntityRevolvershot shot, Entity shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverCasull, shot, shooter).setProjectile();
	}
	public static DamageSource causePiercingDamage(EntityRevolvershot shot, Entity shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverAP, shot, shooter).setDamageBypassesArmor().setProjectile();
	}
	public static DamageSource causeBuckshotDamage(EntityRevolvershot shot, Entity shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverBuck, shot, shooter).setProjectile();
	}
	public static DamageSource causeDragonsbreathDamage(EntityRevolvershot shot, Entity shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverDragon, shot, shooter).setFireDamage().setProjectile();
	}
	public static DamageSource causeHomingDamage(EntityRevolvershot shot, Entity shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverHoming, shot, shooter).setProjectile();
	}
	public static DamageSource causeWolfpackDamage(EntityRevolvershot shot, Entity shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverWolfpack, shot, shooter).setProjectile();
	}
	public static DamageSource causeSilverDamage(EntityRevolvershot shot, Entity shooter)
	{
		EntityDamageSourceIndirectSilver silver = new EntityDamageSourceIndirectSilver(shot, shooter);
		silver.setProjectile();
		silver.damageType = Lib.DMG_RevolverSilver;
		return silver;
	}
	public static DamageSource causePotionDamage(EntityRevolvershot shot, EntityLivingBase shooter)
	{
		return new IEDamageSource_Indirect(Lib.DMG_RevolverPotion, shot, shooter).setProjectile();
	}

	public static DamageSource causeAcidDamage()
	{
		return new IEDamageSource(Lib.DMG_Acid);
	}

	public static DamageSource causeCrusherDamage()
	{
		return new IEDamageSource(Lib.DMG_Crusher);
	}
}