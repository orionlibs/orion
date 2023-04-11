package com.orion.core.data.design_pattern.behavioural.event;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.design_pattern.behavioural.event.tasks.PublishEventTask;
import com.orion.core.runnable.OrionJobService;

public class EventService extends OrionService
{
    public static void registerEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        EventListenersRegistry.registerEventListener(eventClass, eventListener);
    }


    public static void deregisterEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        EventListenersRegistry.deregisterEventListener(eventClass, eventListener);
    }


    public static void publishEventSynchronously(AbstractEvent event)
    {
        new PublishEventTask(event).run();
    }


    public static void publishEventAsynchronously(AbstractEvent event)
    {
        OrionJobService.runJobWithCurrentThreadName(new PublishEventTask(event));
        return;
    }
}