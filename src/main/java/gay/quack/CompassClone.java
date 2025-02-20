package gay.quack;

import net.fabricmc.api.ModInitializer;

import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompassClone implements ModInitializer {
	public static final String MOD_ID = "compass_clone";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.RECIPE_TYPE, Identifier.of(MOD_ID, "compass_clone"), new RecipeType<CompassCloneRecipe>() {
			@Override
			public String toString() {
				return "compass_clone";
			}
		});
		Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MOD_ID, "compass_clone"), new SpecialCraftingRecipe.SpecialRecipeSerializer<>(CompassCloneRecipe::new));

		LOGGER.info("Let's clone some compasses!");
	}
}