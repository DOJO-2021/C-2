<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Komike(仮)</title>
</head>
<body>
  <h1>Komike(仮)</h1>
  <h2>受講者向け掲示板サイト</h2>
    <p><label>キーワード検索：<input type="search" name="search" size="30" maxlength="255"></label></p>
  <ul>
    <li><a href="menu.jsp">メニュー</a></li>
    <li><a href="cahat.jsp">雑談ルーム</a></li>
    <li><a href="q_a.jsp">Q&amp;Aルーム</a></li>
    <li><a href="regist"></a>理解度テスト</li>
    <li><a href="pwchange">パスワード変更はこちら</a></li>
  </ul>
  <h3>分からないことを質問してみましょう</h3>
    <p>質問は以下の欄に入力してください</p>

<form>
  <dl>
    <dt>
      <span>任意</span>
      名前
      <span>name</span>
      </dt>

      <dd>
        <input type="text" class="名前" name="name" value="">
      </dd>
      <dt>
      <span>任意</span>
      添付画像
      <span>Attachment</span>
      添付画像<input type="file" name="avatar"><br>
本文<textarea name = "text"></textarea>
<input type = "submit" name = "submit" value = "書き込む">
      </dt>

  </dl>
</form>
<br>
<c:forEach var="e" items="${questionList}" >
    <p>Question_ID<c:out value ="${e.question_id}"/></p><br>
       ID<c:out value ="${e.id}"/><br>
    <b>タイトル</b><c:out value ="${e.title}"/><br>
    <b>名前</b><c:out value ="${e.name}"/><br>
    <b>本文</b><c:out value ="${e.text}"/><br>
    <b>評価数</b><c:out value ="${e.good_number}"/>
<form method="post" action="/komike/Q_A.java">
  </form>
</c:forEach>

</body>
</html>