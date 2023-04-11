package com.orion.core.scripting.javascript;

import com.orion.core.abstraction.OrionService;
import com.orion.core.scripting.javascript.tasks.ExecuteAndReturnTask;
import com.orion.core.scripting.javascript.tasks.ExecuteTask;
import javax.script.ScriptException;

public class JavaScriptEngineService extends OrionService
{
    public static Object execute(String JavaScriptCodeToExecute) throws ScriptException
    {
        return ExecuteTask.run(JavaScriptCodeToExecute);
    }


    public static Object executeAndReturn(String JavaScriptCodeToExecute, String resultName, Object objectToCastResultTo)
    {
        return ExecuteAndReturnTask.run(JavaScriptCodeToExecute, resultName, objectToCastResultTo);
    }
}