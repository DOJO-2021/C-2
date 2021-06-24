<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果￤Komike</title>
<link rel="stylesheet" href="/komike/css/menu.css">
</head>
<body class="body">
	<div class="wrapper">
				<div class="head">
			<div>
				<img src="/komike/images/Komike2.png" width="500" height="180"
					alt="写真">
			</div>
		</div>

			<form method="POST" action="/komike/regist_result"></form>
			<h2>
				<c:out value="${Regist_result.title}" />
			</h2>
			<p>
				<c:out value="${Regist_result.message}" />
			</p>
			<a href="${Regist_result.backTo}">戻る</a>
	</div>
</body>
</html>