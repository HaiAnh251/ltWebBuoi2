<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
          href="style.css">
</head>
<body>

	<style>
		
		@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
	*{
		box-sizing: border-box;
	}
	body{
		font-family: 'Montserrat', sans-serif;
		font-size:17px; 
	}
	#wrapper{
		display: flex;
		justify-content: center;
		align-items: center;
		min-height:80vh;
	}
	form{
		border:1px solid #dadce0;
		border-radius:5px;
		padding:20px;
	}
	h3{
		text-align:center;
		font-size:24px;
		font-weight:500;
	}
	.form-group
	{
		margin-bottom:15px;
		position: relative;
	}
	input{
	height:40px;
	width:200px;
	outline:none;
	border:1px solid #dadce0;
	padding:10px;
	border-radius:5px;
	font-size: inherit;
	color:#202124;
	
	}
	label{
		position:absolute;
		padding: 0px 5px;
		left:5px;
		top:50%;
		pointer-events:none;
		transform:translateY(-50%);
		background:#fff
		transition: all 0.3 ease-in-out;
	}
	.form group input:focus{
		border:2px solid #1a73e8;
	}
	.form-group input:focus+label,.form-group input:valid+label{
		top:0px;
		font-size:13px;
		font-weight:500;
		color:#1a73e8;
	}
	
	</style>
	<div id="wrapper">
	<form action="/laptrinhWebbuoi2/login" method="post">
		<c:if test="${alert !=null }">
			<h2 class="alert alert danger">${alert}</h2>
		</c:if>
	<h3>Login</h3>
	<div class="form-group">
		<input type="text" name="username" required>
		<label for="">Username</label>
	</div>
	
	<div class="form-group">
		<input type="text" name="password" required>
		<label for="">Password</label>
	</div>
	
	<input type="submit" value="submit" id="btn-login">
	
	</form>
	</div>
</body>
</html>