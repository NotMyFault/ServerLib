package org.incendo.serverlib.util;

import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;

public final class PackageChecker {

    private static final Logger LOGGER = Logger.getLogger(PackageChecker.class.getName());
    private static final String CLASS_EXTENSION = ".class";
    private static final Set<String> KNOWN_ENTRIES;

    static {
        final ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        try {
            final Enumeration<URL> urls = ClassLoader.getSystemClassLoader().getResources("META-INF");
            while (urls.hasMoreElements()) {
                final URL url = urls.nextElement();
                final URLConnection urlConnection = url.openConnection();
                if (!(urlConnection instanceof JarURLConnection)) {
                    continue;
                }
                final JarURLConnection connection = (JarURLConnection) urlConnection;
                try (final JarFile jar = connection.getJarFile()) {
                    final Enumeration<JarEntry> entries = jar.entries();
                    while (entries.hasMoreElements()) {
                        final ZipEntry entry = entries.nextElement();
                        final String resource = entry.toString();
                        // strip preceding '/' if it exists
                        if (resource.startsWith("/")) {
                            handleResource(builder, resource.substring(1));
                        } else {
                            handleResource(builder, resource);
                        }
                    }
                }
            }
        } catch (final IOException ex) {
            LOGGER.log(Level.WARNING, "Couldn't scan for known JarEntries.", ex);
        }
        KNOWN_ENTRIES = builder.build();
    }

    private PackageChecker() {
    }

    private static void handleResource(final ImmutableSet.Builder<String> builder, final String resource) {
        if (resource.endsWith(CLASS_EXTENSION)) { // Class files
            final int slash = resource.lastIndexOf("/");
            if (slash == -1) {
                return;
            }
            builder.add(resource.substring(0, slash));
        } else if (resource.endsWith("/")) { // Directories
            builder.add(resource.substring(0, resource.length() - 1));
        }
        // else: non-class file
    }

    public static boolean packageExists(final String name) {
        final String path = name.replace(".", "/");
        for (final String knownEntry : KNOWN_ENTRIES) {
            if (knownEntry.startsWith(path)) {
                return true;
            }
        }
        return false;
    }

}
