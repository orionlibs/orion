package com.orion.core.data.design_pattern.structural.adapter;

import com.orion.core.abstraction.OrionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Adapter implements OrionInterface
{
    private Adaptable adaptableObject;
}
