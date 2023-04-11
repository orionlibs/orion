<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="label" required="false" type="java.lang.String"%>
<%@ attribute name="id" required="true" type="java.lang.String"%>
<%@ attribute name="type" required="false" type="java.lang.String"%>
<%@ attribute name="value" required="false" type="java.lang.String"%>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean"%>
<%@ attribute name="placeholder" required="false" type="java.lang.String"%>
<%@ attribute name="redAsterisk" required="false" type="java.lang.Boolean"%>


<c:choose>
    <c:when test="${label ne null and not empty label}">
        <c:choose>
            <c:when test="${redAsterisk ne null and redAsterisk}">
                <OrionJSP:redAsterisk/><label>${label}</label>
            </c:when>
            <c:otherwise>
                <label>${label}</label>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>


<div class="form-group">


<c:choose>
    <c:when test="${type ne null and not empty type}">
        <c:choose>
            <c:when test="${value ne null and not empty value}">
                <c:choose>
                    <c:when test="${disabled ne null and disabled}">
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="${type}" value="${value}" placeholder="${placeholder}" class="form-control input-sm" disabled>
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="${type}" value="${value}" class="form-control input-sm" disabled>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="${type}" value="${value}" placeholder="${placeholder}" class="form-control input-sm">
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="${type}" value="${value}" class="form-control input-sm">
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${disabled ne null and disabled}">
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="text" placeholder="${placeholder}" class="form-control input-sm" disabled>
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="text" class="form-control input-sm" disabled>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="text" placeholder="${placeholder}" class="form-control input-sm">
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="text" class="form-control input-sm">
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${value ne null and not empty value}">
                <c:choose>
                    <c:when test="${disabled ne null and disabled}">
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="text" value="${value}" placeholder="${placeholder}" class="form-control input-sm" disabled>
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="text" value="${value}" class="form-control input-sm" disabled>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="text" value="${value}" placeholder="${placeholder}" class="form-control input-sm">
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="text" value="${value}" class="form-control input-sm">
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${disabled ne null and disabled}">
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="text" placeholder="${placeholder}" class="form-control input-sm" disabled>
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="text" class="form-control input-sm" disabled>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${placeholder ne null and not empty placeholder}">
                                <input id="${id}" name="${id}" type="text" placeholder="${placeholder}" class="form-control input-sm">
                            </c:when>
                            <c:otherwise>
                                <input id="${id}" name="${id}" type="text" class="form-control input-sm">
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>
</div>