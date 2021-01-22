package de.notmyfault.serverlib;

import static de.notmyfault.serverlib.forks.AirplaneLite.isAirplaneLite;
import static de.notmyfault.serverlib.forks.AirplaneLiteChunkConcurrency.isAirplaneLiteChunkConcurrency;
import static de.notmyfault.serverlib.forks.Akarin.isAkarin;
import static de.notmyfault.serverlib.forks.Forge.isForge;
import static de.notmyfault.serverlib.forks.KibblePatcher.isKibblePatcher;
import static de.notmyfault.serverlib.forks.Yatopia.isYatopia;

public class ServerLib {

    public static void checkUnsafeForks() {
        isAirplaneLite();
        isAirplaneLiteChunkConcurrency();
        isAkarin();
        isForge();
        isKibblePatcher();
        isYatopia();
    }
}
