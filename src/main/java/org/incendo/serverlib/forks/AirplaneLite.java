package org.incendo.serverlib.forks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AirplaneLite {

    private final static java.util.logging.Logger logger = Logger.getLogger(AirplaneLite.class.getName());

    private static boolean unsafeAirplaneLite() {
        try {
            Class.forName("gg.airplane.structs.ChunkMapMap");
            return true;
        } catch (ClassNotFoundException ignored) {
        }
        return false;
    }

    public static void isAirplaneLite() {
        if (unsafeAirplaneLite()) {
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
