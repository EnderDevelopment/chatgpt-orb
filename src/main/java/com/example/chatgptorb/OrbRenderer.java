package com.example.chatgptorb;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "chatgptorb", value = Dist.CLIENT)
public class OrbRenderer {
    private static final Minecraft mc = Minecraft.getInstance();
    private static Entity orbEntity;

    public void renderOrb() {
        orbEntity = new Entity(mc.level, 0, 0, 0) {};
        mc.level.addFreshEntity(orbEntity);
    }

    public void removeOrb() {
        if (orbEntity != null) {
            mc.level.removeEntity(orbEntity.getId());
            orbEntity = null;
        }
    }

    public void updateOrbPosition() {
        if (orbEntity != null && mc.player != null) {
            double x = mc.player.getX() + Math.sin(mc.player.tickCount * 0.1) * 2;
            double y = mc.player.getY() + mc.player.getEyeHeight() + 1;
            double z = mc.player.getZ() + Math.cos(mc.player.tickCount * 0.1) * 2;
            orbEntity.setPos(x, y, z);
        }
    }

    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && orbEntity != null) {
            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource bufferSource = mc.renderBuffers().bufferSource();
            EntityRenderDispatcher dispatcher = mc.getEntityRenderDispatcher();
            dispatcher.render(orbEntity, 0, 0, 0, 0, event.getPartialTick(), poseStack, bufferSource, 15728880);
            bufferSource.endBatch();
        }
    }
}