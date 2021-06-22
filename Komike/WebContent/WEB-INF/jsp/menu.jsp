<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link rel="stylesheet" href="/komike/css/menu.css">
</head>
<body class = "body">
	<div class="head">
		<div>
			<img src="/komike/images/Komike2.png" width="500" height="180"
				alt="写真">
		</div>
	</div>
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
				href="/komike/Tselect"> <span itemprop="name">理解度テスト</span>
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

	<h2>いまよく聞かれている質問</h2>
	<!-- データベースから今までの掲示板の内容を全件表示 -->
	<div class="test">
		<c:forEach var="e" items="${infList}">
			<p>
				QUESTION_ID
				<c:out value="${e.question_id}" />
			</p>
			<br>
			<b>ID</b>
			<c:out value="${e.id}" />
			<br>
			<b>件名</b>
			<c:out value="${e.title}" />
			<br>
			<b>名前</b>
			<c:out value="${e.name}" />
			<br>
			<b>本文</b>
			<c:out value="${e.text}" />
			<br>
			<b>高評価</b>
			<c:out value="${e.good_number}" />
			<br>
			<hr>
		</c:forEach>
	</div>
	<!-- フッター（ここから） -->
	<div class="footer">
		<p>&copy;Copyright DOJO2021. All rights reserved.</p>
	</div>
	<!-- フッター（ここまで） -->
</body>
</html>