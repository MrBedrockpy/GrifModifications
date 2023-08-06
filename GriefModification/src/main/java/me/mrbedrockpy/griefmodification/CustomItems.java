package me.mrbedrockpy.griefmodification;

import me.mrbedrockpy.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public enum CustomItems {

    SUPER_TNT(
            new ItemBuilder(Material.TNT, 1)
                    .addEnchantment(Enchantment.DURABILITY, 1)
                    .displayName("Super TNT")
                    .build()
    ),

    ULTRA_TNT(
            new ItemBuilder(Material.TNT, 1)
                .addEnchantment(Enchantment.DURABILITY, 2)
                .displayName("Ultra TNT")
                .build()
    );

    private final ItemStack item;

    CustomItems(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }
}
