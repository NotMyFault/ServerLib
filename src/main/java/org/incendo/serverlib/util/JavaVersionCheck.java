package org.incendo.serverlib.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaVersionCheck {

    private final static java.util.logging.Logger logger = Logger.getLogger(JavaVersionCheck.class.getName());

    private static int javaVersion() {
        String javaVersion = System.getProperty("java.version");
        final Matcher matcher = Pattern.compile("(?:1\\.)?(\\d+)").matcher(javaVersion);
        if (!matcher.find()) {
            logger.log(Level.WARNING, "Failed to determine Java version; Could not parse: {}", javaVersion);
            return -1;
        }

        final String version = matcher.group(1);
        try {
            return Integer.parseInt(version);
        } catch (final NumberFormatException e) {
             logger.log(Level.WARNING, "Failed to determine Java version; Could not parse {} from {}" + version + javaVersion, e);
            return -1;
        }
    }

    public static void checkJava11() {
        if (javaVersion() < 11) {
            logger.log(Level.INFO, "************************************************************");
            logger.log(Level.INFO, "* WARNING - YOU ARE RUNNING AN OUTDATED VERSION OF JAVA.");
            logger.log(Level.INFO, "* THIS PLUGIN WILL STOP BEING COMPATIBLE WITH THIS VERSION OF");
            logger.log(Level.INFO, "* JAVA WHEN MINECRAFT 1.17 IS RELEASED.");
            logger.log(Level.INFO, "*");
            logger.log(Level.INFO, "* Please update the version of Java to 11. When Minecraft 1.17");
            logger.log(Level.INFO, "* is released, support for versions of Java prior to 11 will");
            logger.log(Level.INFO, "* be dropped.");
            logger.log(Level.INFO, "*");
            logger.log(Level.INFO, "* Current Java version: {}", System.getProperty("java.version"));
            logger.log(Level.INFO, "*");
            logger.log(Level.INFO, "* Check this gist for more information:");
            logger.log(Level.INFO, "https://git.io/JtEJA");
            logger.log(Level.INFO, "************************************************************");
        }
    }

    public static void checkJava15() {
        if (javaVersion() >= 15) {
            logger.log(Level.INFO, "************************************************************");
            logger.log(Level.INFO, "* Within Java 15 and the removal of the Nashorn scripting engine,");
            logger.log(Level.INFO, "* this plugin might not work as intended.");
            logger.log(Level.INFO, "* Until a suitable workaround has been added, stick to Java 11");
            logger.log(Level.INFO, "* for long term support.");
            logger.log(Level.INFO, "*");
            logger.log(Level.INFO, "* Current Java version: {}", System.getProperty("java.version"));
            logger.log(Level.INFO, "*");
            logger.log(Level.INFO, "************************************************************");
        }
    }

}
