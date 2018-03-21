<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix= "fn" %>
<%@include file="common/header.jsp" %>


<h2><c:out value="${park.parkName}"/></h2>

<div>
	<c:url var="imageLink" value="img/parks/${fn:toLowerCase(park.parkCode) }.jpg" />
	<img src="${imageLink }" />
</div>

<div>
	<p>
		<em>"<c:out value="${park.quote }" />" -<c:out
				value="${park.quoteSource }" /></em>
	</p>
</div>

<div>
	<p>
		<c:out value="${park.description }" />
	</p>
	<c:choose>
		<c:when test="${park.entryFee == 0 }" >	
			<p> Entry Fee: Free! </p>
		</c:when>
		<c:otherwise>	
			<p>
				Entry Fee: $
				<c:out value="${park.entryFee }" />
			</p>
		</c:otherwise>
	</c:choose>
	<p>
		State:
		<c:out value="${park.state }" />
	</p>
			<p>
				Acreage:
				<c:out value="${park.acreage}" /> 
<%-- 				<c:choose> 
				<c:when test="${convert == 'C' }"> sq km</c:when>
				<c:otherwise>sq. mi.</c:otherwise>
				</c:choose> --%>
			</p>
	<p>
		Established:
		<c:out value="${park.yearFounded }" />
	</p>
	<p>
		Number of Visitors:
		<c:out value="${park.annualVisitorCount }" />
	</p>
			<p>
				Elevation: <c:out value="${park.elevation }" /> ft 
<%-- 				<c:choose> 
				<c:when test="${convert == 'C' }"> m</c:when>
				<c:otherwise>ft.</c:otherwise>
				</c:choose> --%>
			</p>
	<p>
		Total Miles of Trails:
		<c:out value="${park.milesOfTrail }" /> mi
<%-- 		<c:choose> 
		<c:when test="${convert == 'C' }"> km</c:when>
		<c:otherwise>mi.</c:otherwise> 
		</c:choose> --%>
	</p>
	<c:choose>
		<c:when test="${park.numCampsites == 0 }" >
			<p>Total Number of Campsites: No Campsites Available</p>
		</c:when>
		<c:otherwise>
			<p>
				Total Number of Campsites:
				<c:out value="${park.numCampsites }" />
			</p>
		</c:otherwise>
	</c:choose>
	<p>
		Total Number of Animal Species:
		<c:out value="${park.numOfSpecies }" />
	</p>
</div>

<div class="weatherContainer">

	<div class="currentWeatherContainer">
		<div class="currentWeather">
			<div class="currentWeatherImage">
				<h3>Today</h3>
				<%-- <c:url var="weatherImage"
					value="img/weather/${(fn:replace(fn:replace(weather[0].forecast, 'c', 'C'), ' ', ''))}.png" />
				<img src="${weatherImage}" /> --%>
				 <c:url var="weatherImage"
					value="img/weather/${weather[0].forecast}.png" />
				<img src="${weatherImage}" /> 
				
			</div>
			<div class="currentWeatherInfo">
				<div class="weatherTemp"> High: <c:out value="${weather[0].highTemp}" /> </div>
				
				
				<div class="weatherTemp"> Low: <c:out value="${weather[0].lowTemp}" /> </div>
				<br>
			</div>
				<div class = "weatherMessage"> <c:out value = "${weather[0].weatherMessage }"/></div>
			
		
			<c:url var="conversionSubmit" value="/park" > 
			<c:param name="parkcode" value="${park.parkCode}"></c:param>
		</c:url>
			<form method="post" action="${conversionSubmit }">
				<input  type="radio" name="convert" value="C" <c:if test = "${isFahrenheit == false}">checked</c:if>>Celcius 
				<input type="radio" name="convert" value="F" <c:if test = "${isFahrenheit == true}">checked</c:if>>Fahrenheit 
				<input type="submit">
			</form>

			<p>
			<%-- 	<strong><c:out value="${parkWeather[0].weatherMessage}" /></strong> --%>
			</p>
		</div>

		<div class="fourDayWeatherContainer">
			<c:forEach items="${weather}" var="forecastWeather">
				<c:if test="${forecastWeather.day > 1}">
					<div class="individualForecasts">
						<div class="individualImage">
							<%-- <c:url var="weatherImage"
					value="img/weather/${(fn:replace(fn:replace(weather[0].forecast, 'c', 'C'), ' ', ''))}.png" />
				<img src="${weatherImage}" /> --%>
							 <c:url var="weatherImage" value="/img/weather/${weather[0].forecast}.png" />
							<img src="${weatherImage}" /> 
						</div>
						<div class="individualWeatherInfo">
							<div>  High: <c:out value="${forecastWeather.highTemp}" /> </div>
							<div> Low: <c:out value="${forecastWeather.lowTemp}" /> </div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>
<%@include file="common/footer.jsp" %>
