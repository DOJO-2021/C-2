<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録 ¦ Komike</title>
</head>
<body>
	<div class="form-wrapper">
		<main>
			<form method="POST" action="/Komike/LoginServlet" id="form">
				<div class="form-item">
					<label for="id"></label> <input type="text" name="ID"
						required="required" placeholder="ID"></input>
				</div>
				<div class="form-item">
					<label for="password"></label> <input type="text" name="PW"
						required="required" placeholder="Password"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" title="Login" value="Login"></input>
				</div>
			</form>
			<div class="form-footer">
			</div>
		</main>
	</div>
</body>
</html>