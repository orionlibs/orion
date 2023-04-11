package com.orion.web.java_tag_library.themes.orion.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class DataTableTag extends OrionBodyTag
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
            sb.append("<div");

            if(getId() != null && !getId().isEmpty())
            {
                sb.append(" id=\"" + getId() + "\"");
            }

            sb.append(" class=\"");

            if(getClasses() != null && !getClasses().isEmpty())
            {
                sb.append(getClasses() + " ");
            }

            sb.append("table-responsive\">");
            sb.append("<table id=\"data-table\" class=\"table\">");

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                sb.append(tagBodyContent);
            }

            sb.append("</table>");
            sb.append("</div>");
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