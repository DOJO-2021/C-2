<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果￤Komike</title>
<!-- <link rel="stylesheet" href="/simpleBC/css/cdstyle.css">-->
</head>
<body>
	<h1>Komike</h1>
	<h2>受講者向け掲示板サイト</h2>
	<form method="POST" action="/komike/regist_result"></form>
	<h2>
		<c:out value="${Regist_result.title}" />
	</h2>
	<p>
		<c:out value="${Regist_result.message}" />
	</p>
	<a href="${Regist_result.backTo}">戻る</a>
</body>
</html>