<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript">
	//通过jq代码实现对表单的验证
	$(function() {
		//先找到需要校验的表单对象,validate函数为对象绑定校验规则
		$("#form1").validate({
			//定义规则
			rules : {
				//键是input对应的name属性的input对象
				id : {
					digits : true,
					rangelength : [ 1, 5 ]
				},
				username : {
					required : true,
					rangelength : [ 5, 20 ]
				},
				password : {
					required : true,
					rangelength : [ 5, 10 ]
				},
				password1 : {
					equalTo : "[name='password']"
				},
				age : {
					digits : true,
					range : [ 18, 100 ]
				},
			},
			messages : {}
		}) // validate()
	}) //
	
	$(function(){
		$("#save_button").click(function(){
		
			$("#action_flag").val("save")
			$("#form1").submit()
		})
		$("#del_button").click(function(){
			$.ajax({
				type : "post",
				url : "userModify.do",
				async : true,
				data : {"id":$("input[name='id']").val(),"flag":"del"},
				success : function(){
					window.location="userAdmin.do"
				}
			})
		})
	})
	
	
	
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
<c:set var="user" value="${requestScope.user }"></c:set>
		</div>
		<form id="form1" name="form1" method="post" action="userModify.do">
			<input type="hidden" name="flag" id="action_flag" />
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">用户编号：</td>
						<td>&nbsp;${user.id }<input type="hidden" name="id" 
							class="text" value="${user.id }" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">用户名称：</td>
						<td><input type="text" name="username" class="text" value="${user.username}"/> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户密码：</td>

						<td><input type="password" name="password" class="text" value="${user.password }"/> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" name="password1" class="text" value="${user.password }"/> <font
							color="red">*</font></td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>&nbsp;&nbsp;男<input type="radio" name="gender" ${user.gender==1 ? "checked='checked'" : ""  } value="1"/>&nbsp;&nbsp;女<input
							type="radio" name="gender" ${user.gender==0 ? "checked='checked'" : ""  } value="0"/></td>
					</tr>

					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="age" class="text" value="${user.age }"/> <font
							color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="tel" value="${user.tel }" class="text" /> <font
							color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><textarea name="address"  class="text" cols="45" rows="5">${user.address }</textarea></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td><input type="radio" name="issupper" value="0"
							${user.issupper==0 ? "checked='checked'": ""} />普通用户 <input type="radio" name="issupper"
							value="1" ${user.issupper==1 ? "checked='checked'": ""}/>经理</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" id="save_button" value="保存修改" class="input-button" />
				<input type="button" id="del_button" value="删除用户" class="input-button" />
				<input type="button" name="back_button"
					onclick="window.location='userAdmin.do';" value="返回"
					class="input-button" />
			</div>

		</form>
	</div>
</body>
</html>
