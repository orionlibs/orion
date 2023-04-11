<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>
<%@ attribute name="text" required="false" type="java.lang.String"%>


<button id="${id}" type="button" class="${classes} modal_close_button close" data-dismiss="modal" aria-label="Close">
    <c:choose>
        <c:when test="${text != null && !text.isEmpty()}">
            ${text}
        </c:when>
        <c:otherwise>
            X
        </c:otherwise>
    </c:choose>
</button>