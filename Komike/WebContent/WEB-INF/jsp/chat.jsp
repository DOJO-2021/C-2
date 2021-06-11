<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>雑談ルーム</title>
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
					href="/Komike/MenuServlet"> <span itemprop="name">メニュー</span>
				</a>
					<meta itemprop="position" content="1" /></li>

				<!-- 2つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/Komike/ChatServlet"> <span itemprop="name">雑談ルーム</span>
				</a>
					<meta itemprop="position" content="2" /></li>
				<!-- 3つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/Komike/Q_AServlet"> <span itemprop="name">Q&amp;Aルーム</span>
				</a>
					<meta itemprop="position" content="3" /></li>
				<!-- 4つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/Komike/TestServlet"> <span itemprop="name">理解度テスト</span>
				</a>
					<meta itemprop="position" content="4" /></li>
				<!-- 4つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/Komike/PwchangeServlet"> <span itemprop="name">パスワード変更はこちら</span>
				</a>
					<meta itemprop="position" content="5" /></li>
			</ol>
		</div>
<!-- パンくずリストここまで -->
<p>雑談ルームへようこそ</p>
<form method = "post" action="/komike/ChatServlet" name="chat">
<p>名前<input type = "text" name = "name"></p>
<p>本文<br>
<textarea name = "text"></textarea>
</p>
<input type = "submit" name = "submit" value = "書き込む">
</form>

<c:forEach var="list" items="${listAttribute}">
<p>ID:<c:out value="${list.id}"/>　名前:<c:out value="${list.name}"/>　日付:<c:out value="${list.time}"/><br>
<c:out value="${list.text}"/></p>
</c:forEach>
</body>
</html>