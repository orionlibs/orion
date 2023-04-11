<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="classes" required="false" type="java.lang.String"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>


<form class="row form-columned" role="form">
    <div class="col-md-10">
        <button type="button" class="${classes} btn btn-sm">${text}</button>
    </div>
</form>