package com.orionplatform.test_webapp.spring_configuration;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.orionplatform.test_webapp"})
public class TestWebAppMVCSpringConfiguration implements WebMvcConfigurer
{
    private final Environment env;

    
    @Autowired
    public TestWebAppMVCSpringConfiguration(final Environment env)
    {
        this.env = env;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/css/**")
        .addResourceLocations("/WEB-INF/css/")
        .setCachePeriod(600)
        .resourceChain(true)
        .addResolver(new VersionResourceResolver());
        registry.addResourceHandler("/scripts/**")
        .addResourceLocations("/WEB-INF/scripts/")
        .setCachePeriod(600)
        .resourceChain(true)
        .addResolver(new VersionResourceResolver());
        registry.addResourceHandler("/images/**")
        .addResourceLocations("/WEB-INF/images/")
        .setCachePeriod(600)
        .resourceChain(true)
        .addResolver(new VersionResourceResolver());
        registry.addResourceHandler("/fonts/**")
        .addResourceLocations("/WEB-INF/fonts/")
        .setCachePeriod(600)
        .resourceChain(true)
        .addResolver(new VersionResourceResolver());
        registry.addResourceHandler("/robots.txt")
        .addResourceLocations("/WEB-INF/pages/robots.txt")
        .setCachePeriod(600)
        .resourceChain(true)
        .addResolver(new VersionResourceResolver());
    }
    
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));
        stringConverter.setWriteAcceptCharset(false);
        converters.add(stringConverter);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().serializationInclusion(Include.NON_NULL).featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build().setDefaultPrettyPrinter(new MinimalPrettyPrinter());
        converters.add(new MappingJackson2HttpMessageConverter(mapper));
    }
    
    
    @Bean
    public WebContentInterceptor webContentInterceptor()
    {
        WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
        webContentInterceptor.setCacheSeconds(0);
        webContentInterceptor.setCacheControl(CacheControl.noStore());
        return webContentInterceptor;
    }
    
    
    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver()
    {
        return new DeviceHandlerMethodArgumentResolver();
    }
    
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)
    {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }

    
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(webContentInterceptor()).excludePathPatterns("/css/**", "/scripts/**", "/images/**", "/fonts/**", "/robots.txt", "/favicon.ico");
        registry.addInterceptor(new DeviceResolverHandlerInterceptor());
    }
    
    
    @Bean
    public CommonsMultipartResolver commonsMultipartResolver()
    {
        return new CommonsMultipartResolver();
    }
    
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/pages/");
        bean.setSuffix(".jsp");
        return bean;
    }
}
