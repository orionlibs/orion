package com.orion.web.core.filter;

import com.orion.core.abstraction.Orion;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class XSSWebFilter extends Orion implements Filter
{
    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        chain.doFilter(new XSSHttpServletRequestWrapper((HttpServletRequest)request), response);
    }
}