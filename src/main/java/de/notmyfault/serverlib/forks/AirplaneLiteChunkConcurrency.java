package de.notmyfault.serverlib.forks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AirplaneLiteChunkConcurrency {

    private final static java.util.logging.Logger logger = Logger.getLogger(AirplaneLiteChunkConcurrency.class.getName());

    private static boolean unsafeAirplaneLiteChunkConcurrency() {
        try {
            Class.forName("gg.airplane.structs.ConcLong2ObjectOpenHashMap");
            return true;
        } catch (ClassNotFoundException ignored) {
        }
        return false;
    }

    public static void isAirplaneLiteChunkConcurrency() {
        if (unsafeAirplaneLiteChunkConcurrency()) {
            logger.log(Level.SEVERE, "************************************************************");
            logger.log(Level.SEVERE, "* You are running a server fork that is known to be extremely dangerous and lead to data loss");
            logger.log(Level.SEVERE, "* due to attempting unsafe chunk concurrency.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* It is strongly recommended you switch to a more stable,");
            logger.log(Level.SEVERE, "* high-performing server software, like Paper or Tuinity.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* By continuing to use this fork you acknowledge you are running an unsupported server version.");
            logger.log(Level.SEVERE, "************************************************************");
        }
    }
}
