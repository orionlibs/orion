<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="src" required="true" type="java.lang.String"%>
<%@ attribute name="height" required="true" type="java.lang.String"%>
<%@ attribute name="href" required="true" type="java.lang.String"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>


<div id="logo_button" class="logo">
    <img id="logo_image" src="${src}" height="${height}"/>
    
    
    <h1 id="logo_text">
        <a href="${href}">${text}</a>
    </h1>
</div>