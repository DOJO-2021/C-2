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
<title>雑談ルーム￤Komike</title>
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
		<section>
		<br>
			<h2>雑談ルームへようこそ</h2>
			<!-- 掲示板への書き込み内容を記入するフォーム -->
			<form method="post" action="/komike/ChatServlet" name="chat"
				enctype="multipart/form-data">
				<div class="name">
					<span class="label">お名前:</span><input type="text" name="name">
				</div>
				<div class="image">
					<span class="label">添付画像</span><input type="file" name="image"
						accept="image/*" onchange="previewImage(this);">
				</div>
				<!-- 添付画像のプレビューを表示 -->
				<canvas id="preview" style="max-width: 200px;"></canvas>
				<div class="honbun">
					<span class="label">本文:</span>
					<textarea name="text" id="text" cols="40" rows="6"></textarea>
				</div>
				<input type="submit" name="submit" value="書き込む"
					onclick="return cancelsubmit()">
			</form>
		</section>
		<section>
			<br>
			<hr>
			<br>
			<h2>投稿一覧</h2>
			<br>
			<div class="items">
				<br> <br>
				<c:forEach var="e" items="${infList}">
					<div class="comments">
						<div class="comment">
							<ul class="combox">
								<li class="comno"><c:out value="${e.chat_id}" /></li>
								<li class="comname"><c:out value="${e.name}" /></li>
								<li class="comtime"><c:out value="${e.time}" /></li>
								<li class="comdele">
									<form method="post" action="/komike/ChatServlet" name="chat2">
										<input type="hidden" name="chat_id"
											value="<c:out value ="${e.chat_id}"/>"> <input
											type="hidden" name="getId" value="<c:out value ="${e.id}"/>"><br>
										<input type="submit" name="submit" value="削除"
											onclick="return deletesubmit()">
									</form>
								</li>
								<li class="break"></li>
							</ul>
							<ul class="comcom">
								<li class="comtxt"><c:out value="${e.text}" /></li>

								<img src="${'/komike/images/'+=e.image_name}" width="500"
									height="180" alt="pic">

								<!--  -<li class="comreturn">
									<form action="index.php" method="post" style="display: inline">
										<input type="hidden" name="returnno" value="12"> <input
											type="submit" class="RETURNBT" value="返信">
									</form>
								</li>
								<li class="returncnt">0</li>-->
								<li class="break"></li>
							</ul>
						</div>
						<div class="break"></div>
					</div>
				</c:forEach>
			</div>
		</section>
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
/*
$(function() {
	$('.items').paginathing({//親要素のclassを記述
		perPage: 5,//1ページあたりの表示件数
		prevText:'前へ',//1つ前のページへ移動するボタンのテキスト
		nextText:'次へ',//1つ次のページへ移動するボタンのテキスト
		activeClass: 'navi-active',//現在のページ番号に任意のclassを付与できます
	})
});
*/

$('.items').pagination({
    itemElement : '> .comments' // アイテムの要素
});


</script>
</html>