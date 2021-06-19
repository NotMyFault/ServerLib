package org.incendo.serverlib.hybrids;

import org.incendo.serverlib.CheckType;
import org.incendo.serverlib.ClassPresenceCheck;

/**
 * Checks for the presence of Forge.
 * <p>
 * https://github.com/MinecraftForge/MinecraftForge
 */
public final class Forge extends ClassPresenceCheck {

    private static final String MINECRAFT_FORGE = "net.fabricmc.loader.launch.knot.KnotServer";

    public Forge() {
        super(CheckType.MODDED_HYBRID, MINECRAFT_FORGE);
    }

    @Override
    public String[] explain() {
        return new String[]{
                "You are running a server that does not properly support Bukkit plugins.",
                "",
                "Bukkit plugins should not be used with Forge/Fabric mods!",
                "For Forge: Consider using ForgeEssentials, or SpongeForge + Nucleus.",
                "",
                "By continuing to use Forge you acknowledge you are running an unsupported server version."
        };
    }

}

