<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="value" required="false" type="java.lang.String"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>
<%@ attribute name="checked" required="false" type="java.lang.Boolean"%>


<label class="custom-control custom-radio">
    <c:choose>
        <c:when test="${checked != null}">            
            <input id="${id}" type="radio" value="${value}" name="radio-inline" class="${classes} custom-control-input" checked="${checked}">
        </c:when>
        <c:otherwise>        
            <input id="${id}" type="radio" value="${value}" name="radio-inline" class="${classes} custom-control-input">
        </c:otherwise>
    </c:choose>
    
    
    <span class="custom-control-indicator"></span>
    <span class="custom-control-description">${text}</span>
</label>