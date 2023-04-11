package com.orion.web.java_tag_library.themes.none.general;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class ContentAreaTag extends OrionBodyTag
{
    private static final long serialVersionUID = -1425776189124178467L;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                pageContext.getOut().print(tagBodyContent);
            }

        }
        catch(Exception e)
        {
            throw new JspTagException(e.getMessage());
        }

        return EVAL_PAGE;
    }
}