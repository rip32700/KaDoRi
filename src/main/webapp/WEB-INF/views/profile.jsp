<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
		   <div class="panel-heading table-header">
		   	 <c:choose>
   			 	<c:when test="${currentUser.equals(user)}">
		   	 		<h2 class="panel-title">Welcome to your Profile ${user.firstname} ${user.lastname} </h2>
		   	 	</c:when>
		   	 	<c:otherwise>
		   	 		<h2 class="panel-title">Welcome to ${user.username}'s Profile </h2>
		   	 	</c:otherwise>
		   	 </c:choose>
		   </div>
		   <br/>
		   <div class="panel-body">
		     <div class="row">
		      <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="https://www.lib.purdue.edu/assets/images/people/noImage.png" class="img-circle img-responsive"> </div>
		       <div class=" col-md-9 col-lg-9 "> 
		         <table class="table table-user-information">
		           <tbody>
		             <tr>
		               <td>First Name</td>
		               <td>${user.firstname}</td>
		             </tr>
		             <tr>
		               <td>Last Name</td>
		               <td>${user.lastname}</td>
		             </tr>
		             <tr>
		               <td>User Name</td>
		               <td>${user.username}</td>
		             </tr>
		             <tr>
		               <td>E-Mail</td>
		               <td>${user.email}</td>
		             </tr>
		             <tr>
		               <td>Date of Birth</td>
		               <td>${user.birthday}</td>
		             </tr>
		             <tr>
		               <td>Street / Street number</td>
		               <td>${user.street}  ${user.streetNumber}</td>
		             </tr>
		             <tr>
		               <td>Zip / City</td>
		               <td>${user.zip} ${user.city}</td>
		                 </tr>
		               </tbody>
		             </table>
		           </div>
		       </div>
		       <c:choose>
			    <c:when test="${currentUser.equals(user)}">
			       <div class="row">
			       		<button type="button" class="btn btn-warning" onclick="location.href='/profile/edit_profile'">Edit profile data</button>
			       		<button type="button" class="btn btn-warning" onclick="location.href='/profile/my_profile/delete'">Delete profile</button>
			       </div>
			    </c:when>
			    <c:when test="${isFriend.equals(true)}">
			       <div class="row">
			       		<button type="button" class="btn btn-warning" onclick="location.href='/profile/${user.username}/remove_friend'">Remove friend</button>
			       </div>
			    </c:when>      
			    <c:otherwise>
			       <div class="row">
			       		<button type="button" class="btn btn-warning" onclick="location.href='/profile/${user.username}/add_friend'">Add as friend</button>
			       </div>
			    </c:otherwise>
			   </c:choose>
		       <%-- <c:if test="${currentUser.equals(user)}">
			       <div class="row">
			       		<button type="button", class="btn btn-warning" onclick="location.href='/profile/edit_profile'">Edit profile data</button>
			       </div>
		       </c:if>
		       <c:if test="${currentUser.notEquals(user)}">
			       <div class="row">
			       		<button type="button", class="btn btn-warning" onclick="location.href='/profile/edit_profile'">Edit profile data</button>
			       </div>
		       </c:if> --%>
			</div> 
		</div>
	</div>
</div>
