<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>
<%@ attribute name="hidden" required="false" type="java.lang.Boolean"%>
<%@ attribute name="isSolid" required="false" type="java.lang.Boolean"%>


<c:choose>
    <c:when test="${hidden != null}">            
        <c:choose>
            <c:when test="${isSolid != null && isSolid}">            
                <button id="${id}" class="${classes} btn btn-secondary" hidden="${hidden}">${text}</button>
            </c:when>
            <c:otherwise>        
                <button id="${id}" class="${classes} btn btn-outline-secondary" hidden="${hidden}">${text}</button>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>        
        <c:choose>
            <c:when test="${isSolid != null && isSolid}">            
                <button id="${id}" class="${classes} btn btn-secondary">${text}</button>
            </c:when>
            <c:otherwise>        
                <button id="${id}" class="${classes} btn btn-outline-secondary">${text}</button>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>