package org.incendo.serverlib.forks;

import org.incendo.serverlib.CheckType;
import org.incendo.serverlib.ClassPresenceCheck;

/**
 * Checks for the presence of KibblePatcher.
 * <p>
 * https://github.com/KibbleLands/KibblePatcher
 */
public final class KibblePatcher extends ClassPresenceCheck {

    private static final String FAST_MATH = "net.kibblelands.server.FastMath";

    public KibblePatcher() {
        super(CheckType.UNSAFE_FORK, FAST_MATH);
    }

    @Override
    public String[] explain() {
        return new String[]{
                "You are running a server fork that is known to be extremely dangerous and lead to data loss",
                "due to dangerous byte code editing.",
                "",
                "It is strongly recommended you switch to a more stable,",
                "high-performing server software, like Paper or Tuinity.",
                "",
                "By continuing to use this fork you acknowledge you are running an unsupported server version."
        };
    }

}
