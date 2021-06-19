package org.incendo.serverlib.forks;

import org.incendo.serverlib.CheckType;
import org.incendo.serverlib.ClassPresenceCheck;

/**
 * Checks for the presence of Akarin.
 * <p>
 * https://github.com/Akarin-project/Akarin
 */
public final class Akarin extends ClassPresenceCheck {

    private static final String AKARAIN_CONFIG = "io.akarin.server.Config";

    public Akarin() {
        super(CheckType.UNSAFE_FORK, AKARAIN_CONFIG);
    }

    @Override
    public String[] explain() {
        return new String[]{
                "You are running a server fork that is known to be extremely dangerous and lead to data loss",
                "due to a very dangerous patch history.",
                "",
                "It is strongly recommended you switch to a more stable,",
                "high-performing server software, like Paper or Tuinity.",
                "",
                "By continuing to use this fork you acknowledge you are running an unsupported server version.\""
        };
    }

}
