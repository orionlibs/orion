<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>
<%@ attribute name="hidden" required="false" type="java.lang.Boolean"%>
<%@ attribute name="width" required="false" type="java.lang.String"%>


<c:choose>
    <c:when test="${hidden != null}">            
        <c:choose>
            <c:when test="${width != null}">            
                <div class="orion-blue-button-container" style="width: ${width};">
                    <button id="${id}" class="orion-button ${classes}" hidden="${hidden}">${text}</button>
                </div>
            </c:when>
            <c:otherwise>        
                <div class="orion-blue-button-container">
                    <button id="${id}" class="orion-button ${classes}" hidden="${hidden}">${text}</button>
                </div>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>        
        <c:choose>
            <c:when test="${width != null}">            
                <div class="orion-blue-button-container" style="width: ${width};">
                    <button id="${id}" class="orion-button ${classes}">${text}</button>
                </div>
            </c:when>
            <c:otherwise>        
                <div class="orion-blue-button-container">
                    <button id="${id}" class="orion-button ${classes}">${text}</button>
                </div>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>