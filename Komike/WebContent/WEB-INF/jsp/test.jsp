<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト</title>
<script>
'use strict';
</script>
</head>
<body>
<h1>Komike</h1><h2>受講者向け掲示板サイト</h2>
<nav class="nav">
    <ul>
     <li>メニュー</li>
     <li>雑談ルーム</li>
     <li>Q&amp;Aルーム</li>
     <li>理解度テスト</li>
     <li>パスワード変更はこちら</li>
    </ul>
   </nav>

<h2>理解度テスト</h2>
<h2>問題ジャンル:HTML</h2>
<br>
<form method="POST" action="/komike/Test">
<table>

<tr>
<th>問題1</th>
<th>問題をいれてください</th>
<td>
<label><input type="radio" name="Question1" value="1">ここでは絶対に曲げてはいけない</label>
<label><input type="radio" name="Question1" value="2">選択肢2</label>
<label><input type="radio" name="Question1" value="3">選択肢3</label>
<label><input type="radio" name="Question1" value="4">選択肢4</label></td>

</tr>

<tr>
<th>問題2</th>
<th>問題を入れてください</th>
<td>
<label><input type="radio" name="Question2" value="1">選択肢1</label>
<label><input type="radio" name="Question2" value="2">選択肢2</label>
<label><input type="radio" name="Question2" value="3">選択肢3</label>
<label><input type="radio" name="Question2" value="4">選択肢4</label></td>
</tr>

<tr>
<th>問題3</th>
<th>問題を入れてください</th>
<td>
<label><input type="radio" name="Question3" value="1">選択肢1</label>
<label><input type="radio" name="Question3" value="2">選択肢2</label>
<label><input type="radio" name="Question3" value="3">選択肢3</label>
<label><input type="radio" name="Question3" value="4">選択肢4</label></td>
</tr>

<tr>
<th>問題4</th>
<th>問題を入れてください</th>
<td>
<label><input type="radio" name="Question4" value="1">選択肢1</label>
<label><input type="radio" name="Question4" value="2">選択肢2</label>
<label><input type="radio" name="Question4" value="3">選択肢3</label>
<label><input type="radio" name="Question4" value="4">選択肢4</label></td>
</tr>

<tr>
<th>問題5</th>
<th>問題を入れてください</th>
<td>
<label><input type="radio" name="Question5" value="1">選択肢1</label>
<label><input type="radio" name="Question5" value="2">選択肢2</label>
<label><input type="radio" name="Question5" value="3">選択肢3</label>
<label><input type="radio" name="Question5" value="4">選択肢4</label></td>
</tr>

</table>


<input type="submit" name="JUDGE" value="回答終了">
</form>
</body>
</html>