<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix= "fn" %>
        	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@include file="common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favorite Park Rankings</title>
</head>
<body>
	<c:forEach var = "parks" items = "${favorites }" >
	<figure>
		<img src ="img/parks/${fn:toLowerCase(parks.parkCode) }.jpg"/> 
		
		<figcaption>${parks.parkName }   <b>Vote Count: ${parks.count }</b></figcaption>
	</figure>
	</c:forEach>

<%@include file="common/footer.jsp" %>