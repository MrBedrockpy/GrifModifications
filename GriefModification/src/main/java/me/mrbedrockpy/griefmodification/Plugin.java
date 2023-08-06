package me.mrbedrockpy.griefmodification;

import me.mrbedrockpy.griefmodification.events.TntEvents;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Plugin extends JavaPlugin {

    public static Plugin instance;

    public ItemStack superTnt, ultraTnt;

    public FileConfiguration config;

    @Override
    public void onEnable() {

        instance = this;

        initRecipes();

        getServer().getPluginManager().registerEvents(new TntEvents(), this);

        config = getConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return instance;
    }

    public void initRecipes() {

        superTnt = CustomItems.SUPER_TNT.getItem();

        ultraTnt = CustomItems.ULTRA_TNT.getItem();

        ShapedRecipe superTntRecipe, ultraTntRecipe;

        superTntRecipe = new ShapedRecipe(Objects.requireNonNull(NamespacedKey.fromString("super_tnt")), superTnt);

        superTntRecipe.shape(
                " G ",
                "GTG",
                " G "
        );

        superTntRecipe.setIngredient('T', Material.TNT);
        superTntRecipe.setIngredient('G', Material.GUNPOWDER);

        ultraTntRecipe = new ShapedRecipe(Objects.requireNonNull(NamespacedKey.fromString("ultra_tnt")), ultraTnt);

        ultraTntRecipe.shape(
                "GGG",
                "GTG",
                "GGG"
        );

        ultraTntRecipe.setIngredient('T', Material.TNT);
        ultraTntRecipe.setIngredient('G', Material.GUNPOWDER);

        getServer().addRecipe(superTntRecipe);
        getServer().addRecipe(ultraTntRecipe);

    }
}
