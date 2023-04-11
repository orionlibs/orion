package com.orion.math.function.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.reflection.method.retrieval.ReflectionMethodRetrievalService;
import com.orion.core.runnable.functions.OrionFunction;
import java.lang.reflect.Method;

public class GetRunMethodOfFunctionTask extends Orion
{
    public static Method run(OrionFunction formula)
    {
        Method method = ReflectionMethodRetrievalService.getDeclaredPublicMethod("run", formula, Object.class);

        if(method == null)
        {
            method = ReflectionMethodRetrievalService.getDeclaredPublicMethod("run", formula, Object.class, Object.class);

            if(method == null)
            {
                method = ReflectionMethodRetrievalService.getDeclaredPublicMethod("run", formula, Object.class, Object.class, Object.class);

                if(method == null)
                {
                    method = ReflectionMethodRetrievalService.getDeclaredPublicMethod("run", formula, Object.class, Object.class, Object.class, Object.class);

                    if(method == null)
                    {
                        method = ReflectionMethodRetrievalService.getDeclaredPublicMethod("run", formula, new Class[]
                        {Object[].class});
                    }

                }

            }

        }

        return method;
    }
}