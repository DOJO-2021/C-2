<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン￤Komike</title>
<link rel="stylesheet" href="/komike/css/login.css">
</head>
<body>
	<div class="form-wrapper">
		<main>
	<div class = "komike"><img src="/komike/images/Komike.png" width="220" height="240" alt="写真"></div>
			<form method="POST" action="/komike/Login" id="form">
				<div class="form-item">
					<label for="id"></label> <input type="text" name="id"
						required="required" placeholder="ID"></input>
				</div>
				<div class="form-item">
					<label for="password"></label> <input type="text" name="password"
						required="required" placeholder="Password"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" title="Login" value="Login"></input>
				</div>
			</form>
			<div class="form-footer">
				<p>
					<a href="/komike/Regist">初めての方はこちら</a>
				</p>
			</div>
		</main>
	</div>
</body>
</html>