<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<h1>Create your own Group</h1>
<form:form action="/my_groups/new_group" class="form-inline" modelAttribute="groupDTO" method="POST">
	<form:hidden path="groupId"/>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Group Name: </label> 
				<form:input class="form-control registration-form-input-field" path="groupName" value="" required="true" placeholder="The name of the group..."/>
				<form:errors path="groupName" element="div" cssClass="error"/>
			</div>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label class="registration-form-label">Group Description: </label>
				<form:textarea class="form-control registration-form-input-field" rows="3" path="groupDescription" value="" required="true" placeholder="A short description of the group..."/>
				<form:errors path="groupDescription" element="div" cssClass="error" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="post-button">
			<input type="submit" class="btn btn-warning" value="Submit">
		</div>
	</div>
</form:form>