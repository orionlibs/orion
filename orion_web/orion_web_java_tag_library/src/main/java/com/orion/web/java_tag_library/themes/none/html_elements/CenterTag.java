package com.orion.web.java_tag_library.themes.none.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class CenterTag extends OrionBodyTag
{
    private static final long serialVersionUID = -4719925193107234463L;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                StringBuffer sb = new StringBuffer();
                sb.append("<center>");
                sb.append(tagBodyContent);
                sb.append("</center>");
                pageContext.getOut().print(sb.toString());
            }

        }
        catch(Exception e)
        {
            throw new JspTagException(e.getMessage());
        }

        return EVAL_PAGE;
    }
}