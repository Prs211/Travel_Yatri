

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if ((session.getAttribute("userDetails") == null) || (session.getAttribute("userDetails") == "")) {
%>
 <c:redirect url="../"></c:redirect>
<%}else{%>

<%@include file="include/Header.jsp" %>
<%@include file="include/ThemeSetting.jsp" %> 
<%@include file="include/Navigation.jsp" %>
<%@include file="include/BodyHeading.jsp" %>
<%@include file="include/myprofile.jsp" %>
<%@include file="include/Footer.jsp" %>
<%}%>