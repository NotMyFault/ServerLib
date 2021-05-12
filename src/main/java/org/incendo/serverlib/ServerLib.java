package org.incendo.serverlib;

import static org.incendo.serverlib.forks.Akarin.isAkarin;
import static org.incendo.serverlib.forks.KibblePatcher.isKibblePatcher;
import static org.incendo.serverlib.forks.Yatopia.isYatopia;
import static org.incendo.serverlib.hybrids.Fabric.isFabric;
import static org.incendo.serverlib.hybrids.Forge.isForge;
import static org.incendo.serverlib.util.JavaVersionCheck.checkJavaSixteen;
import static org.incendo.serverlib.util.JavaVersionCheck.checkJavaFifteen;

public class ServerLib {

    public static void checkUnsafeForks() {
        isAkarin();
        isForge();
        isKibblePatcher();
        isYatopia();
        isFabric();
    }

    public static void checkJavaLTS() {
        checkJavaSixteen();
    }
    public static void checkJavaMinor() {
        checkJavaFifteen();
    }
}
