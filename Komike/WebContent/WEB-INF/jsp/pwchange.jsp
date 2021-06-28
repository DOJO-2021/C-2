<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
<link rel="stylesheet" href="/komike/css/login.css">
</head>
<body>
	<div class="form-wrapper">
		<div class = "komike"><img src="/komike/images/Komike.png" width="220" height="240" alt="写真"></div>
		<main>
			<h2>パスワード変更</h2>
			<form method="POST" action="/komike/PwchangeServlet" id="form">
				<div class="form-item">
					<label for="password"></label>
					<input type="password" name="password" required="required" placeholder="以前のパスワード"></input>
				</div>
				<div class="form-item">
					<label for="password"></label>
					 <input type="password" name="password2" required="required" placeholder="新規パスワード"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" title="change" value="変更"></input>
				</div>
			</form>
			<div class="form-footer"></div>
		</main>
	</div>
</body>
</html>