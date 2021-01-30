package org.incendo.serverlib.hybrids;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Fabric {

    private final static java.util.logging.Logger logger = Logger.getLogger(Fabric.class.getName());

    private static boolean incompatibleFabric() {
        try {
            Class.forName("net.fabricmc.loader.launch.knot.KnotServer");
            return true;
        } catch (ClassNotFoundException ignored) {
        }
        return false;
    }

    public static void isFabric() {
        if (incompatibleFabric()) {
            logger.log(Level.SEVERE, "************************************************************");
            logger.log(Level.SEVERE, "* You are running a server that does not properly support Bukkit plugins.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* Bukkit plugins should not be used with Forge/Fabric mods!");
            logger.log(Level.SEVERE, "* For Forge: Consider using ForgeEssentials, or SpongeForge + Nucleus.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* By continuing to use Forge you acknowledge you are running an unsupported server version.");
            logger.log(Level.SEVERE, "************************************************************");

        }
    }
}
