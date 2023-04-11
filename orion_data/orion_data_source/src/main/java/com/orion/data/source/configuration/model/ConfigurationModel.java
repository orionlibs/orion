package com.orion.data.source.configuration.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConfigurationModel implements OrionModel
{
    private String configurationKey;
    private String configurationValue;
    private String configurationType;


    public static ConfigurationModel of()
    {
        return ConfigurationModel.builder().build();
    }


    public static ConfigurationModel of(String configurationKey)
    {
        return ConfigurationModel.builder()
                        .configurationKey(configurationKey)
                        .build();
    }


    @Override
    public ConfigurationModel clone()
    {
        return (ConfigurationModel)CloningService.clone(this);
    }


    @Override
    public ConfigurationModel getCopy()
    {
        return this.clone();
    }
}