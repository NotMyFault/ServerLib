package org.incendo.serverlib;

import static org.incendo.serverlib.forks.AirplaneLite.isAirplaneLite;
import static org.incendo.serverlib.forks.AirplaneLiteChunkConcurrency.isAirplaneLiteChunkConcurrency;
import static org.incendo.serverlib.forks.Akarin.isAkarin;
import static org.incendo.serverlib.forks.KibblePatcher.isKibblePatcher;
import static org.incendo.serverlib.forks.Yatopia.isYatopia;
import static org.incendo.serverlib.hybrids.Fabric.isFabric;
import static org.incendo.serverlib.hybrids.Forge.isForge;

public class ServerLib {

    public static void checkUnsafeForks() {
        isAirplaneLite();
        isAirplaneLiteChunkConcurrency();
        isAkarin();
        isForge();
        isKibblePatcher();
        isYatopia();
        isFabric();
    }
}
