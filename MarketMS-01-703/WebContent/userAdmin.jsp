<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="500.html" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(obj)
{

}
</script>
</head><body>




<div class="menu">

<table>
<tbody><tr><td><form method="post" action="user.do">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.html'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
  </tr>
  
<c:forEach items="${users }" var="user">
  <tr>
    <td height="23"><span class="STYLE1">${user.id }</span></td>
    <td><span class="STYLE1"><a href="userInfo.do?id=${user.id }">${user.username }</a></span></td>
    <td><span class="STYLE1">${user.gender == 1 ? "男" : "女" }</span></td>
    <td><span class="STYLE1">${user.age }</span></td>
    <td><span class="STYLE1">${user.tel }</span></td>
    <td><span class="STYLE1">${user.address }</span></td>
    <td><span class="STYLE1">${user.issupper == 1 ? "经&nbsp;理":"员&nbsp;工"}</span></td>

  </tr>
  </c:forEach>
</tbody></table>
</div>
</div>
</body></html>