package com.enderdevelopment.chatgptorb.client;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ChatScreen extends Screen {
    private static final ResourceLocation CHAT_SCREEN_TEXTURE = new ResourceLocation("chatgptorb", "textures/gui/chat_screen.png");

    public ChatScreen() {
        super(Component.literal("Chat Screen"));
    }

    @Override
    protected void init() {
        super.init();
        // Initialize the chat screen
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        // Render the chat screen
    }
}