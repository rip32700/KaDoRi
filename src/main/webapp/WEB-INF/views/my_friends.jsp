<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<h1>Your Friends:</h1>
<br>
<p>
	<ul>
		<c:choose>
			<c:when test="${empty friendsList}">
				<div><c:out value="You don't have any friends yet :("></c:out></div>
			</c:when>
			<c:otherwise>
				<ul class="list-group">
					<c:forEach items="${friendsList}" var="friend">
  						<a href="/profile/${friend.username}" class="list-group-item">
							<c:out value="${friend.username}"></c:out>
						</a>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</ul>
