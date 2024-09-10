<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí tài khoản</title>
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
	.register-container h2{
	text-align: center;
	margin-bottom:20px;
	}
	input{
	height:40px;
	width:400px;
	border:1px solid #dadce0;
	padding:10px;
	border-radius:5px;
	font-size: inherit;
	color:#202124;
	}
	
	.register-btn{
	width:100%;
	background-color: #3EAEF4;
	color:white;
	padding:10px;
	margin:10px 0;
	boder-radius:5px;
	cursor:pointer;
	}
	
	</style>
	<form action="register" method="post">
	<div id="wrapper">
	<form action="">
		<h2>Đăng kí tài khoản</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Tên tài khoản" name="username"
						class="form-control">
				</div>
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Họ và tên" name="username"
						class="form-control">
				</div>
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Email" name="username"
						class="form-control">
				</div>
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Số điện thoại" name="username"
						class="form-control">
				</div>
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Mật khẩu" name="username"
						class="form-control">
				</div>
				
				
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Nhập lại mật khẩu" name="username"
						class="form-control">
				</div>
				
				
				<button type="submit" class="register-btn">Đăng kí</button>
				
				</form>
				
				
				
				</div>
		</div>
			</label>
		</section>
</body>
</html>