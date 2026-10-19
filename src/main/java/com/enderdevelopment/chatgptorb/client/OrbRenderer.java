package com.enderdevelopment.chatgptorb.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class OrbRenderer extends EntityRenderer<Entity> {
    private static final ResourceLocation ORB_TEXTURE = new ResourceLocation("chatgptorb", "textures/gui/orb.png");

    public OrbRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.5D, 0.0D);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.scale(0.5F, 0.5F, 0.5F);
        Minecraft.getInstance().getTextureManager().bind(ORB_TEXTURE);
        // Render the orb
        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return ORB_TEXTURE;
    }
}