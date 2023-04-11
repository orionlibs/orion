package com.orion.core.scripting.javascript.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExecuteTask extends Orion
{
    public static Object run(String JavaScriptCodeToExecute) throws ScriptException
    {
        Assert.notEmpty(JavaScriptCodeToExecute, "JavaScriptCodeToExecute cannot be null/empty.");
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("javascript");
        return engine.eval(JavaScriptCodeToExecute);
    }
}