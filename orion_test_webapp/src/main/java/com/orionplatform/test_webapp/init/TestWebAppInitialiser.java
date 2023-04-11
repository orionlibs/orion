package com.orionplatform.test_webapp.init;

import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.orionplatform.calendar.CalendarService;
import com.orionplatform.calendar.datetime.DateTime;
import com.orionplatform.data.data_access.OrionAuthoritiesDAO;
import com.orionplatform.data.data_access.OrionUserLogoutsDAO;
import com.orionplatform.data.data_access.OrionUsersDAO;
import com.orionplatform.data.data_model.LogoutCause;
import com.orionplatform.data.data_model.LogoutCausesMapper;
import com.orionplatform.data.data_model.OrionAuthorityModel;
import com.orionplatform.data.data_model.OrionUserLogoutsModel;
import com.orionplatform.test_webapp.spring_configuration.TestWebAppMVCSpringConfiguration;
import com.orionplatform.test_webapp.spring_configuration.TestWebAppSecuritySpringConfiguration;

@Order(value = 100)
public class TestWebAppInitialiser implements WebApplicationInitializer
{
    private static final transient Logger LOG = Logger.getLogger(TestWebAppInitialiser.class.getName());
    private static boolean testWebAppInitialised;
    
    
    @Override
    public void onStartup(ServletContext servletContext)
    {
        if(!testWebAppInitialised)
        {
            LOG.info("Test WebApp is initialising...");
            AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
            rootContext.register(TestWebAppSecuritySpringConfiguration.class);
            rootContext.refresh();
            servletContext.addListener(new ContextLoaderListener(rootContext));
            servletContext.addListener(new HttpSessionEventPublisher());
            AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
            dispatcherContext.setServletContext(servletContext);
            dispatcherContext.setParent(rootContext);
            dispatcherContext.register(TestWebAppMVCSpringConfiguration.class);
            DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
            ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/");
            DelegatingFilterProxy springSecurityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain", dispatcherContext);
            servletContext.addFilter("springSecurityFilterChain", springSecurityFilterChain)
                .addMappingForUrlPatterns(null, false, "/*");
            servletContext.addFilter("requestContextFilter", new RequestContextFilter())
                .addMappingForUrlPatterns(null, false, "/*");
            servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null, false, "/*");
            servletContext.addFilter("ETagFilter", new ShallowEtagHeaderFilter())
                .addMappingForUrlPatterns(null, false, "/*");
            //InputStream emailerStream = TestWebAppInitialiser.class.getResourceAsStream("/Emailer.prop");
            //ConfigurationService.loadProps(emailerStream);
            OrionUsersDAO.setAllUsersAsLoggedOut();
            List<OrionAuthorityModel> userAuthorities = OrionAuthoritiesDAO.getUsersAuthorities();
            
            if(userAuthorities != null && !userAuthorities.isEmpty())
            {
                DateTime currentDatetime = CalendarService.getCurrentDatetime();
                
                for(OrionAuthorityModel authority : userAuthorities)
                {                    
                    OrionUserLogoutsModel logoutModel = new OrionUserLogoutsModel();
                    logoutModel.setUserID(authority.getUserID());
                    logoutModel.setLogoutDate(currentDatetime.getDate().getDateStringSplitByHyphens());
                    logoutModel.setLogoutTime(currentDatetime.getTime().getTimeString());
                    logoutModel.setLogoutCauseID(LogoutCausesMapper.getLogoutCauseIDFromName(LogoutCause.System.get()));
                    OrionUserLogoutsDAO.saveUserLogout(logoutModel);
                }
            }
            
            testWebAppInitialised = true;
        }
    }
}