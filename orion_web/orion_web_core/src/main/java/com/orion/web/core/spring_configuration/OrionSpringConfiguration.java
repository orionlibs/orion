package com.orion.web.core.spring_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@Import({SecurityConfiguration.class, DaoConfiguration.class})
public class OrionSpringConfiguration
{
    private final Environment env;


    @Autowired
    public OrionSpringConfiguration(final Environment env)
    {
        this.env = env;
    }
    /*@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
