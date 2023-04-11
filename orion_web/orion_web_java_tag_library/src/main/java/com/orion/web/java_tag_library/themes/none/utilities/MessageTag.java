package com.orion.web.java_tag_library.themes.none.utilities;

import com.orion.data.source.configuration.ConfigurationService;
import com.orion.web.core.app.pages.OrionTag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class MessageTag extends OrionTag
{
    private String key;


    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        out.println(ConfigurationService.getProp(getKey()));
    }


    public String getKey()
    {
        return key;
    }


    public void setKey(String key)
    {
        this.key = key;
    }
}