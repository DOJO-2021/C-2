<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録結果￤Komike</title>
<!-- <link rel="stylesheet" href="/simpleBC/css/cdstyle.css">-->
</head>
<body>
<h1>新規登録</h1>
<form method="POST" action="/Komike/regist_result"></form>
	<h2>
		<c:out value="${result.title}" />
	</h2>

	<p>
		<c:out value="${result.message}" />
	</p>
	<a class="haji" href="${result.backTo}">ログイン画面に戻る</a>
</body>
</html>