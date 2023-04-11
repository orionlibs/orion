package com.orion.core.data.design_pattern.behavioural.event.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.design_pattern.behavioural.event.AbstractEvent;
import com.orion.core.data.design_pattern.behavioural.event.EventListenersRegistry;
import com.orion.core.reflection.method.access.ReflectionMethodAccessService;
import com.orion.core.runnable.OrionJob;

public class PublishEventTask extends Orion implements OrionJob
{
    private AbstractEvent event;


    public PublishEventTask(AbstractEvent event)
    {
        this.event = event;
    }


    @Override
    public void run()
    {
        EventListenersRegistry.getEventListenersForEvent((Class<? extends AbstractEvent>)event.getClass())
                        .forEach(eventListener -> ReflectionMethodAccessService.callMethod("processEvent", eventListener, new Class<?>[]
                        {AbstractEvent.class}, new Object[]
                        {(AbstractEvent)event}));
    }
}