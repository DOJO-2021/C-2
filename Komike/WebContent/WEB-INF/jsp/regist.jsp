<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録 ¦ Komike</title>
<link rel="stylesheet" href="/komike/css/login.css">
</head>
<body>
	<div class="form-wrapper">
	<div class = "komike"><img src="/komike/images/Komike.png" width="220" height="240" alt="写真"></div>
		<main>
			<h2>新規登録</h2>
			<form method="POST" action="/komike/Regist" id="form">
				<div class="form-item">
					<label for="id"></label> <input type="text" name="id"
						required="required" placeholder="ID"></input>
				</div>
				<div class="form-item">
					<label for="password"></label> <input type="text" name="password"
						required="required" placeholder="Password"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" title="Login" value="登録"></input>
				</div>
			</form>
			<div class="form-footer"></div>
		</main>
	</div>
</body>
</html>