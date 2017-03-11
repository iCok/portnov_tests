package util;

import java.util.concurrent.TimeUnit;

/**
 * Constants holder for timeout
 * Singleton
 */
public class Timeouts {
    private static Timeouts ourInstance = new Timeouts();
    public long pageLoad = TimeUnit.SECONDS.toMillis(20);

    public static Timeouts getDefault() {
        return ourInstance;
    }

    private Timeouts() {
    }
}
