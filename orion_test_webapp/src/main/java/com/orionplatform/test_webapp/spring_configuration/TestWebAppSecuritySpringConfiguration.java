package com.orionplatform.test_webapp.spring_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.orionplatform.data.data_source.database.spring_configuration.DataSourceSpringConfiguration;
import com.orionplatform.test_webapp.authentication.login.LoginSuccessHandler;
import com.orionplatform.user_management.authentication.security.OrionFailedLoginService;
import com.orionplatform.user_management.authentication.security.OrionLoginAttemptService;
import com.orionplatform.user_management.spring_configuration.UserManagementSpringConfiguration;
import com.orionplatform.web.core.spring_configuration.OrionSpringConfiguration;

@Configuration
@EnableWebSecurity
@PropertySource(value = {"classpath:configuration/UserManagement.prop"}, ignoreResourceNotFound = true)
@Import({OrionSpringConfiguration.class, DataSourceSpringConfiguration.class, UserManagementSpringConfiguration.class})
@ImportResource("classpath:spring-security.xml")
//@ComponentScan("com.orionplatform.test_webapp.cronjob")
//@EnableScheduling
public class TestWebAppSecuritySpringConfiguration extends WebSecurityConfigurerAdapter
{
    private final Environment env;

    
    @Autowired
    public TestWebAppSecuritySpringConfiguration(final Environment env)
    {
        super();
        this.env = env;
    }


    @Bean(name = "LoginSuccessHandler")
    public LoginSuccessHandler loginSuccessHandler()
    {
        LoginSuccessHandler bean = new LoginSuccessHandler();
        bean.setDefaultTargetUrl("/application/personaldetails");
        return bean;
    }
    
    
    @Bean(name = "OrionLoginAttemptService")
    public OrionLoginAttemptService orionLoginAttemptService()
    {
        OrionLoginAttemptService bean = new OrionLoginAttemptService();
        bean.setEnableMonitoringOfFailedLoginAttempts(Boolean.valueOf(env.getRequiredProperty("user.management.login.failed.enable.monitoring")));
        bean.setMaximumNumberOfAllowedFailedLoginAttempts(Integer.parseInt(env.getRequiredProperty("user.management.login.failed.maximum.number.of.allowed.attempts")));
        bean.setMaximumNumberOfMinutesToMonitorFailedLoginAttempts(Integer.parseInt(env.getRequiredProperty("user.management.login.failed.maximum.number.of.minutes.to.monitor")));
        return bean;
    }
    
    
    @Bean(name = "OrionFailedLoginService")
    public OrionFailedLoginService orionFailedLoginService()
    {
        OrionFailedLoginService bean = new OrionFailedLoginService();
        bean.setLoginAttemptService(orionLoginAttemptService());
        return bean;
    }
    
    
    /*@Bean(name = "OrionLoginUserDetailsService")
    public OrionLoginUserDetailsService orionLoginUserDetailsService()
    {
        OrionLoginUserDetailsService bean = new OrionLoginUserDetailsService();
        boolean enableMonitoringOfFailedLoginAttempts = Boolean.valueOf(env.getRequiredProperty("user.management.login.failed.enable.monitoring"));
        int maximumNumberOfMinutesToMonitorFailedLoginAttempts = Integer.parseInt(env.getRequiredProperty("user.management.login.failed.maximum.number.of.minutes.to.monitor"));
        bean.setEnableMonitoringOfFailedLoginAttempts(enableMonitoringOfFailedLoginAttempts);
        bean.setMaximumNumberOfMinutesToMonitorFailedLoginAttempts(maximumNumberOfMinutesToMonitorFailedLoginAttempts);
        return bean;
    }*/
    
    
    /*@Bean
    public OrionLoginUserDetailsService authenticationManager()
    {
        OrionLoginUserDetailsService bean = new OrionLoginUserDetailsService();
        return bean;
    }*/
    
    
    /*@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    
    @Bean
    public WebExpressionVoter webExpressionVoter()
    {
        return new WebExpressionVoter();
    }
    
    
    @Bean
    public RoleVoter roleVoter()
    {
        return new RoleVoter();
    }
    
    
    @Bean
    public AffirmativeBased httpRequestAccessDecisionManager()
    {
        return new AffirmativeBased(Arrays.asList(webExpressionVoter(), roleVoter()));
    }
    
    
    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor(OrionLoginUserDetailsService orionLoginUserDetailsService)
    {
        FilterSecurityInterceptor bean = new FilterSecurityInterceptor();
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(orionLoginUserDetailsService);
        bean.setAuthenticationManager(new ProviderManager(daoAuthenticationProvider));
        bean.setAccessDecisionManager(httpRequestAccessDecisionManager());
        SecurityExpressionHandler<FilterInvocation> expressionHandler;
        //ExpressionBasedFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = new ExpressionBasedFilterInvocationSecurityMetadataSource();
        //bean.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
        return bean;
    }*/
}
