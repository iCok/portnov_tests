package interfaces;

import selenide.com.company.ebay.NotLoadedException;

/**
 * Describe method for waiting of loading pages
 */
public interface PageWait<T> {
    /**
     * Sync operation to be sure that page is loaded
     * @return page instance
     * @throws NotLoadedException is indicator
     */
    T waitToOpen() throws NotLoadedException;

    /**
     * Should immediately return is page loaded or not.
     */
    boolean isLoaded();
}
