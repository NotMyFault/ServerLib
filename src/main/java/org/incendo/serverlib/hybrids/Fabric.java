package org.incendo.serverlib.hybrids;

import org.incendo.serverlib.CheckType;
import org.incendo.serverlib.ClassPresenceCheck;

/**
 * Checks for the presence of Fabric.
 * <p>
 * https://github.com/FabricMC/fabric
 */
public final class Fabric extends ClassPresenceCheck {

    private static final String KNOT_SERVER = "net.fabricmc.loader.launch.knot.KnotServer";

    public Fabric() {
        super(CheckType.MODDED_HYBRID, KNOT_SERVER);
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
