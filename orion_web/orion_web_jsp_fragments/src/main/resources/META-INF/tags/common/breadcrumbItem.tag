<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>
<%@ attribute name="active" required="false" type="java.lang.Boolean"%>
<%@ attribute name="isMobileUser" required="true" type="java.lang.Boolean"%>


<c:choose>
    <c:when test="${active ne null and active}">
        <li class="breadcrumb-item"><a class="active_breadcrumb" href="#">${text}</a></li>
    </c:when>
    <c:otherwise>
        <li class="breadcrumb-item"><a href="#">${text}</a></li>
    </c:otherwise>
</c:choose>


<c:choose>
    <c:when test="${isMobileUser}">
        <br>
    </c:when>
</c:choose>