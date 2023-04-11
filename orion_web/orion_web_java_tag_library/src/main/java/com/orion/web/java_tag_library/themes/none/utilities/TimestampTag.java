package com.orion.web.java_tag_library.themes.none.utilities;

import com.orion.web.core.app.pages.OrionTag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class TimestampTag extends OrionTag
{
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        out.println(System.nanoTime());
    }
}