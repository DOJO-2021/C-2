<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録 ¦ Komike</title>
<!--後でCSS反映 <link rel="stylesheet" href="/Komike/css/〇〇〇"> -->
</head>
<body>
	<div class="form-wrapper">
		<main>
			<h1>Komike</h1>
			<h2>受講者向け掲示板サイト</h2>
			<h3>新規登録</h3>
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