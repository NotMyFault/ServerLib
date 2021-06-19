package org.incendo.serverlib;

/**
 * Checks for the presence of specific classes on the classpath.
 */
public abstract class ClassPresenceCheck extends Check {

    private final String[] illegalClasses;

    /**
     * Constructs a new check.
     *
     * @param type    The type of the check.
     * @param classes Classes to search for.
     */
    public ClassPresenceCheck(final CheckType type, final String... classes) {
        super(type);

        this.illegalClasses = classes;
    }

    @Override
    public boolean shouldFlag() {
        for (final String illegalClass : illegalClasses) {
            try {
                Class.forName(illegalClass);
                return true;
            } catch (ClassNotFoundException ignored) {
            }
        }

        // None of the illegal classes could be found on the classpath.
        return false;
    }

}
