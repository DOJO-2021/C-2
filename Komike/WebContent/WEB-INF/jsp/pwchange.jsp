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
			<h1>Komike</h1>
			<h2>受講者向け掲示板サイト</h2>
			<h3>パスワード変更</h3>
			<form method="POST" action="/Komike/Pwchange" id="form">
				<div class="form-item">
					<label for="password"></label> <input type="text" name="PW"
						required="required" placeholder="以前のパスワード"></input>
				</div>
				<div class="form-item">
					<label for="password"></label> <input type="text" name="PW"
						required="required" placeholder="新規パスワード"></input>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" title="Login" value="変更"></input>
				</div>
			</form>
			<div class="form-footer"></div>
		</main>
	</div>
</body>
</html>