package com.brewinandchewin.common.item;

import com.brewinandchewin.core.registry.BCEffects;
import com.brewinandchewin.core.registry.BCItems;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class BoozeItem extends DrinkableItem {
	
	private final int potency;
	private final int duration;
	private final float percentage;

	public BoozeItem(int potency, int duration, float percentage, Properties properties) {
		super(properties);
		this.potency = potency;
		this.duration = duration;
		this.percentage = percentage;
	}

	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		if (consumer.hasEffect(BCEffects.TIPSY.get())) {
			MobEffectInstance effect = consumer.getEffect(BCEffects.TIPSY.get());
			if (Math.random() * 100 < percentage) {
			consumer.addEffect(new MobEffectInstance(BCEffects.TIPSY.get(), effect.getDuration() + (duration * 1200), effect.getAmplifier() + 1), consumer);
			
			} else if (!consumer.hasEffect(BCEffects.TIPSY.get())) {
			consumer.addEffect(new MobEffectInstance(BCEffects.TIPSY.get(), 8 * 1200, potency), consumer);
			}
		}
	}
}