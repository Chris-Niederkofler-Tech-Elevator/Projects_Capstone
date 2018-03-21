
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix= "fn" %>
<%@include file="common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>National Park Geeks</title>

</head>
<body>
<!--  <a href = "/m3-java-capstone/home" > Home </a> <a href = "/m3-java-capstone/surveyInput" > Survey </a> -->					
	<c:forEach var = "park" items = "${parks}">
		<c:url var="parkDetailLink" value="/park">
			<c:param name="parkcode" value="${park.parkCode}"></c:param>
		</c:url>
		<div style = "display:inline-block;max-width:100%;">
			<div id = "park_image" style = "max-width:40%;max-height:150px;vertical-align:bottom;margin: 0px 25px 25px 25px;display:inline-block;">
				<a href = "${parkDetailLink}" ><img style = "max-width:150px;" id = "${park.parkName}" src = "img/parks/${fn:toLowerCase(park.parkCode) }.jpg"></a>		
			</div>
			<div id = "description"  style = "max-width:60%;text-align:left;display:inline-block;">
				<h2> ${park.parkName}, ${park.state} </h2>
				<p>  ${park.description} </p>
			</div>
		</div>		
	</c:forEach>
<%@include file="common/footer.jsp" %>