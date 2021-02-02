package org.incendo.serverlib.forks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KibblePatcher {

    // https://github.com/KibbleLands/KibblePatcher

    private final static java.util.logging.Logger logger = Logger.getLogger(KibblePatcher.class.getName());

    private static boolean unsafeKibblePatcher() {
        try {
            Class.forName("net.kibblelands.server.FastMath");
            return true;
        } catch (ClassNotFoundException ignored) {
        }
        return false;
    }

    public static void isKibblePatcher() {
        if (unsafeKibblePatcher()) {
            logger.log(Level.SEVERE, "************************************************************");
            logger.log(Level.SEVERE, "* You are running a server fork that is known to be extremely dangerous and lead to data loss");
            logger.log(Level.SEVERE, "* due to dangerous byte code editing.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* It is strongly recommended you switch to a more stable,");
            logger.log(Level.SEVERE, "* high-performing server software, like Paper or Tuinity.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* By continuing to use this fork you acknowledge you are running an unsupported server version.");
            logger.log(Level.SEVERE, "************************************************************");

        }
    }
}
