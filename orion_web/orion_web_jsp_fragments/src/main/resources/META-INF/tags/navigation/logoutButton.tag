<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="formAction" required="false" type="java.lang.String"%>
<%@ attribute name="isMobileUser" required="true" type="java.lang.Boolean"%>
<%@ attribute name="logoutJavaScriptFile" required="false" type="java.lang.String"%>


<li class="navbar_button">
    <a id="logout_button" href="#" class="top-nav__themes">
        <%--<i class="fa fa-power-off"></i>--%>
        <img src="/images/logout.png"/>
        
        
        <c:choose>
            <c:when test="${!isMobileUser}">
                <span>Logout</span>
            </c:when>
        </c:choose>
    </a>
    
    
    <input id="input_oriongate_login_page_URL" type="hidden" value="${oriongateLoginPageURL}">
</li>


<c:choose>
    <c:when test="${logoutJavaScriptFile != null && !logoutJavaScriptFile.isEmpty()}">
        <OrionNoThemeJava:importJavaScript file="${logoutJavaScriptFile}"/>
    </c:when>
</c:choose>