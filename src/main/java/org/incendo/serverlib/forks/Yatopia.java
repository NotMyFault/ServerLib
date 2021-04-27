package org.incendo.serverlib.forks;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.incendo.serverlib.util.PackageChecker.packageExists;

public class Yatopia {

    // https://github.com/YatopiaMC/Yatopia

    private final static Logger logger = Logger.getLogger(Yatopia.class.getName());

    private static boolean unsafeYatopia() {
        return packageExists("org.yatopiamc")
                || packageExists("net.yatopia")
                || packageExists("dev.tr7zw.yatopia");
    }

    public static void isYatopia() {
        if (unsafeYatopia()) {
            logger.log(Level.SEVERE, "************************************************************");
            logger.log(Level.SEVERE, "* You are running a server fork that is known to be extremely dangerous and lead to data loss");
            logger.log(Level.SEVERE, "* due to an extremely volatile patch set.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* It is strongly recommended you switch to a more stable,");
            logger.log(Level.SEVERE, "* high-performing server software, like Paper or Tuinity.");
            logger.log(Level.SEVERE, "*");
            logger.log(Level.SEVERE, "* By continuing to use this fork you acknowledge you are running an unsupported server version.");
            logger.log(Level.SEVERE, "************************************************************");
        }
    }
}
