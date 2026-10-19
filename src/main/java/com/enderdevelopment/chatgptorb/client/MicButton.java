package com.enderdevelopment.chatgptorb.client;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class MicButton extends Button {
    public MicButton(int x, int y, int width, int height, Component message, OnPress onPress) {
        super(x, y, width, height, message, onPress);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        super.render(poseStack, mouseX, mouseY, partialTicks);
        // Render the mic button
    }
}