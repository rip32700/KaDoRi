<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<h1>New Post:</h1>
<form:form action="/new_Post" modelAttribute="postDTO" method="post" class="form-horizontal">
	<div class="form-group">
		<form:textarea class="form-control" rows="7" id="newPost" path="content" value="" placeholder="Enter your new Post..."/>
		<form:radiobutton class="radio-inline" id="newPost" path="isPublic" value="true"/>Make Post public
		<form:radiobutton class="radio-inline" id="newPost" path="isPublic" value="false"/>Make Post only visible for friends
		<div class="post-button">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" class="btn btn-warning" value="Post">
		</div>
	</div>
</form:form> 
<br>
<h1>Posts:</h1>
<br>
<p>
	<ul class="posts-list">
		<c:forEach items="${postsList}" var="post">
			<li>
				<div class="post-box">
					<c:if test="${post.isPublic eq true}">
						Public
					</c:if>
					<c:if test="${post.isPublic eq false}">
						Private
					</c:if>
					<div class="post-creation post-title"><c:out value="${post.creationTime}:"></c:out></div>
					<%-- <div class="post-title"><c:out value="${post.title}"></c:out><br></div> --%>
					<div class="post-content"><c:out value="${post.content}"></c:out><br></div>
					<div class="post-author">By <c:out value="${post.user.username}"></c:out></div>
				</div>
			</li>
		</c:forEach>
	</ul>
</p>


