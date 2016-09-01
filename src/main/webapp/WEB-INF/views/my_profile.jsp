<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
		   <div class="panel-heading table-header">
		     <h2 class="panel-title">Welcome to your Profile ${currentUser.firstname} ${currentUser.lastname} </h2>
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
		               <td>${currentUser.firstname}</td>
		             </tr>
		             <tr>
		               <td>Last Name</td>
		               <td>${currentUser.lastname}</td>
		             </tr>
		             <tr>
		               <td>User Name</td>
		               <td>${currentUser.username}</td>
		             </tr>
		             <tr>
		               <td>E-Mail</td>
		               <td>${currentUser.email}</td>
		             </tr>
		             <tr>
		               <td>Date of Birth</td>
		               <td>${currentUser.birthday}</td>
		             </tr>
		             <tr>
		               <td>Street / Street number</td>
		               <td>${currentUser.street}  ${currentUser.streetNumber}</td>
		             </tr>
		             <tr>
		               <td>Zip / City</td>
		               <td>${currentUser.zip} ${currentUser.city}</td>
		                 </tr>
		               </tbody>
		             </table>
		           </div>
		         </div>
			</div> 
		</div>
	</div>
</div>
