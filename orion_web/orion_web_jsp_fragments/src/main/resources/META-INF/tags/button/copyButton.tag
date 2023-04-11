<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="id" required="false" type="java.lang.String"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>


<button id="${id}" class="${classes} copy_button btn btn-light btn--icon">Copy <i class="zmdi zmdi-copy"></i></button>