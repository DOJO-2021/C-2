<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="./lib/jquery.pagination.js"></script>
<title>検索結果</title>
<link rel="stylesheet" href="/komike/css/menu.css">
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
<h2>検索結果</h2>
<!-- 検索結果の表示 -->
<div class ="items">
 <c:forEach var="e" items="${question}" >
 	<div class ="comments">
 		<ul class = "combox">
			<li class ="comno"><c:out value ="${e.question_id}"/></li>
			<li class ="title"><c:out value ="${e.title}" /></li>
			<li class ="comname"><c:out value ="${e.name}" /></li>
			<li class ="comtext"><c:out value="${e.text}" /></li>
			<li class ="returncnt"><c:out value="${e.good_number}"/></li>
		</ul>
			<c:forEach var="a" items="${e.answer}" >
				<ul class = "combox2">
					<li class = "comno">Answer<c:out value ="${a.answer_id}"/></li>
					<li class = "comname"><c:out value ="${a.name}" /></li>
					<li class = "comtext"><c:out value="${a.text}" /></li>
				</ul>
			</c:forEach>
	</div>
</c:forEach>
</div>
</body>
<script>
$('.items').pagination({
    itemElement : '> .comments' // アイテムの要素
});
</script>
</html>