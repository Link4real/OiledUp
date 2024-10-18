package com.link.oiledup.sounds;

import com.link.oiledup.OiledUp;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.tryParse(OiledUp.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static final SoundEvent RUBBER_CHICKEN_SCREAM = registerSoundEvent("rubber_chicken_scream");
    public static final SoundEvent DETECTOR_PING = registerSoundEvent("detector_ping");

    public static void registerSounds() {
        OiledUp.LOGGER.info("Registering Sounds for " + OiledUp.MOD_ID);
    }
}
