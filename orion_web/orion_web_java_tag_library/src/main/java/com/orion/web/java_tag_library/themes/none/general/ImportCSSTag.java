package com.orion.web.java_tag_library.themes.none.general;

import com.orion.web.core.app.pages.OrionTag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class ImportCSSTag extends OrionTag
{
    private String file;


    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        StringBuffer sb = new StringBuffer();

        if(getFile() != null && !getFile().isEmpty())
        {
            sb.append("<link href=\"");
            sb.append(getFile());
            sb.append("?");
            sb.append(System.nanoTime());
            sb.append("\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>");
        }

        out.print(sb.toString());
    }


    public String getFile()
    {
        return this.file;
    }


    public void setFile(String file)
    {
        this.file = file;
    }
}