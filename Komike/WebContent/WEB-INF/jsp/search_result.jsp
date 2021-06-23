<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<h1>Komike</h1>
<h2>受講者向け掲示板サイト</h2>
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
<!-- 検索結果の表示 -->
 <c:forEach var="e" items="${question}" >
		<p>QUESTION_ID<c:out value ="${e.question_id}"/></p><br>
		<b>ID</b><c:out value ="${e.id}"/><br>
		<b>件名</b><c:out value ="${e.title}" /><br>
		<b>名前</b><c:out value ="${e.name}" /><br>
		<b>本文</b><c:out value="${e.text}" /><br>
		<b>高評価</b><c:out value="${e.good_number}"/><br>
<hr>
			<c:forEach var="a" items="${e.answer}" >
				<p>QUESTION_ID<c:out value ="${a.question_id}"/></p><br>
				<p>ANSWER_ID<c:out value ="${a.answer_id}"/></p><br>
				<b>ID</b><c:out value ="${a.id}" /><br>
				<b>名前</b><c:out value ="${a.name}" /><br>
				<b>本文</b><c:out value="${a.text}" /><br>
			</c:forEach>
<hr>
</c:forEach>
</body>
</html>