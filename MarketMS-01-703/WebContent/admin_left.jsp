<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="500.html" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />

<script type="text/javascript" src="js/jquery-3.3.1.js" ></script>
<script>
	$(function(){
		$("#logout").click(function(){
			$.ajax({
				type:"post",
				url : "logout.do",
				async : true,
				success : function(){
					window.top.location.href= "login.html"
				}
			})
		})
	})
	
</script>


</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="admin_bill_list.html" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	
	<c:if test="${sessionScope.user.issupper == 1 }">
	<li><a href="providerAdmin.html" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="userAdmin.html" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	</c:if>
	
	<li><a href="#" id="logout"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
