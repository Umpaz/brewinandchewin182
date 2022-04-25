package com.brewinandchewin.common.item;

import com.brewinandchewin.core.registry.BCEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class DreadNogItem extends BoozeItem {

	public DreadNogItem(int potency, int duration, float percentage, Properties properties) {
		super(potency, duration, percentage, properties);
	}
	
	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		MobEffectInstance effect = consumer.getEffect(MobEffects.BAD_OMEN);
		if (!consumer.hasEffect(MobEffects.BAD_OMEN)) {
			consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0), consumer);
		}
		else if (effect.getAmplifier() < 2) {
			consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, effect.getDuration(), effect.getAmplifier() + 1), consumer);
		}
		if (consumer.hasEffect(BCEffects.TIPSY.get())) {
			MobEffectInstance tipsy = consumer.getEffect(BCEffects.TIPSY.get());
			consumer.addEffect(new MobEffectInstance(BCEffects.TIPSY.get(), tipsy.getDuration() + 200, tipsy.getAmplifier() + 1), consumer);
		} else if (!consumer.hasEffect(BCEffects.TIPSY.get())) {
			consumer.addEffect(new MobEffectInstance(BCEffects.TIPSY.get(), 1000, 0), consumer);
		}
	}
}
