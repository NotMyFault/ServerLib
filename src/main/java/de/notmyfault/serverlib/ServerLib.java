package de.notmyfault.serverlib;

import static de.notmyfault.serverlib.forks.AirplaneLite.isAirplaneLite;
import static de.notmyfault.serverlib.forks.AirplaneLiteChunkConcurrency.isAirplaneLiteChunkConcurrency;
import static de.notmyfault.serverlib.forks.Akarin.isAkarin;
import static de.notmyfault.serverlib.forks.KibblePatcher.isKibblePatcher;
import static de.notmyfault.serverlib.forks.Yatopia.isYatopia;
import static de.notmyfault.serverlib.hybrids.Fabric.isFabric;
import static de.notmyfault.serverlib.hybrids.Forge.isForge;

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
