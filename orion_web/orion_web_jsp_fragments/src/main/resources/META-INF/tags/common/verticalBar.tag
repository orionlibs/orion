<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="colour" required="false" type="java.lang.String"%>


<c:choose>
    <c:when test="${colour == null || colour.isEmpty()}">
        <c:set var="colour1" value="grey"/>
    </c:when>
    <c:otherwise>
        <c:set var="colour1" value="${colour}"/>
    </c:otherwise>
</c:choose>


<div id="vertical-bar">
    <div class="vertical-bar-inner" style="background: ${colour1};">
    
    </div>
</div>