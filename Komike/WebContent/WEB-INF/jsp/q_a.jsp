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
<title>質問ルーム￤Komike</title>
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

		<!-- 検索結果のフォーム -->
		<section>
			<br>
			<div class="search">
				<form method="post" action="/komike/Q_AServlet" name="chat">
					<label>キーワード検索：<input type="search" name="key" size="30"
						maxlength="255"></label>
					<li class="searchbotan"><input class="BT" type="submit"
						name="submit" value="検索する">
				</form>
			</div>
			<br>
			<!-- 検索結果のフォームここまで -->

			<h2>分からないことを質問してみましょう</h2>
			<br>

			<!-- 質問ルームへの書き込み内容を記入するフォーム -->
			<form method="post" action="/komike/Q_AServlet" name="q_a"
				enctype="multipart/form-data">
				<div class="title">
					<span class="label">タイトル:</span><input type="text" name="title">
				</div>
				<div class="name">
					<span class="label">お名前:</span><input type="text" name="name">
				</div>
				<div class="image">
					<span class="label">添付画像:</span><input type="file" name="image"
						accept="image/*" onchange="previewImage(this);">
				</div>
				<!-- 添付画像のプレビューを表示 -->
				<canvas id="preview" style="max-width: 200px;"></canvas>
				<div class="honbun">
					<span class="label">本文:</span>
					<textarea name="text" id="text" cols="40" rows="6"></textarea>
				</div>
				<input type="submit" name="submit" value="質問する"
					onclick="return cancelsubmit()">
			</form>
			<br>
		</section>
		<section>
			<br>
			<hr>
			<br>
			<!-- 質問ルームへの書き込み内容を記入するフォームここまで -->
			<!-- データベースから今までの掲示板の内容を全件表示 -->
			<h2>投稿一覧</h2>
			<br>
			<div class="items">
				<br> <br>
				<c:forEach var="e" items="${questionList}">
					<div class="comments">
						<div class="comment">
							<ul class="combox">
								<li class="comno">Question<c:out value="${e.question_id}" /></li>
								<li class="title"><c:out value="${e.title}" /></li>
								<li class="comname"><c:out value="${e.name}" /></li>
								<!-- 高評価の内容を書き換える処理-->
								<li class="returncnt">
									<form method="post" action="/komike/Q_AServlet">
										<input type="hidden" name="question"
											value="<c:out value="${e.question_id}" />"> <input
											type="hidden" name="number"
											value="<c:out value="${e.good_number}" />">
										<button type="submit" name="submit" value="グッド">
											高評価:
											<c:out value="${e.good_number}" />
										</button>
									</form>
								</li>
								<li class="break"></li>
							</ul>
							<ul class="comcom">
								<li class="comtxt"><c:out value="${e.text}" /></li>
								<img src="${'/komike/images/'+=e.image_name}" max width="400"
									 alt="pic">
								<!-- 高評価フォームここまで-->
								<!-- 質問に対して、返答するフォーム-->
								<br>
								<br>
								<hr>
								<br>
								<form method="Post" action="/komike/Q_AServlet">
									<div class="name">
										<span class="label">お名前:</span><input type="text" name="name1">
									</div>
									<div class="honbun">
										<span class="label">本文:</span>
										<textarea name="text1" id="text1" cols="40" rows="6"></textarea>
									</div>
								</form>
								<li class="comreturn">
									<form>
										<input type="hidden" name="question_id"
											value="<c:out value="${e.question_id}" />"> <input
											type="submit" name="submit" value="回答する"
											onclick="return cancelsubmit1()">
									</form>
								</li>
							</ul>
							<!-- 返答フォームここまで-->
							<!--返答を表示するフォーム-->
							<c:forEach var="a" items="${e.answer}">
								<ul class="combox2">
									<li class="comno">Answer<c:out value="${a.answer_id}" /></li>
									<li class="comname"><c:out value="${a.name}" /></li>
									<c:forEach var="b" items="${a.test_result}">
										<li class="comname">ジャンル<c:out value="${b.genre}" /></li>
										<li class="comname">ランク<c:out value="${b.rank}" /></li>
									</c:forEach>
									<li class="break"></li>
								</ul>
								<ul class="comcom">
									<li class="comtxt"><c:out value="${a.text}" /></li>
								</ul>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 返答表示ここまで-->
	</div>
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
    itemElement : '> .comments' // アイテムの要素
});


</script>
</html>