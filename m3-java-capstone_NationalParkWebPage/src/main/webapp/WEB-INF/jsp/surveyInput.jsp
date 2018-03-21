<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@include file="common/header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

		<form:form action="surveyInput" method="POST" ModelAttribute = "survey">
			<!-- <div class="formInputGroup"> -->

 			

<%-- 				<label for="quantity"> Quantity to buy
				<form:input path="quantity" />
							<form:errors path="quantity" cssClass="error"/>
				</label> --%>


				<label for="favoritepark" id="favorite_park_input" style = "width:75px;">Favorite National Park </label>
				<select style = "position:absolute;left:200px;" name = "parkCode">
					<c:forEach var = "park" items = "${listOfParks}"> 
					<%-- 	 <c:url var="parkDetailLink" value="/surveyResults"> 
					<c:param name="parkcode" value="${park.parkCode}"></c:param>
					</c:url>  --%>
						<option value = "${park.parkCode }" id = "${park.parkName}"> ${park.parkName} </option> ${park.parkName}
					</c:forEach>
				</select>
				<br> 
				<label for="emailaddress" id="email_input" style = "width:75px;"> Your email: <input
					style = "position:absolute;left:200px;" type="text" name="emailAddress" id="emailaddress" />
				</label><br> 
				<%-- 	<label for="emailaddress" id="email_input" style = "width:75px;"> Your email:
				<form:input path="email" /> --%>
			<%-- 				<form:errors path="email" cssClass="error"/><br> --%>
							
				<!-- </label> -->
				<label for = "state" id = "state_input" style = "width:75px;"> State of Residence </label> 
					<select style = "position:absolute;left:200px;" name = "state">
						<c:forEach var = "state" items = "${listOfStates}">
							<option  value = "${state }" id = "${state}"> ${state} </option> 
						</c:forEach>
					</select><br>
				<div id ="radioButtons">
							
				
					<label for="order" style = "width:75px;">Activity Level </label> 
					<input id = "inactive" type = "radio" name = "activityLevel" value="inactive" checked/>
					inactive
					<input id = "sedentary" type = "radio" name = "activityLevel" value="sedentary"/>
					sedentary
					<input id = "active" type = "radio" name = "activityLevel" value="active"/>
					active
					<input id = "extreme" type = "radio" name = "activityLevel" value="extremelyactive"/>
					extremely active
				</div>
				</div>
			<input id ="survey_submit_button" type="submit" value="SubmitSurvey" />
		</form:form>

<!-- x Favorite National Park drop down
x Your email input box
xState of residence drop down
x Activity level radio box (inactive, sedentary, active, extremely active).
 -->
<%@include file="common/footer.jsp" %>