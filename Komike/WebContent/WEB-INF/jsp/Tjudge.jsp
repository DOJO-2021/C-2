<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト結果￤Komike</title>
<link rel="stylesheet" href="/komike/css/test.css">
</head>
<body>
<body class = "body">
<div class="wrapper">
	<div class="head">
		<div>
			<img src="/komike/images/Komike2.png" width="500" height="180"
				alt="写真">
		</div>
	</div>

<form method="POST" action="/komike/Tjudge">

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
						<!-- 6つめ -->
				<li itemprop="itemListElement" itemscope
					itemtype="https://schema.org/ListItem"><a itemprop="item"
					href="/komike/LogoutServlet"> <span itemprop="name">ログアウトはこちら</span>
				</a>
					<meta itemprop="position" content="6" /></li>
			</ol>
		</div>
<!-- パンくずリストここまで -->


<h2>理解度テスト結果</h2>
			<h3>問題ジャンル:<c:out value="${Test_result.genre}" /></h3><br>

			<table class=result>


				<tr>
					<th>正解数/問題数</th>
					<th>正解数</th>
					<th>今回のランク</th>
				</tr>
				<tr>
					<td><c:out value="${Test_result.correct_answer}" />問/20問</td>
					<td><c:out value="${Test_result.correct_answer_rate}" />%</td>
					<td><c:out value="${Test_result.rank}" /></td>
				</tr>
			</table><br>

			<a  href="/komike/Tselect">ジャンル選択</a>
</form>
<div class="wrapper">
</body>
</html>