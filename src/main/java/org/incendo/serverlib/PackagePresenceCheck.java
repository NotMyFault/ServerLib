package org.incendo.serverlib;

import org.incendo.serverlib.util.PackageChecker;

/**
 * Checks for the presence of specific packages on the classpath.
 */
public abstract class PackagePresenceCheck extends Check {

    private final String[] illegalPackages;

    /**
     * Constructs a new check.
     *
     * @param type     The type of the check.
     * @param packages Packages to search for.
     */
    public PackagePresenceCheck(final CheckType type, final String... packages) {
        super(type);

        this.illegalPackages = packages;
    }

    @Override
    public boolean shouldFlag() {
        for (final String illegalPackage : illegalPackages) {
            if (PackageChecker.packageExists(illegalPackage)) {
                return true;
            }
        }

        // None of the illegal packages could be found on the classpath.
        return false;
    }

}
