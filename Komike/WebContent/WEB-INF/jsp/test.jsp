<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト</title>
<script>
'use strict';
</script>
</head>
<body>
<h1>Komike</h1><h2>受講者向け掲示板サイト</h2>

<h2>理解度テスト</h2>
<h2>問題ジャンル:</h2>
<br>
<form method="POST" action="/komike/TestServlet">
<input type="text" name="testType" value="${Select.genre}">
<table>
	<c:forEach var="e" items="${questions}">
		<tr>
		<th>問題</th>
			<td>
				<h4><c:out value ="${e.question_sentence}"/></h4><!--問題文-->
			</td>
		</tr>
		<tr>
		<c:forEach var="d" items="${e.choice_detail}">
			<td>
				<label><input type="radio" name="${e.question_number}" value="${d.choice_number}"><c:out value ="${d.choice}"/></label>
			</td>
		</tr>
		</c:forEach>
		</c:forEach>
</table>

<input type="submit" name="JUDGE" value="回答終了">
</form>
</body>
</html>