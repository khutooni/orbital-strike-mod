package com.example.orbitalstrike;

import net.fabricmc.api.ModInitializer;

public class OrbitalStrikeMod implements ModInitializer {
    public static final String MODID = "orbitalstrike";

    @Override
    public void onInitialize() {
        OrbitalItems.registerItems();
        OrbitalCommands.registerCommands();
        OrbitalEvents.registerEvents();
    }
}
