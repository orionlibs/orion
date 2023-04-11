package com.orion.web.java_tag_library.themes.none.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class LoginFormTag extends OrionBodyTag
{
    private static final long serialVersionUID = -4719925193107234463L;
    private String id;
    private String classes;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<form");

            if(getId() != null && !getId().isEmpty())
            {
                sb.append(" id=\"" + getId() + "\"");
            }

            sb.append(" action=\"/j_spring_security_check\" method=\"post\"");

            if(getClasses() != null && !getClasses().isEmpty())
            {
                sb.append(" class=\"" + getClasses() + "\"");
            }

            sb.append(">");

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                sb.append(tagBodyContent);
            }

            sb.append("</form>");
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