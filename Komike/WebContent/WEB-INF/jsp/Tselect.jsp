<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>理解度テスト|選択画面</title>
</head>
<body>
<!-- ヘッダー（ここから） -->
<h1>Komike</h1>
<h3>受講者向け掲示板サイト</h3>
<h3>ログアウトはこちら</h3>
<form method="POST" action="/komike/Tselect">
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

	<table>
		<tr>
			<td><li><a href="/komike/TestServlet?key=html">HTML</a></li><br><c:out value="${result.rank}" /><br>
			</td>
			<td><li><a href="/komike/TestServlet?key=css">CSS</a></li><br>CSSのテスト履歴<br>
			</td>
			<td><li><a href="/komike/TestServlet?key=JavaScript">JavaScript</a></li><br>JavaScriptのテスト履歴<br>
			</td>
		</tr>
		<tr>
			<td><li><a href="/komike/TestServlet?key=Java">Java</a></li><br>Javaのテスト履歴<br>
			</td>
			<td><li><a href="/komike/TestServlet?key=data">データベース</a></li><br>データベースのテスト履歴<br>
			</td>
			<td><li><a href="/komike/TestServlet?key=surver">サーバーサイドJava</a></li><br>サーバーサイドJavaのテスト履歴<br>
			</td>
		</tr>
	</table>
 </form>
</body>
</html>