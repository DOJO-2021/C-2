<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>雑談ルーム</title>
</head>
<body>
<h1>Komike</h1>
<h2>受講者向け掲示板サイト</h2>
<nav class="nav">
	<ul>
		 <li>メニュー⌂</li>
		 <li>雑談ルーム</li>
		 <li>Q&amp;Aルーム</li>
		 <li>理解度テスト</li>
		 <li>パスワード変更はこちら</li>
		 <li>ログアウトはこちら</li>
	</ul>
</nav>
<p>雑談ルームへようこそ</p>
<form method = "post">
名前<input type = "text" name = "name">
添付画像<input type="file" name="avatar">
本文<textarea name = "text"></textarea>
<input type = "submit" name = "submit" value = "書き込む">
</form>
</body>
</html>