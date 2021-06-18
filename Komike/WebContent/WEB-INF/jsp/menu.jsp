<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
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
<form method = "post" action="/komike/MenuServlet" name="chat">
  <p><label>キーワード検索：<input type="search" name="key" size="30" maxlength="255"></label></p>
  <input type = "submit" name = "submit" value = "検索する">
 </form>
 <c:forEach var="e" items="${question}" >
		<p>QUESTION_ID<c:out value ="${e.question_id}"/></p><br>
		<b>ID</b><c:out value ="${e.id}"/><br>
		<b>件名</b><c:out value ="${e.title}" /><br>
		<b>名前</b><c:out value ="${e.name}" /><br>
		<b>本文</b><c:out value="${e.text}" /><br>
		<b>高評価</b><c:out value="${e.good_number}"/><br>
	<hr>
		<p>QUESTION_ID<c:out value ="${e.question_id}"/></p><br>
		<b>ID</b><c:out value ="${e.id}" /><br>
		<b>名前</b><c:out value ="${e.name}" /><br>
		<b>本文</b><c:out value="${e.text}" /><br>
</c:forEach>

<h2>いまよく聞かれている質問</h2>
<!-- データベースから今までの掲示板の内容を全件表示 -->
<div class="test">
<c:forEach var="e" items="${infList}" >
		<p>QUESTION_ID<c:out value ="${e.question_id}"/></p><br>
		<b>ID</b><c:out value ="${e.id}"/><br>
		<b>件名</b><c:out value ="${e.title}" /><br>
		<b>名前</b><c:out value ="${e.name}" /><br>
		<b>本文</b><c:out value="${e.text}" /><br>
		<b>高評価</b><c:out value="${e.good_number}"/><br>
	<hr>
</c:forEach>
</div>
</body>
</html>