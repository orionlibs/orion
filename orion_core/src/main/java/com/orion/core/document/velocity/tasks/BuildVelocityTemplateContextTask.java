package com.orion.core.document.velocity.tasks;

import com.orion.core.abstraction.Orion;
import java.util.Map;
import org.apache.velocity.VelocityContext;

public class BuildVelocityTemplateContextTask extends Orion
{
    public static VelocityContext run()
    {
        return new VelocityContext();
    }


    public static VelocityContext run(Map<String, String> templateParametersMapper)
    {
        VelocityContext context = run();

        if(templateParametersMapper != null && !templateParametersMapper.isEmpty())
        {
            templateParametersMapper.entrySet()
                            .stream()
                            .filter(entry -> entry != null && entry.getKey() != null && !entry.getKey().isEmpty())
                            .forEach(entry -> context.put(entry.getKey(), entry.getValue()));
        }

        return context;
    }
}