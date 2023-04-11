package com.orion.web.java_tag_library.themes.orion.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class WideModalTag extends OrionBodyTag
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
            sb.append("<div tabindex=\"-1\"");

            if(getId() != null && !getId().isEmpty())
            {
                sb.append(" id=\"" + getId() + "\"");
            }

            sb.append(" class=\"");

            if(getClasses() != null && !getClasses().isEmpty())
            {
                sb.append(getClasses() + " ");
            }

            sb.append("long_modal modal fade\" tabindex=\"-1\">");
            sb.append("<div class=\"modal-dialog modal-xl\">");
            sb.append("<div class=\"modal-content\">");

            if(tagBodyContent != null && !tagBodyContent.isEmpty())
            {
                sb.append(tagBodyContent);
            }

            sb.append("<div class=\"modal-footer\">");
            sb.append("<button type=\"button\" class=\"modal_close_button close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            sb.append("Close");
            sb.append("</button>");
            sb.append("</div>");
            sb.append("</div>");
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