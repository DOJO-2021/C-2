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
<p>雑談ルームへようこそ</p>
<!-- 掲示板への書き込み内容を記入するフォーム -->
<form method = "post" action="/komike/ChatServlet" name="chat" enctype="multipart/form-data">
	<p>id<input type = "text" name = "id" ></p>
	<p>名前<input type = "text" name = "name"></p>
	<p>添付画像<input type = "file" name  = "image" accept = "image/*" onchange ="previewImage(this);"></p>
	<!-- 添付画像のプレビューを表示 -->
	<canvas id = "preview" style ="max-width:200px;"></canvas><br>
	<p>本文<br>
	<textarea name = "text" id = "text"></textarea>
	</p>
	<input type = "submit" name = "submit" value = "書き込む"  onclick  ="return cancelsubmit()">
</form>

<!-- データベースから今までの掲示板の内容を全件表示 -->
<div class="test">
<c:forEach var="e" items="${infList}" >
		<p>Chat_ID<c:out value ="${e.chat_id}"/></p><br>
		<b>ID</b><c:out value ="${e.id}"/><br>
		<b>名前</b><c:out value ="${e.name}" /><br>
		<b>本文</b><c:out value="${e.text}" /><br>
		<img src="${'/komike/images/'+=e.image_name}"><br>
		<b>時間</b><c:out value="${e.time}"/><br>
	 <form method = "post" action="/komike/ChatServlet" name="chat2">
	 	<input type="hidden" name="chat_id" value="<c:out value ="${e.chat_id}"/>">
		<input type = "submit" name = "submit" value = "削除" onclick = "return deletesubmit()">
	</form>
	<hr>
</c:forEach>
</div>
</body>
<script>
//「書き込み」を押したときに、本文が空であったらfalseを返し、書き込み出来なくする機能
function cancelsubmit(){
	if(document.getElementById("text").value === ""){
		window.alert("コメントを入力してください");
		return false;
	}
}

//画像を表示させる機能
function previewImage(obj){
	var fileReader = new FileReader();

	//画像ファイル読み込み後に実行
	fileReader.onload = (function(){
	//canvasエリアにプレビュー画像を表示
		var canvas = document.getElementById('preview');
		var ctx = canvas.getContext('2d');
		var image = new Image();
		image.src = fileReader.result;
		console.log(fileReader.result) //確認用

		image.onload = (function(){
			canvas.width = image.width;
			canvas.height = image.height;
			ctx.drawImage(image, 0, 0);
		});
	});
	//画像の読み込み
	fileReader.readAsDataURL(obj.files[0]);
	console.log(fileReader.result)　　//確認用
}

//削除する際に確認するjs
function deletesubmit(){
	var result = window.confirm("削除してもよろしいですか");

	if(result){
		return ture;
	}else {
		return false;
	}
}

</script>
</html>