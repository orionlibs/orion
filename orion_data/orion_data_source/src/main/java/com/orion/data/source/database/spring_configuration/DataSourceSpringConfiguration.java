package com.orion.data.source.database.spring_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource(value = {"classpath:configuration/DatabaseConfiguration.prop", "classpath:configuration/CalendarConfiguration.prop"})
public class DataSourceSpringConfiguration
{
    private final Environment env;


    @Autowired
    public DataSourceSpringConfiguration(final Environment env)
    {
        this.env = env;
    }
}