<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="true" type="java.lang.String"%>
<%@ attribute name="href" required="true" type="java.lang.String"%>
<%@ attribute name="isMobileUser" required="true" type="java.lang.Boolean"%>


<li class="navbar_button">
    <a id="${id}" href="${href}" class="top-nav__themes">
        <i class="fas fa-id-badge"></i>
        
        
        <c:choose>
            <c:when test="${!isMobileUser}">
                <span>My Details</span>
            </c:when>
        </c:choose>
    </a>
</li>