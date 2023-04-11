package com.orion.web.core.emailer.template;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.uuid.UUIDSecurityService;
import java.util.HashMap;
import java.util.Map;

public class InitialEmailTemplateParametersProvider extends Orion
{
    public static Map<String, String> initialiseTemplateParameters()
    {
        return generateInitialTemplateParameters();
    }


    private static Map<String, String> generateInitialTemplateParameters()
    {
        Map<String, String> templateParameters = new HashMap<>();
        templateParameters.put("emailID", UUIDSecurityService.generateUUIDWithoutHyphens());
        templateParameters.put("currentYear", Integer.toString(CalendarService.getCurrentYear()));
        return templateParameters;
    }
}