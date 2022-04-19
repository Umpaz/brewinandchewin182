package com.brewinandchewin.common.crafting;

import javax.annotation.Nullable;

import com.brewinandchewin.core.BrewinAndChewin;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.entity.EnchantmentTableBlockEntity;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class KegRecipe implements Recipe<RecipeWrapper>
{
	public static RecipeType<KegRecipe> TYPE = RecipeType.register(BrewinAndChewin.MODID + ":cooking");
	public static final Serializer SERIALIZER = new Serializer();
	public static final int INPUT_SLOTS = 4;

	private final ResourceLocation id;
	private final String group;
	private final NonNullList<Ingredient> inputItems;
	private final ItemStack output;
	private final ItemStack liquid;
	private final ItemStack container;
	private final float experience;
	private final int cookTime;

	public KegRecipe(ResourceLocation id, String group, NonNullList<Ingredient> inputItems, ItemStack liquid, ItemStack output, ItemStack container, float experience, int cookTime) {
		this.id = id;
		this.group = group;
		this.inputItems = inputItems;
		this.output = output;
		this.liquid = liquid;

		if (!container.isEmpty()) {
			this.container = container;
		} else if (!output.getContainerItem().isEmpty()) {
			this.container = output.getContainerItem();
		} else {
			this.container = ItemStack.EMPTY;
		}

		this.experience = experience;
		this.cookTime = cookTime;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public String getGroup() {
		return this.group;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.inputItems;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}
	
	public ItemStack getLiquid() {
		return this.liquid;
	}

	public ItemStack getOutputContainer() {
		return this.container;
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv) {
		return this.output.copy();
	}

	public float getExperience() {
		return this.experience;
	}

	public int getCookTime() {
		return this.cookTime;
	}

	@Override
	public boolean matches(RecipeWrapper inv, Level worldIn) {
		java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
		int i = 0;

		for (int j = 0; j < INPUT_SLOTS; ++j) {
			ItemStack itemstack = inv.getItem(j);
			if (!itemstack.isEmpty()) {
				++i;
				inputs.add(itemstack);
			}
		}
		return i == this.inputItems.size() && net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs, this.inputItems) != null;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width * height >= this.inputItems.size();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return KegRecipe.SERIALIZER;
	}

	@Override
	public RecipeType<?> getType() {
		return KegRecipe.TYPE;
	}

	private static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<KegRecipe>
	{
		Serializer() {
			this.setRegistryName(new ResourceLocation(BrewinAndChewin.MODID, "cooking"));
		}

		@Override
		public KegRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			final String groupIn = GsonHelper.getAsString(json, "group", "");
			final NonNullList<Ingredient> inputItemsIn = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
			if (inputItemsIn.isEmpty()) {
				throw new JsonParseException("No ingredients for cooking recipe");
			} else if (inputItemsIn.size() > KegRecipe.INPUT_SLOTS) {
				throw new JsonParseException("Too many ingredients for cooking recipe! The max is " + KegRecipe.INPUT_SLOTS);
			} else {
				final ItemStack outputIn = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "result"), true);
				ItemStack liquid = GsonHelper.isValidNode(json, "liquid") ? CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "liquid"), true) : ItemStack.EMPTY;
				ItemStack container = GsonHelper.isValidNode(json, "container") ? CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "container"), true) : ItemStack.EMPTY;
				final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
				final int cookTimeIn = GsonHelper.getAsInt(json, "cookingtime", 200);
				return new KegRecipe(recipeId, groupIn, inputItemsIn, outputIn, liquid, container, experienceIn, cookTimeIn);
			}
		}

		private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
			NonNullList<Ingredient> nonnulllist = NonNullList.create();

			for (int i = 0; i < ingredientArray.size(); ++i) {
				Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
				if (!ingredient.isEmpty()) {
					nonnulllist.add(ingredient);
				}
			}

			return nonnulllist;
		}

		@Nullable
		@Override
		public KegRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			String groupIn = buffer.readUtf(32767);
			int i = buffer.readVarInt();
			NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < inputItemsIn.size(); ++j) {
				inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
			}

			ItemStack outputIn = buffer.readItem();
			ItemStack liquid = buffer.readItem();
			ItemStack container = buffer.readItem();
			float experienceIn = buffer.readFloat();
			int cookTimeIn = buffer.readVarInt();
			return new KegRecipe(recipeId, groupIn, inputItemsIn, outputIn, liquid, container, experienceIn, cookTimeIn);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, KegRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeVarInt(recipe.inputItems.size());

			for (Ingredient ingredient : recipe.inputItems) {
				ingredient.toNetwork(buffer);
			}

			buffer.writeItem(recipe.output);
			buffer.writeItem(recipe.liquid);
			buffer.writeItem(recipe.container);
			buffer.writeFloat(recipe.experience);
			buffer.writeVarInt(recipe.cookTime);
		}
	}
}
