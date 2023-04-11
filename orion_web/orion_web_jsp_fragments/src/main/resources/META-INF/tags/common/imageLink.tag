<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="href" required="true" type="java.lang.String"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>
<%@ attribute name="src" required="true" type="java.lang.String"%>
<%@ attribute name="alt" required="false" type="java.lang.String"%>
<%@ attribute name="height" required="false" type="java.lang.String"%>
<%@ attribute name="width" required="false" type="java.lang.String"%>


<a id="${id}" href="${href}" class="${classes}">
    <img src="${src}" height="${height}" width="${width}" alt="${alt}">
</a>