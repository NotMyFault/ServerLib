package org.incendo.serverlib.forks;

import org.incendo.serverlib.CheckType;
import org.incendo.serverlib.PackagePresenceCheck;

/**
 * Checks for the presence of Yatopia.
 * <p>
 * https://github.com/YatopiaMC/Yatopia
 */
public final class Yatopia extends PackagePresenceCheck {

    public Yatopia() {
        super(
                CheckType.UNSAFE_FORK,
                "org.yatopiamc",
                "net.yatopia",
                "dev.tr7zw.yatopia",
                "yatopiamc.org",
                "yatopia.net",
                "yatopia.tr7zw"
        );
    }

    @Override
    public String[] explain() {
        return new String[]{
                "You are running a server fork that is known to be extremely dangerous and lead to data loss",
                "due to an extremely volatile patch set.",
                "",
                "It is strongly recommended you switch to a more stable,",
                "high-performing server software, like Paper or Tuinity.",
                "",
                "By continuing to use this fork you acknowledge you are running an unsupported server version."
        };
    }

}
