package com.example.chatgptorb;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ChatScreen extends Screen {
    protected ChatScreen(Component title) {
        super(title);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }
}