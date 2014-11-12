package de.greenrobot.event;

import java.util.concurrent.ExecutorService;

/**
 * Created by matous.voldrich on 12/11/2014.
 */
public interface BackgroundPosterProvider {
    void register(String name, ExecutorService service) throws EventBusException;

    boolean posterExists(String name);

    BackgroundPoster getPoster(String name);
}
