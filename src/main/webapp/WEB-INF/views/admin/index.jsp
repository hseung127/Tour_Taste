<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Main</title>

</head>

<body>
<div id="travel">
	<header id="header">
	<div id="header_box">
		<%@ include file="header.jsp" %> 
		</div>
	</header>
	<section>
	<aside>
		<%@ include file="aside.jsp" %> 
	</aside>
	</section>
	<div id="container">
	<nav id="nav">
		<div id="nav_box">
		<%@ include file="nav.jsp" %>
		</div>
	</nav>
	<h1>본문</h1>
	</div>
	<footer id="footer">
	<div id="footer_box">
		<%@ include file="footer.jsp" %> 
	</div>
	
</footer>
</div>
</body>
</html>