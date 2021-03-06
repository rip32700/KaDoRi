<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<c:choose>
	<c:when test="${isInGroup.equals(true)}">
		<div class="row">
			<button type="button" class="btn btn-warning" style="float:right" onclick="location.href='/group/${group.groupId}/leave_group'">Leave Group</button>
		</div>
	</c:when>      
	<c:otherwise>
	   <div class="row">
	   		<button type="button" class="btn btn-warning" style="float:right" onclick="location.href='/group/${group.groupId}/join_group'">Join Group</button>
	   </div>
	</c:otherwise>
</c:choose>
<br>
<h1>Welcome to Group "${group.groupName}"</h1> 
<br>
<h2>Description:</h2>
<div>"${group.groupDescription}"</div>
<h2>Group Members:</h2>
<ul class="list-group">
	<c:forEach items="${groupMembers}" var="member">
				<a href="/profile/${member.username}" class="list-group-item">
			<c:out value="${member.username}"></c:out>
		</a>
	</c:forEach>
</ul>
<h2>New Post:</h2>
<form:form action="/group/${group.groupId}/new_Post" modelAttribute="postDTO" method="post" class="form-horizontal">
	<div class="form-group">
		<form:textarea class="form-control" rows="7" id="newPost" path="content" value="" placeholder="Enter your new Post..."/>
		<div class="post-button">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" class="btn btn-warning" value="Post">
		</div>
	</div>
</form:form> 
<br>
<h2>Posts:</h2>
<br>
<p>
	<ul class="posts-list">
		<c:forEach items="${groupPostsList}" var="post">
			<li>
				<div class="post-box">
					<div class="post-creation post-title"><c:out value="${post.creationTime}:"></c:out></div>
					<div class="post-content"><c:out value="${post.content}"></c:out><br></div>
					<div class="post-author">By <c:out value="${post.user.username}"></c:out></div>
				</div>
			</li>
		</c:forEach>
	</ul>
</p>
