package com.orion.web.java_tag_library.themes.orion.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class CardResultsAreaTag extends OrionBodyTag
{
    private static final long serialVersionUID = -1425776189124178467L;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<div class=\"listview listview--bordered listview--hover\">");
            sb.append("<div class=\"listview__item\">");
            sb.append("<div class=\"listview__content\">");

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                sb.append(tagBodyContent);
            }

            sb.append("</div>");
            sb.append("</div>");
            sb.append("<div class=\"clearfix mb-3\"></div>");
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