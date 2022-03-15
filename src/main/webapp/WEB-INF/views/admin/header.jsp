<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script src="js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/bootstrap/bootstrap.min.js"></script>


<% response.setHeader("Cache-Control","no-store"); response.setHeader("Pragma","no-cache"); response.setDateHeader("Expires",0); if (request.getProtocol().equals("HTTP/1.1")) response.setHeader("Cache-Control", "no-cache"); %>




</head>
<body>
<h1><a href="admin_index">Admin Setting</a></h1>
<input class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='admin_logout'">
</body>
</html>