package com.Phoenix76.MOD123;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;

import org.lwjgl.glfw.*;

import java.util.ArrayList;
import java.util.List;
public class KeybindCoords {

    private static KeyBinding keyBinding;

    public List<Double> getCoords() {

        Vec3d selfPos = MinecraftClient.getInstance().player.getPos();
        double x = selfPos.x;
        double y = selfPos.y;
        double z = selfPos.z;
        System.out.println(x);
        List<Double> posArray = new ArrayList<>();
        posArray.add(x);
        posArray.add(y);
        posArray.add(z);
        return posArray;
    }

    public void registerKeybind() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.MOD123.coords", // The translation key of
                                                                                             // the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_F4, // The keycode of the key
                "category.MOD123.coords" // The translation key of the keybinding's category.
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            int counter = 1;
            while (keyBinding.wasPressed()) {
                if (counter == 1) {
                    KeybindCoords obj1 = new KeybindCoords();

                    List<Double> coords = obj1.getCoords();
                    double x = coords.get(0);
                    double y = coords.get(1);
                    double z = coords.get(2);
                    client.player.sendMessage(
                            new LiteralText(
                                    "X:" + Math.round(x) + " " + "Y:" + Math.round(y) + " " + "Z" + Math.round(z)),
                            false);

                    /*
                     * 
                     * while (true) { Vec3d selfPos1 =
                     * MinecraftClient.getInstance().player.getPos(); if (selfPos1.x != x ||
                     * selfPos1.y != y || selfPos1.z != z) {
                     * 
                     * coords = obj1.getCoords(); x = coords.get(0); y = coords.get(1); z =
                     * coords.get(2); client.player.sendMessage(new LiteralText( "X:" +
                     * Math.round(x) + " " + "Y:" + Math.round(y) + " " + "Z" + Math.round(z)),
                     * false);
                     * 
                     * }
                     * 
                     * else { try { // thread to sleep for 1000 milliseconds Thread.sleep(200); }
                     * catch (Exception e) { System.out.println(e); } } continue;
                     * 
                     * }
                     */
                    
                } else {
                    counter--;
                }
            }
        });
    }
}
