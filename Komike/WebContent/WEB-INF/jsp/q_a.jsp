<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="./lib/jquery.pagination.js"></script>
<title>質問ルーム</title>
</head>
<body>
	<h1>Komike(仮)</h1>
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

	<!-- 検索結果のフォーム -->
	<form method="post" action="/komike/Q_AServlet" name="chat">
		<p>
			<label>キーワード検索：<input type="search" name="key" size="30"maxlength="255"></label>
		</p>
		<input type="submit" name="submit" value="検索する">
	</form>
	<!-- 検索結果のフォームここまで -->

	<h3>分からないことを質問してみましょう</h3>
	<p>質問は以下の欄に入力してください</p>
	<p>質問ルームへようこそ</p>
	<!-- 質問ルームへの書き込み内容を記入するフォーム -->
	<form method="post" action="/komike/Q_AServlet" name="q_a" enctype="multipart/form-data">
		<p>
			タイトル<input type="text" name="title">
		</p>
		<p>
			名前<input type="text" name="name">
		</p>

			添付画像<input type="file" name="image" accept="image/*"
				onchange="previewImage(this);">
				<canvas id = "preview" style ="max-width:200px;"></canvas>

		<br>
		<p>
			本文<br>
			<textarea name="text" id = "text"></textarea>
		</p>
		<input type="submit" name="submit" value="質問する" onclick="return cancelsubmit()">
	</form>
	<br>
	<!-- 質問ルームへの書き込み内容を記入するフォームここまで -->
	<!-- データベースから今までの掲示板の内容を全件表示 -->
<div class = "items">
	<c:forEach var="e" items="${questionList}">
		<div class = "comment">
		<p>
			Question_ID<c:out value="${e.question_id}" />
		</p>
		<br>
      	 ID<c:out value="${e.id}" />
		<br>
		<b>タイトル</b>
		<c:out value="${e.title}" />
		<br>
		<b>名前</b>
		<c:out value="${e.name}" />
		<br>
		<b>本文</b>
		<c:out value="${e.text}" />
		<br>
		<img src="${'/komike/images/'+=e.image_name}">
		<br>
	<!-- 高評価の内容を書き換える処理-->
		<form method = "post" action="/komike/Q_AServlet">
		<input type = "hidden" name = "question" value = "<c:out value="${e.question_id}" />">
		<input type = "hidden" name = "number" value = "<c:out value="${e.good_number}" />">
		<input type = "submit" name = "submit" value = "グッド">
		</form>
		高評価:<c:out value="${e.good_number}" />
	<!-- 高評価フォームここまで-->

	<!-- 質問に対して、返答するフォーム-->
		<form method="Post" action="/komike/Q_AServlet">
			<p>
				名前<input type="text" name="name1">
			</p>
			<p>
				本文<br>
				<textarea name="text1" id = "text1"></textarea>
			</p>
			<input type = "hidden" name = "question_id" value = "<c:out value="${e.question_id}" />">
			<input type="submit" name="submit" value="回答する" onclick ="return cancelsubmit1()">
		</form>
	<!-- 返答フォームここまで-->
		<hr>
		<!--返答を表示するフォーム-->
		<c:forEach var="a" items="${e.answer}">
			<p>
				Question_ID
				<c:out value="${a.question_id}" />
			</p>
			<br>
			<p>
				Answer_ID
				<c:out value="${a.answer_id}" />
			</p>
				ID<c:out value="${a.id}" />
			<br>
				<c:forEach var="b" items="${a.test_result}">
					<b>ジャンル</b>
					<c:out value="${b.genre}" />
					<b>ランク</b>
					<c:out value="${b.rank}" />
				</c:forEach>
			<b>名前</b>
			<c:out value="${a.name}" />
			<br>
			<b>本文</b>
			<c:out value="${a.text}" />
			<br>
			<hr>
		</c:forEach>
		</div>
	</c:forEach>
</div>
	<!-- 返答表示ここまで-->
</body>
<script>
function cancelsubmit(){
	if(document.getElementById("text").value === ""){
		window.alert("コメントを入力してください");
		return false;
	}
}

function cancelsubmit1(){
	if(document.getElementById("text1").value === ""){
		window.alert("コメントを入力してください");
		return false;
	}else{
		return true;
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

$('.items').pagination({
    itemElement : '> .comment' // アイテムの要素
});


</script>
</html>