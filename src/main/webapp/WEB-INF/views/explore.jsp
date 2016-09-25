<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>

<%-- <h1>Find people:</h1>
<form:form action="/search_request" modelAttribute="userDTO" method="post" class="form-horizontal">
	<div class="form-group">
		<form:textarea class="form-control" rows="1" id="search" path="username" value="" placeholder="Search for people..."/>
		<div class="post-button">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" class="btn btn-warning" value="Search">
			onclick="location.href='/profile/edit_profile'"
		</div>
	</div>
</form:form> 
<br> --%>
<h1>People around KaDoRi</h1>
<p> (excluding your friends) </p>
<br>
<p>
	<ul>
		<c:choose>
			<c:when test="${empty availableFriends}">
				<div><c:out value="No people available."></c:out></div>
			</c:when>
			<c:otherwise>
				<ul class="list-group">
					<c:forEach items="${availableFriends}" var="friend">
  						<a href="/profile/${friend.username}" class="list-group-item">
							<c:out value="${friend.username}"></c:out>
						</a>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</ul>
<br>
<h1>Groups in KaDoRi</h1>
<br>
<p>
	<ul>
		<c:choose>
			<c:when test="${empty availableGroups}">
				<div><c:out value="No groups available."></c:out></div>
			</c:when>
			<c:otherwise>
				<ul class="list-group">
					<c:forEach items="${availableGroups}" var="groupItem">
  						<a href="/group/${groupItem.groupId}" class="list-group-item">
							<c:out value="${groupItem.groupName}"></c:out>
						</a>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</ul>