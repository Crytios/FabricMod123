package com.Phoenix76.MOD123;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("Hi");
         KeybindCoords obj1 = new KeybindCoords();
         obj1.registerKeybind();
        
    }
}
