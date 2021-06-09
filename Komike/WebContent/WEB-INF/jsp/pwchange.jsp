<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
<!--後でCSS反映 <link rel="stylesheet" href="/C-2/css/〇〇〇"> -->
</head>
<body>
<div class="form-wrapper">
		<main>
			<h1>Welcome</h1>
			<form method="POST" action="/simpleBC/LoginServlet" id="form">
				<div class="form-item">
					<label for="email"></label> <input type="text" name="ID"
						required="required" placeholder="Email Address"></input>
				</div>
				<div class="form-item">
					<label for="password"></label> <input type="text" name="PW"
						required="required" placeholder="Password"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" title="登録" value="Login"></input>
				</div>
			</form>
			<div class="form-footer">
				<p>
					<a href="#">Create an account</a>
				</p>
			</div>
		</main>
	</div>
</body>
</html>