package com.orion.web.core.session;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import javax.servlet.http.HttpServletRequest;

class SessionAttributeModifier extends Orion
{
    static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        request.setAttribute(attributeName, attributeValue);
    }
}