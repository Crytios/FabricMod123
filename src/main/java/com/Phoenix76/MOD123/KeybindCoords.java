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
        private  boolean keyBindEnbaled;
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
        int counter = 1;
        public void registerKeybind() {
                keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.MOD123.coords",
                                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for
                                                       // mouse.
                                GLFW.GLFW_KEY_F4, // The keycode of the key
                                "category.MOD123.coords" // The translation key of the keybinding's category.
                ));
                ClientTickEvents.END_CLIENT_TICK.register(client -> {
                        KeybindCoords obj1 = new KeybindCoords();
                        List<Double> coords = obj1.getCoords();
                        double x = coords.get(0);
                        double y = coords.get(1);
                        double z = coords.get(2);

                                client.player.sendMessage(new LiteralText("X:" + Math.round(x) + " " + "Y:"
                                        + Math.round(y) + " " + "Z:" + Math.round(z)), false);

                        /*
                        if(counter == 1){
                                keyBindEnbaled = true;
                                counter++;
                        }
                        if(counter>1){
                                keyBindEnbaled = false;
                                counter--;
                        }
                        if(keyBindEnbaled) {
                                KeybindCoords obj1 = new KeybindCoords();
                                List<Double> coords = obj1.getCoords();
                                double x = coords.get(0);
                                double y = coords.get(1);
                                double z = coords.get(2);
                                client.player.sendMessage(new LiteralText("X:" + Math.round(x) + " " + "Y:"
                                                + Math.round(y) + " " + "Z:" + Math.round(z)), false);
                                try {
                                        Thread.sleep(5000);
                                } catch (Exception e) {
                                        System.out.println(e);
                                }

                                while (MinecraftClient.getInstance().player.prevX != x
                                                || MinecraftClient.getInstance().player.prevY != y
                                                || MinecraftClient.getInstance().player.prevZ != z) {
                                        coords = obj1.getCoords();
                                        x = coords.get(0);
                                        y = coords.get(1);
                                        z = coords.get(2);
                                        client.player.sendMessage(
                                                        new LiteralText("X:" + Math.round(x) + " " + "Y:"
                                                                        + Math.round(y) + " " + "Z" + Math.round(z)),
                                                        false);

                                }
                        }
                        */

                });
        }
}
