package com.orion.core.data.design_pattern.creational.abstract_factory;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.abstraction.OrionFactoryService;

public abstract class AbstractFactory extends Orion implements OrionFactoryService
{
    public abstract ConcreteFactoryIF buildFactory(OrionEnumeration objectTypeToBuild);
}