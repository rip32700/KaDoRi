<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>New Post:</h1>
<form action="/new_Post" modelAttribute="post" method="post" class="form-horizontal">
	<div class="form-group">
	  <textarea class="form-control" rows="5" id="newPost"></textarea>
		<div class="post-button">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" class="btn btn-warning" value="Post">
		</div>
	</div>
</form> 
<br>
<h1>Posts:</h1>
<br>
<p>
	<ul class="posts-list">
		<c:forEach items="${postsList}" var="post">
			<li>
				<div class="post-box">
					<div class="post-creation"><c:out value="${post.creationTime}:"></c:out></div>
					<%-- <div class="post-title"><c:out value="${post.title}"></c:out><br></div> --%>
					<c:out value="${post.content}"></c:out><br>
					<div class="post-author">By <c:out value="${post.user.username}"></c:out></div>
				</div>
			</li>
		</c:forEach>
	</ul>
</p>


