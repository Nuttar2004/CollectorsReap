package net.brdle.collectorsreap.compat;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;
import java.util.function.Supplier;

public class ModCompat {

	@Nullable public static CreativeModeTab getNDTab() {
		return ifLoaded("nethersdelight", NDCompat.CREATIVE_TAB);
	}

	@Nullable public static CreativeModeTab ifLoaded(String modid, CreativeModeTab tab) {
		return ifLoaded(modid, () -> tab);
	}

	@Nullable public static CreativeModeTab ifLoaded(String modid, Supplier<CreativeModeTab> tab) {
		if (ModList.get().isLoaded(modid)) {
			return tab.get();
		} else {
			return null;
		}
	}

	public static Supplier<MobEffect> getCaffeinated() {
		return (ModList.get().isLoaded("farmersrespite")) ? FarmersRespiteCompat.CAFFEINATED : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getAgility() {
		return (ModList.get().isLoaded("neapolitan")) ? NeapolitanCompat.AGILITY : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getVanillaScent() {
		return (ModList.get().isLoaded("neapolitan")) ? NeapolitanCompat.VANILLA_SCENT : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getSugarRush() {
		return (ModList.get().isLoaded("neapolitan")) ? NeapolitanCompat.SUGAR_RUSH : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getBerserking() {
		return (ModList.get().isLoaded("neapolitan")) ? NeapolitanCompat.BERSERKING : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getHarmony() {
		return (ModList.get().isLoaded("neapolitan")) ? NeapolitanCompat.HARMONY : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getSpitting() {
		return (ModList.get().isLoaded("atmospheric")) ? AtmosphericCompat.SPITTING : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getPersistence() {
		return (ModList.get().isLoaded("atmospheric")) ? AtmosphericCompat.PERSISTENCE : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getRelief() {
		return (ModList.get().isLoaded("atmospheric")) ? AtmosphericCompat.RELIEF : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getFallFlavor() {
		return (ModList.get().isLoaded("seasonals")) ? SeasonalsCompat.FALL_FLAVOR : () -> MobEffects.CONFUSION;
	}

	public static Supplier<MobEffect> getVitality() {
		return (ModList.get().isLoaded("respiteful")) ? RespitefulCompat.VITALITY : () -> MobEffects.DIG_SPEED;
	}

	public static Supplier<MobEffect> getTenacity() {
		return (ModList.get().isLoaded("respiteful")) ? RespitefulCompat.TENACITY : () -> MobEffects.DAMAGE_RESISTANCE;
	}

	public static Supplier<MobEffect> getMaturity() {
		return (ModList.get().isLoaded("respiteful")) ? RespitefulCompat.MATURITY : getCaffeinated();
	}
}
