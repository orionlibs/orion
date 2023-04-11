package com.orion.web.java_tag_library.themes.orion.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class StatisticsWidgetTag extends OrionBodyTag
{
    private static final long serialVersionUID = -1425776189124178467L;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<div class=\"stats_widget col-sm-6 col-md-3\">");
            sb.append("<div class=\"quick-stats__item\">");

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                sb.append(tagBodyContent);
            }

            sb.append("</div>");
            sb.append("</div>");
            pageContext.getOut().print(sb.toString());
        }
        catch(Exception e)
        {
            throw new JspTagException(e.getMessage());
        }

        return EVAL_PAGE;
    }
}