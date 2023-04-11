package com.orion.web.java_tag_library.themes.orion.html_elements;

import com.orion.core.string.StringsService;
import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class DropdownButtonTag extends OrionBodyTag
{
    private static final long serialVersionUID = -1425776189124178467L;
    private String text;
    private String id;


    public int doEndTag() throws JspException
    {
        String tagBodyContent = getBodyContent().getString();

        try
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<div class=\"btn-group\" dropdown>");

            if(getId() != null && !getId().isEmpty())
            {
                sb.append("<button id=\"" + getId() + "\" type=\"button\" class=\"btn btn-light\">");
            }
            else
            {
                sb.append("<button type=\"button\" class=\"btn btn-light\">");
            }

            if(getText() != null && !getText().isEmpty())
            {
                sb.append(getText());
            }

            sb.append("</button>");
            sb.append("<button type=\"button\" class=\"btn btn-light dropdown-toggle dropdown-toggle-split\" data-toggle=\"dropdown\">");
            sb.append("<span class=\"caret\"></span>");
            sb.append("</button>");

            if(getId() != null && !getId().isEmpty())
            {
                sb.append("<ul id=\"" + getId() + "_dropdown-menu\" class=\"dropdown-menu\">");
            }
            else
            {
                sb.append("<ul class=\"dropdown-menu\">");
            }

            if(StringsService.isNotEmpty(tagBodyContent))
            {
                sb.append(tagBodyContent);
            }

            sb.append("</ul>");
            sb.append("</div>");
            pageContext.getOut().print(sb.toString());
        }
        catch(Exception e)
        {
            throw new JspTagException(e.getMessage());
        }

        return EVAL_PAGE;
    }


    public String getText()
    {
        return this.text;
    }


    public void setText(String text)
    {
        this.text = text;
    }


    public String getId()
    {
        return this.id;
    }


    public void setId(String id)
    {
        this.id = id;
    }
}