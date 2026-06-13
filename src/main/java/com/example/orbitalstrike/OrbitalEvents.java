package com.example.orbitalstrike;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class OrbitalEvents {
    public static void registerEvents() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);

            if (stack.getItem() == OrbitalItems.NUKE_SHOT) {
                triggerNukeShot(world, player);
                stack.decrement(1);
                world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                return ActionResult.SUCCESS;
            }

            if (stack.getItem() == OrbitalItems.STAB_SHOT) {
                triggerStabShot(world, player);
                stack.decrement(1);
                world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }

    private static BlockPos getTargetBlock(ServerPlayerEntity player) {
        // Get where the player is looking (up to 100 blocks away)
        Vec3d start = player.getEyePos();
        Vec3d direction = player.getRotationVector();
        Vec3d end = start.add(direction.x * 100, direction.y * 100, direction.z * 100);
        
        // Cast a ray from player's eyes in the direction they're looking
        var hitResult = player.getWorld().raycast(new net.minecraft.world.RaycastContext(
            start,
            end,
            net.minecraft.world.RaycastContext.ShapeType.OUTLINE,
            net.minecraft.world.RaycastContext.FluidHandling.NONE,
            player
        ));
        
        // If we hit something, use that position; otherwise use where they're looking far away
        if (hitResult.getType() != net.minecraft.util.hit.HitResult.Type.MISS) {
            return hitResult.getBlockPos();
        } else {
            // Default to 100 blocks in the direction they're looking
            return new BlockPos((int)end.x, (int)end.y, (int)end.z);
        }
    }

    private static void triggerNukeShot(World world, ServerPlayerEntity player) {
        BlockPos target = getTargetBlock(player);
        world.getServer().execute(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

            int rings = 15;
            int y = target.getY() + 50;
            for (int r = 3; r <= rings + 2; r++) {
                for (int angle = 0; angle < 360; angle += 10) {
                    double rad = Math.toRadians(angle);
                    int x = target.getX() + (int)(Math.cos(rad) * r);
                    int z = target.getZ() + (int)(Math.sin(rad) * r);
                    BlockPos pos = new BlockPos(x, y, z);
                    world.setBlockState(pos, net.minecraft.block.Blocks.TNT.getDefaultState());
                }
            }
            world.createExplosion(null, target.getX(), y, target.getZ(), 6.0F, World.ExplosionSourceType.TNT);
        });
    }

    private static void triggerStabShot(World world, ServerPlayerEntity player) {
        BlockPos target = getTargetBlock(player);
        world.getServer().execute(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

            for (int y = 319; y >= -64; y--) {
                BlockPos pos = new BlockPos(target.getX(), y, target.getZ());
                world.setBlockState(pos, net.minecraft.block.Blocks.TNT.getDefaultState());
                world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, World.ExplosionSourceType.TNT);
            }
        });
    }
}
