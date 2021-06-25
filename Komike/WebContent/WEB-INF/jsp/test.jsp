<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト</title>
<link rel="stylesheet" href="/komike/css/test.css">
<script>
	'use strict';
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<script>
	//上に戻るボタン
	jQuery(document).ready(function() {
		var offset = 100;
		var duration = 500;
		jQuery(window).scroll(function() {
			if (jQuery(this).scrollTop() > offset) {
				jQuery('.pagetop').fadeIn(duration);
			} else {
				jQuery('.pagetop').fadeOut(duration);
			}
		});

		jQuery('.pagetop').click(function(event) {
			event.preventDefault();
			jQuery('html, body').animate({
				scrollTop : 0
			}, duration);
			return false;
		})
	});

	//ページ移行時に見せるアラート(起動できるかの判断をする)
	//window.alert('全部答えていません')

	//回答ボタンを押したときになるもの
	btnNo = 0;
	function check() {

		window.alert('全部答えていません')
		return false;

	}
	//radionamesを宣言
	let radioNames = [];
	//jstlをつかったforeachで、radioNamesにquestion_numberを格納
	<c:forEach var="a" items="${questions}">

	radioNames.push('${a.question_number}');
	</c:forEach>

	console.log('java01');
	console.log(radioNames);
	//ラジオボタンの回答数が20未満の場合画面を戻す

	//radioNamesの配列をforで回しながら、値が設定されているか確認

	//OK
	function check() {

		for (var i = 0; i < 20; i++) {

			var radioBtnElements = document.getElementsByName(radioNames[i]);
			console.log(radioBtnElements);
		}
	}

	function check() {
		if (btnNo === 1) {
			window.alert('全部答えていません')
		}
	}
</script>
</head>
<body class="body">
	<div class="wrapper">
		<div class="head">
			<div>
				<img src="/komike/images/Komike2.png" width="500" height="180"
					alt="写真">
			</div>
		</div>

		<br>
		<form method="POST" action="/komike/TestServlet"
			onClick="return check()">
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

				</ol>
			</div>
			<!-- パンくずリストここまで -->



			<input type="hidden" name="testType" value="${Select.genre}">
			<h2>理解度テスト</h2>
			<h3>問題ジャンル:${key}</h3>
			<h5>何も選択しない場合、４が選択されます。</h5>
			<br>
			<table class="test">
				<c:forEach var="e" items="${questions}">
					<tr>
						<td>
							<th colspan="2"><c:out value="${e.number}" />.
							</th>
							<th colspan="3"><c:out value="${e.question_sentence}" />
							</th>
						</td>
						<!--問題文-->
					</tr>
					<tr>
						<c:forEach var="d" items="${e.choice_detail}">
							<td colspan="4">
								<label><input type="radio" checked name="${e.question_number}" value="${d.choice_number}">
										<c:out value="${d.choice_number}" />.<c:out value="${d.choice}" />
								</label>
							</td>
					</tr>
						</c:forEach>

				</c:forEach>
			</table>
			<br>
			<input type="submit" name="JUDGE" value="回答終了" onClick="btnNo=1">

		</form>


		<div class="pagetop">↑</div>
		<!-- フッター（ここから） -->
		<div class="footer">
			<p>&copy;Copyright DOJO2021. All rights reserved.</p>
		</div>
		<!-- フッター（ここまで） -->
</body>
</html>