<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="login-container">
	<div class="login-card">
		<div class="login-form">
			
			
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h2>Login</h2>
				<br>
				<form action="<c:url var="loginUrl" value="/login" />" method="post" class="form-horizontal">
					
					<!-- MESSAGE -->
					<c:if test="${param.error != null}">
						<div class="alert alert-danger"><p>Invalid username and password.</p></div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success"> <p>You have been logged out successfully.</p></div>
					</c:if>
					
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label> 
						<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
					</div>
					
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
					</div>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
					<input type="submit" style="margin-top: 20px; width: 100px;" class="btn btn-primary" value="Log in">

				</form>
				<br>
				<p>
					If you haven't got an account yet, please <a href="<c:url value="/register" />">sign up</a> first.
				</p>
				
				
			
			</div>
		</div>
			
		</div>
	</div>
</div>




