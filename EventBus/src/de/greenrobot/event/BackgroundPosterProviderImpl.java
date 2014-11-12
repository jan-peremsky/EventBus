package de.greenrobot.event;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Created by matous.voldrich on 12/11/2014.
 */
public class BackgroundPosterProviderImpl implements BackgroundPosterProvider {

    private final Map<String, BackgroundPoster> backgroundPosterMap = new HashMap<String, BackgroundPoster>();
    private EventBus eventBus;

    public BackgroundPosterProviderImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void register(String name, ExecutorService service) throws EventBusException {
        BackgroundPoster backgroundPoster = new BackgroundPoster(eventBus, service, name);
        if (backgroundPosterMap.containsKey(name)) {
            throw new EventBusException("Executor with name " + name + " is already registered");
        }
        backgroundPosterMap.put(name, backgroundPoster);
    }

    @Override
    public boolean posterExists(String name) {
        return backgroundPosterMap.containsKey(name);
    }

    @Override
    public BackgroundPoster getPoster(String name) {
        return backgroundPosterMap.get(name);
    }
}
