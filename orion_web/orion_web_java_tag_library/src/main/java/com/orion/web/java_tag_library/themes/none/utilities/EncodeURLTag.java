package com.orion.web.java_tag_library.themes.none.utilities;

import com.orion.core.content.MIMEType;
import com.orion.web.core.app.pages.OrionTag;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class EncodeURLTag extends OrionTag
{
    private String value;


    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        out.println(URLEncoder.encode(getValue(), MIMEType.UTF8));
    }


    public String getValue()
    {
        return this.value;
    }


    public void setValue(String value)
    {
        this.value = value;
    }
}