
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	//ページ移行時に見せるアラート
	window.alert('全部答えていません')
	var radioBtnElements = document.getElementsByName('name');

	//回答ボタンを押したときになるもの
	//btnNo = 0;
	//function check(){
	// if(btnNo == 1){
	//	      window.alert('全部答えていません')
	//	      return false;
	// //}

	let radioNames = [];
	radioNames.push('java01');
	radioNames.push('java02');

	console.log('java01');
	console.log(radioNames);
	//ラジオボタンの回答数が20未満の場合画面を戻す
	var radioBtnElements = document.getElementsByName('java01');
	var radioBtnElements = document.getElementsByName('${e.question_number}');
	for (var i = 0, len = radioBtnElements.length; i < len; i++) {
		if (radioBtnElements[i].checked) {
			console.log(radioBtnElements[i].value);
			//	    	window.alert('全部答えていません')
			//return false;
		}
	}

	//btnNo = 0;
	//function check(){
	//if(btnNo == 1){
	//		 if(document.SelfReport.querySelectorAll(':checked').length < 20){
	//    window.alert('全部答えていません')
	// }
	//}
	//}
</script>
</head>
<body class="body">
	<div class="head">
		<div>
			<img src="/komike/images/Komike2.png" width="500" height="180"
				alt="写真">
		</div>
	</div>

	<br>
	<form method="POST" action="/komike/TestServlet">
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


		<form method="POST" action="/komike/TestServlet">
			<input type="hidden" name="testType" value="${Select.genre}">
			<h2>理解度テスト</h2>
			<h3>問題ジャンル:${key}</h3>
			<table class=select>
				<c:forEach var="e" items="${questions}">
					<tr>

						<th>問題<c:out value="${e.number}" /></th>

						<th><c:out value="${e.question_sentence}" /></th>
						<!--問題文-->
					</tr>
					<tr>
						<c:forEach var="d" items="${e.choice_detail}">
							<td><label><input type="radio"
									name="${e.question_number}" value="${d.choice_number}">
									<c:out value="${d.choice}" /></label></td>
						</c:forEach>
					</tr>
				</c:forEach>

				<tr>
					<td><input type="submit" name="JUDGE" value="回答終了"></td>
				</tr>
			</table>


		</form>


		<div class="pagetop">↑</div>
</body>
</html>