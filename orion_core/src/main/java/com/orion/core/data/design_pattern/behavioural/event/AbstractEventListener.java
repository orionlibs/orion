package com.orion.core.data.design_pattern.behavioural.event;

import com.orion.core.abstraction.OrionInterface;

public interface AbstractEventListener extends OrionInterface
{
    public void processEvent(AbstractEvent event);
}