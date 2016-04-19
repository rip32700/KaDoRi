<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Posts:</h1>
<br>
<p>
	<ul class="posts-list">
		<c:forEach items="${postsList}" var="post">
			<li>
				<div class="post-title"><c:out value="${post.title}"></c:out><br></div>
				<c:out value="${post.message}"></c:out><br>
				<div class="post-author">By <c:out value="${post.author.username}"></c:out></div>
			</li>
		</c:forEach>
	</ul>
</p>


