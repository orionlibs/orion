package com.orion.web.java_tag_library.themes.orion.html_elements;

import com.orion.web.core.app.pages.OrionBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class ImageLinkWidgetTag extends OrionBodyTag
{
    private static final long serialVersionUID = -1425776189124178467L;
    private String href;
    private String src;
    private String imageButtonClasses;
    private String anchorLinkClasses;
    private String height;
    private String width;
    private String text;
    private String mobileUser;


    public int doEndTag() throws JspException
    {

        try
        {
            String rowSize = "quarter_row";

            if(mobileUser != null && "true".equalsIgnoreCase(mobileUser))
            {
                rowSize = "full_row";
            }

            StringBuffer sb = new StringBuffer();
            sb.append("<div class=\"" + rowSize + "\">");
            sb.append("<div class=\"central-section-item\">");
            sb.append("<a");

            if(getHref() != null && !getHref().isEmpty())
            {
                sb.append(" href=\"" + getHref() + "\"");
            }

            if(getImageButtonClasses() != null && !getImageButtonClasses().isEmpty())
            {
                sb.append(" class=\"" + getImageButtonClasses() + "\"");
            }
            else
            {
                sb.append(" class=\"central-section-image\"");
            }

            sb.append(">");
            sb.append("<img");

            if(getSrc() != null && !getSrc().isEmpty())
            {
                sb.append(" src=\"" + getSrc() + "\"");
            }

            if(getHeight() != null && !getHeight().isEmpty())
            {
                sb.append(" height=\"" + getHeight() + "\"");
            }

            if(getWidth() != null && !getWidth().isEmpty())
            {
                sb.append(" width=\"" + getWidth() + "\"");
            }

            sb.append(">");
            sb.append("</a>");
            sb.append("</a>");
            sb.append("<a");

            if(getHref() != null && !getHref().isEmpty())
            {
                sb.append(" href=\"" + getHref() + "\"");
            }

            if(getAnchorLinkClasses() != null && !getAnchorLinkClasses().isEmpty())
            {
                sb.append(" class=\"" + getAnchorLinkClasses() + "\"");
            }
            else
            {
                sb.append(" class=\"central-section-button\"");
            }

            sb.append(">");

            if(getText() != null && !getText().isEmpty())
            {
                sb.append(getText());
            }

            sb.append("</a>");
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


    public String getHref()
    {
        return this.href;
    }


    public void setHref(String href)
    {
        this.href = href;
    }


    public String getSrc()
    {
        return this.src;
    }


    public void setSrc(String src)
    {
        this.src = src;
    }


    public String getHeight()
    {
        return this.height;
    }


    public void setHeight(String height)
    {
        this.height = height;
    }


    public String getWidth()
    {
        return this.width;
    }


    public void setWidth(String width)
    {
        this.width = width;
    }


    public String getImageButtonClasses()
    {
        return this.imageButtonClasses;
    }


    public void setImageButtonClasses(String imageButtonClasses)
    {
        this.imageButtonClasses = imageButtonClasses;
    }


    public String getAnchorLinkClasses()
    {
        return this.anchorLinkClasses;
    }


    public void setAnchorLinkClasses(String anchorLinkClasses)
    {
        this.anchorLinkClasses = anchorLinkClasses;
    }


    public String getText()
    {
        return this.text;
    }


    public void setText(String text)
    {
        this.text = text;
    }


    public String getMobileUser()
    {
        return this.mobileUser;
    }


    public void setMobileUser(String mobileUser)
    {
        this.mobileUser = mobileUser;
    }
}