<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>理解度テスト|選択画面</title>
<link rel="stylesheet" href="/komike/css/test.css">
</head>
<body class = "body">
	<div class="head">
		<div>
			<img src="/komike/images/Komike2.png" width="500" height="180"
				alt="写真">
		</div>
	</div>

<form method="POST" action="/komike/Tselect">
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

	<table class=select>

		<tr>
			<td><a href="/komike/TestServlet?key=HTML" class="bt-samp44">HTML</a><br>
			</td>
			<td><a href="/komike/TestServlet?key=css" class="bt-samp44">css</a><br>
			</td>
			<td><a href="/komike/TestServlet?key=JavaScript"class="bt-samp44">JavaScript</a><br>
			</td>
		</tr>
		<tr>
			<td><a href="/komike/TestServlet?key=java"class="bt-samp44">java</a><br>
			</td>
			<td><a href="/komike/TestServlet?key=データベース"class="bt-samp44">データベース</a><br>
			</td>
			<td><a href="/komike/TestServlet?key=サーバーサイドjava" class="bt-samp44">サーバーサイドjava</a><br>
			</td>
		</tr>
	</table>
 </form>
 <!-- フッター（ここから） -->
	<div class="footer">
		<p>&copy;Copyright DOJO2021. All rights reserved.</p>
	</div>
	<!-- フッター（ここまで） -->
</body>
</html>