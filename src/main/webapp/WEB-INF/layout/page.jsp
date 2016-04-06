<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KaDoRi</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
	<!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/starter-template.css" />" />
</head>
<body>
	<div id="header">
		<t:insertAttribute name="header" />
	</div>
	
	
    
    <div class="container">

      <div class="starter-template">
		<t:insertAttribute name="body" />
      </div>
     </div>
	
	<div id="footer">
		<t:insertAttribute name="footer" />
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>