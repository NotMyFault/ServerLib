package org.incendo.serverlib;

import org.incendo.serverlib.forks.Akarin;
import org.incendo.serverlib.forks.KibblePatcher;
import org.incendo.serverlib.forks.Sugarcane;
import org.incendo.serverlib.forks.Yatopia;
import org.incendo.serverlib.hybrids.Fabric;
import org.incendo.serverlib.hybrids.Forge;

import java.util.ArrayList;
import java.util.Collection;

import static org.incendo.serverlib.util.JavaVersionCheck.checkJavaFifteen;
import static org.incendo.serverlib.util.JavaVersionCheck.checkJavaSixteen;

/**
 * Utility used to detect unsafe Minecraft server software.
 */
public final class ServerLib {

    private final Collection<Check> checks;

    private ServerLib(final Collection<Check> checks) {
        this.checks = checks;
    }

    /**
     * Creates a new builder instance.
     *
     * @return Created builder.
     */
    public static ServerLib.Builder builder() {
        return new Builder();
    }

    /**
     * Checks for unsafe forks and modded hybrid servers.
     */
    public static void checkUnsafeForks() {
        final ServerLib serverLib = builder()
                .withCheck(new Akarin())
                .withCheck(new KibblePatcher())
                .withCheck(new Yatopia())
                .withCheck(new Sugarcane())
                .withCheck(new Fabric())
                .withCheck(new Forge())
                .build();
        serverLib.runChecks();
    }

    /**
     * Checks whether or not the server is running the latest LTS version of Java.
     */
    public static void checkJavaLTS() {
        checkJavaSixteen();
    }

    /**
     * Checks whether or not the server is running an unsupported version of Java.
     */
    public static void checkJavaMinor() {
        checkJavaFifteen();
    }

    /**
     * Runs all of the registered checks and prints explanations
     * if any of the checks get triggered.
     */
    public void runChecks() {
        for (final Check check : checks) {
            if (check.shouldFlag()) {
                check.printExplanation();
            }
        }
    }

    /**
     * Builder for {@link ServerLib} instances.
     */
    public static final class Builder {

        private final Collection<Check> checks = new ArrayList<>();

        private Builder(final Collection<Check> checks) {
            this.checks.addAll(checks);
        }

        /**
         * Constructs a new (empty) {@link ServerLib} builder.
         */
        private Builder() {
        }

        /**
         * Returns a mutated version of this builder, with the given {@link Check} added.
         *
         * @param check Check to add.
         */
        public Builder withCheck(final Check check) {
            final Collection<Check> checks = new ArrayList<>(this.checks);
            checks.add(check);
            return new Builder(checks);
        }

        /**
         * Constructs a new {@link ServerLib} instance from this builder.
         *
         * @return Constructed instance.
         */
        public ServerLib build() {
            return new ServerLib(this.checks);
        }

    }

}
