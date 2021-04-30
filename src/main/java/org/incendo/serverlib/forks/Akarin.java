package org.incendo.serverlib.forks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Akarin {

    // https://github.com/Akarin-project/Akarin

    private final static java.util.logging.Logger logger = Logger.getLogger(Akarin.class.getName());

    public static boolean unsafeAkarin() {
        try {
            Class.forName("io.akarin.server.Config");
            return true;
        } catch (ClassNotFoundException ignored) {
        }
        return false;
    }

    public static void isAkarin() {
        if (unsafeAkarin()) {
            logger.log(Level.SEVERE, "************************************************************");
            logger.log(Level.SEVERE, "* You are running a server fork that is known to be extremely dangerous and lead to data loss");
            logger.log(Level.SEVERE, "* due to a very dangerous patch history.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* It is strongly recommended you switch to a more stable,");
            logger.log(Level.SEVERE, "* high-performing server software, like Paper or Tuinity.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* By continuing to use this fork you acknowledge you are running an unsupported server version.");
            logger.log(Level.SEVERE, "************************************************************");
        }
    }
}
