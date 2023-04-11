package com.orion.core.data.design_pattern.behavioural.event.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.design_pattern.behavioural.event.AbstractEvent;
import com.orion.core.data.design_pattern.behavioural.event.AbstractEventListener;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeregisterEventListenerTask extends Orion
{
    public static void run(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener, ConcurrentMap<Class<? extends AbstractEvent>, CopyOnWriteArrayList<AbstractEventListener>> eventClassToEventListenersMapper)
    {

        if(eventClassToEventListenersMapper.get(eventClass) != null)
        {
            eventClassToEventListenersMapper.get(eventClass).remove(eventListener);
        }

    }
}