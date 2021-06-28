<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー￤Komike</title>
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
				<!-- 5つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/PwchangeServlet"> <span itemprop="name">パスワード変更はこちら</span>
				</a>
					<meta itemprop="position" content="5" /></li>
				<!-- 6つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/LogoutServlet"> <span itemprop="name">ログアウトはこちら</span>
				</a>
					<meta itemprop="position" content="6" /></li>
			</ol>
		</div>
		<!-- パンくずリストここまで -->

		<p>${Login_user.id}</p>
		<br>
		<h2>いまよく聞かれている質問</h2>
		<!-- データベースから今までの掲示板の内容を全件表示 -->
		<div class="items">
			<c:forEach var="e" items="${infList}">
				<div class="comments">
					<div class="comment">
						<ul class="combox">
							<li class="comno">Question<c:out value="${e.question_id}" /></li>
							<li class="title"><c:out value="${e.title}" /></li>
							<li class="comname"><c:out value="${e.name}" /></li>
							<li class="comname">高評価<c:out value="${e.good_number}" /></p>
							<li class="break"></li>
						</ul>
						<ul class="comcom">
							<li class="comtxt"><c:out value="${e.text}" /></li>
					</div>
				</div>

			</c:forEach>
		</div>
		<!-- フッター（ここから） -->
		<div class="footer">
			<p>&copy;Copyright DOJO2021. All rights reserved.</p>
		</div>
		<!-- フッター（ここまで） -->
	</div>
</body>
</html>