<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<input type="submit" style="float:right" class="btn btn-warning" onclick="location.href='/my_groups/new_group'" value="Create Group">
<br>
<h1>Your Groups:</h1>
<br>
<p>
	<ul>
		<c:choose>
			<c:when test="${empty groupsList}">
				<div><c:out value="You are not a member of any group yet."></c:out></div>
			</c:when>
			<c:otherwise>
				<ul class="list-group">
					<c:forEach items="${groupsList}" var="group">
  						<a href="/group/${group.groupId}" class="list-group-item">
							<c:out value="${group.groupName}"></c:out>
						</a>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</ul>