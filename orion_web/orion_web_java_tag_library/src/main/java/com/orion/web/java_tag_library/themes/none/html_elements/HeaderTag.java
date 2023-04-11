package com.orion.web.java_tag_library.themes.none.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class HeaderTag extends OrionBodyTag
{
    private static final long serialVersionUID = -1425776189124178467L;
    private String id;
    private String classes;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<header");

            if(getId() != null && !getId().isEmpty())
            {
                sb.append(" id=\"" + getId() + "\"");
            }

            if(getClasses() != null && !getClasses().isEmpty())
            {
                sb.append(" class=\"" + getClasses() + "\"");
            }

            sb.append(">");

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                sb.append(tagBodyContent);
            }

            sb.append("</header>");
            pageContext.getOut().print(sb.toString());
        }
        catch(Exception e)
        {
            throw new JspTagException(e.getMessage());
        }

        return EVAL_PAGE;
    }


    public String getId()
    {
        return this.id;
    }


    public void setId(String id)
    {
        this.id = id;
    }


    public String getClasses()
    {
        return this.classes;
    }


    public void setClasses(String classes)
    {
        this.classes = classes;
    }
}