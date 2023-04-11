<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="isMobileUser" required="true" type="java.lang.Boolean"%>


<li class="navbar_button hidden-xs-down">
    <a href="#" class="top-nav__themes" data-sa-action="aside-open" data-sa-target=".themes">
        <i class="zmdi zmdi-palette"></i>
        
        
        <c:choose>
            <c:when test="${!isMobileUser}">
                <span>Theme</span>
            </c:when>
        </c:choose>
    </a>
</li>