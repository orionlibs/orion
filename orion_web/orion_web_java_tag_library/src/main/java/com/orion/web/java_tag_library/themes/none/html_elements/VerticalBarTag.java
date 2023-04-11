package com.orion.web.java_tag_library.themes.none.html_elements;

import com.orion.web.core.app.pages.OrionTag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class VerticalBarTag extends OrionTag
{
    private String colour;


    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        StringBuffer sb = new StringBuffer();
        sb.append("<div id=\"vertical-bar\">");
        sb.append("<div class=\"vertical-bar-inner\"");
        sb.append(" style=\"background: ");

        if(getColour() != null && !getColour().isEmpty())
        {
            sb.append(getColour());
        }
        else
        {
            sb.append("grey");
        }

        sb.append(";\"></div></div>");
        out.print(sb.toString());
    }


    public String getColour()
    {
        return this.colour;
    }


    public void setColour(String colour)
    {
        this.colour = colour;
    }
}