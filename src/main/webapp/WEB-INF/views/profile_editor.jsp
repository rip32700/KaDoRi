<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<form:form class="form-inline" modelAttribute="userDTO" method="POST">
	<form:hidden path="userId"/>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">First Name: </label> 
				<form:input class="form-control registration-form-input-field" path="firstName" value="" maxlength="45" required="true" placeholder="Your First Name..."/>
				<form:errors path="firstName" element="div" cssClass="error"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Last Name: </label>
				<form:input class="form-control registration-form-input-field" path="lastName" maxlength="45" value="" required="true" placeholder="Your Last Name..."/>
				<form:errors path="lastName" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Username: </label>
				<form:input class="form-control registration-form-input-field" path="username" maxlength="45" value="" required="true" placeholder="Your username..."/>
				<form:errors path="username" element="div" cssClass="error"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Email: </label>
				<form:input class="form-control registration-form-input-field" type="email" path="email" maxlength="45" value="" required="true" placeholder="Your E-Mail address..."/>
				<form:errors path="email" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Password: </label>
				<form:input class="form-control registration-form-input-field" path="password" maxlength="45" value="" type="password" required="true" placeholder="Your password..."/>
				<form:errors path="password" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Confirm Password: </label>
				<form:input class="form-control registration-form-input-field" path="matchingPassword" maxlength="45" value="" type="password" required="true" placeholder="Repeat your password..."/>
				<form:errors path="matchingPassword" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<form:input path="type" value="Landlord" hidden="true"/>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group ">
				<label class="control-label registration-form-label" for="birthday"> Birthday </label>
				<div class="input-group date" style="width: 220px; margin-top: 20px;" id="birthday" data-date-format="yyyy-mm-dd" data-provide="datepicker">
					<form:input class="form-control" placeholder="yyyy-mm-dd" type="text" path="birthday" required="true"/>
					<div class="input-group-addon" ><i class="fa fa-calendar"></i></div>
				</div>
				<form:errors path="birthday" element="div"  cssClass="error"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Street: </label>
				<form:input class="form-control registration-form-input-field" path="street" maxlength="45" value="" required="true" placeholder="Your Street Name..."/>
				<form:errors path="street" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Street Number: </label>
				<form:input class="form-control registration-form-input-field" path="streetNumber" maxlength="10" required="true" placeholder="Your Street Number..."/>
				<form:errors path="streetNumber" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">City: </label>
				<form:input class="form-control registration-form-input-field" maxlength="45" path="city" value="" required="true" placeholder="Your City Name..."/>
				<form:errors path="city" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">ZIP: </label>
				<form:input class="form-control registration-form-input-field" path="zip" maxlength="10" required="true" placeholder="Your ZIP code..."/>
				<form:errors path="zip" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<button style="margin-top: 20px; margin-left: 100px; width: 150px;" class="btn btn-warning" type="submit">Submit</button>
		</div>
	</div>
</form:form>