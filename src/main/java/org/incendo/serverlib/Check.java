package org.incendo.serverlib;

/**
 * A check is any operation that can be done to determine whether unsafe
 * software is being used.
 */
public abstract class Check {

    private static final String EXPLANATION_BORDER = "************************************************************";

    private final CheckType type;

    /**
     * Constructs a new check.
     *
     * @param type The type of the check.
     */
    public Check(final CheckType type) {
        this.type = type;
    }

    /**
     * Returns the type of this check.
     *
     * @return The type of the check.
     */
    public final CheckType type() {
        return this.type;
    }

    /**
     * Checks whether or not the check detects the presence of unsafe software.
     *
     * @return Whether or not the check detects the presence of the unsafe software.
     */
    public abstract boolean shouldFlag();

    /**
     * Explains the reasoning behind the check.
     *
     * @return Lines of text explaining what the check detected.
     */
    public abstract String[] explain();

    /**
     * Prints an explanation of what the check detected.
     * <p>
     * The message is printed directly to the error output stream, so that a filter
     * cannot be added directly to the Log4J instance of the server
     * to filter out these messages.
     */
    public final void printExplanation() {
        System.err.println(EXPLANATION_BORDER);
        System.err.printf("* Detected unsafe software: %s (type: %s)\n", this.getClass().getSimpleName(), this.type().name());
        System.err.println("*");

        for (final String line : explain()) {
            System.err.printf("* %s\n", line);
        }

        System.err.println(EXPLANATION_BORDER);
    }

}
