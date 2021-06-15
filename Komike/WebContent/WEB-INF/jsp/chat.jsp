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
<p>id<input type = "text" name = "id" ></p>
<p>名前<input type = "text" name = "name"></p>
<p>添付画像<input type = "file" name  = "image"></p>
<p>本文<br>
<textarea name = "text" id = "text"></textarea>
</p>
<input type = "submit" name = "submit" value = "書き込む" onclick = "return cancelsubmit()">
</form>

<div class="test">

<c:forEach var="e" items="${infList}" >
	<p>Chat_ID<c:out value ="${e.chat_id}"/></p><br>
		ID<c:out value ="${e.id}"/><br>
	 <b>名前</b><c:out value ="${e.name}" /><br>
	 <b>本文</b><c:out value="${e.text}" /><br>
	 <b>時間</b><c:out value="${e.time}"/><br>
 <form method = "post" action="/komike/ChatServlet" name="chat2">
 <input type="hidden" name="chat_id" value="<c:out value ="${e.chat_id}"/>">
	 <input type = "submit" name = "submit" value = "削除">
</form>
<hr>
</c:forEach>

</div>
</body>
<script>
function cancelsubmit(){
	if(document.getElementById("text").value === ""){
		window.alert("コメントを入力してください");
		return false;
	}
}



</script>
</html>