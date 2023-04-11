package com.orion.user_management.spring_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@ComponentScan(basePackages = {"com.orion.user_management.authentication"})
public class UserManagementSpringConfiguration
{
    private final Environment env;


    @Autowired
    public UserManagementSpringConfiguration(final Environment env)
    {
        this.env = env;
    }
}
