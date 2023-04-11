<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}"/>