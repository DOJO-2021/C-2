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
<!-- パンくずリストここから -->
	<div class="ol">
			<ol class="breadcrumb" itemscope
				itemtype="https://schema.org/BreadcrumbList">
				<!-- 1つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/MenuServlet"> <span itemprop="name">メニュー</span>
				</a>
					<meta itemprop="position" content="1" /></li>

				<!-- 2つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/ChatServlet"> <span itemprop="name">雑談ルーム</span>
				</a>
					<meta itemprop="position" content="2" /></li>
				<!-- 3つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/Q_AServlet"> <span itemprop="name">Q&amp;Aルーム</span>
				</a>
					<meta itemprop="position" content="3" /></li>
				<!-- 4つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/TestServlet"> <span itemprop="name">理解度テスト</span>
				</a>
					<meta itemprop="position" content="4" /></li>
				<!-- 4つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/PwchangeServlet"> <span itemprop="name">パスワード変更はこちら</span>
				</a>
					<meta itemprop="position" content="5" /></li>
			</ol>
		</div>
<!-- パンくずリストここまで -->

<h2>理解度テスト</h2>
<h2>問題ジャンル:HTML</h2>
<br>
<form method="POST" action="/komike/TestServlet">
<table>
	<c:forEach var="e" items="${questions}">
		<tr>
		<th>問題</th>
			<td>
				<h4><c:out value ="${e.question_sentence}"/></h4><!--問題文-->
			</td>
		</tr>
		<tr>
		<tr>
			<td>
				<label><input type="radio" name="Question2" value="1"><c:out value ="${e.choice}"/></label>
			</td>
		</tr>
		<tr>
			<td>
				<label><input type="radio" name="Question2" value="2">選択肢2</label>
			</td>
		</tr>
		<tr>
			<td>
				<label><input type="radio" name="Question2" value="3">選択肢3</label>
			</td>
		</tr>
		<tr>
			<td>
				<label><input type="radio" name="Question2" value="4">選択肢4</label>
			</td>
		</tr>
	</c:forEach>
</table>

<input type="submit" name="JUDGE" value="回答終了">
</form>
</body>
</html>