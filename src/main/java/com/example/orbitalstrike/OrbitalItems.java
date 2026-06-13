package com.example.orbitalstrike;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OrbitalItems {
    public static Item NUKE_SHOT;
    public static Item STAB_SHOT;

    public static void registerItems() {
        NUKE_SHOT = Registry.register(Registry.ITEM, new Identifier(OrbitalStrikeMod.MODID, "nuke_shot"),
                new Item(new Item.Settings().maxDamage(1).group(ItemGroup.COMBAT)) {
                    @Override
                    public Text getName(ItemStack stack) {
                        return Text.literal("Nuke Shot");
                    }
                });

        STAB_SHOT = Registry.register(Registry.ITEM, new Identifier(OrbitalStrikeMod.MODID, "stab_shot"),
                new Item(new Item.Settings().maxDamage(1).group(ItemGroup.COMBAT)) {
                    @Override
                    public Text getName(ItemStack stack) {
                        return Text.literal("Stab Shot");
                    }
                });
    }
}
