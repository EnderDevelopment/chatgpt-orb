package com.example.chatgptorb;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "chatgptorb", value = Dist.CLIENT)
public class ClientEvents {
    private static boolean orbVisible = false;
    private static OrbRenderer orbRenderer;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getKey() == 79 && event.getAction() == 1) { // O key
            if (orbVisible) {
                orbRenderer = new OrbRenderer();
                orbRenderer.renderOrb();
            } else {
                if (orbRenderer != null) {
                    orbRenderer.removeOrb();
                }
            }
            orbVisible = !orbVisible;
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && orbVisible && orbRenderer != null) {
            orbRenderer.updateOrbPosition();
        }
    }
}