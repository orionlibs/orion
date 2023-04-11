<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://orionplatform/orionthemejavabasedtags" prefix="OrionThemeJava"%>
<%@ taglib uri="https://orionplatform/orionnothemejavabasedtags" prefix="OrionNoThemeJava"%>
<%@ taglib uri="https://orionplatform/jspfragments" prefix="OrionJSP"%>
<%@ attribute name="chartID" required="true" type="java.lang.String"%>
<%@ attribute name="chartLegendID" required="true" type="java.lang.String"%>
<%@ attribute name="chartClasses" required="false" type="java.lang.String"%>
<%@ attribute name="chartLegendClasses" required="false" type="java.lang.String"%>
<%@ attribute name="encloseInCardJumbotron" required="false" type="java.lang.Boolean"%>


<c:choose>
    <c:when test="${encloseInCardJumbotron != null}">
        <c:choose>
            <c:when test="${encloseInCardJumbotron}">
                <div class="card">
                    <div class="card-body">
                        <div class="jumbotron">
                            <div id="${chartID}" class="${chartClasses} flot-chart flot-curved-line"></div>
                            <div id="${chartLegendID}" class="${chartLegendClasses} flot-chart-legends flot-chart-legends--curved"></div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>                
                <div id="${chartID}" class="${chartClasses} flot-chart flot-curved-line"></div>
                <div id="${chartLegendID}" class="${chartLegendClasses} flot-chart-legends flot-chart-legends--curved"></div>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>        
        <div id="${chartID}" class="${chartClasses} flot-chart flot-curved-line"></div>
        <div id="${chartLegendID}" class="${chartLegendClasses} flot-chart-legends flot-chart-legends--curved"></div>
    </c:otherwise>
</c:choose>