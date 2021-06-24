package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestsDao;
import dao.TestsresultDao;
import model.Select;
import model.Test_question;
import model.Test_result;

/**
 * Servlet implementation class Test
 */
@WebServlet("/TestServlet")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータを取得する
		String key = request.getParameter("key");
		TestsDao TDao = new TestsDao();

		List<Test_question> questions = TDao.select(key);

		//Tselect.jspのジャンル名がTest.jspの問題番号に使う
		request.setAttribute("Select",
				new Select(key));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("questions", questions);
		request.setAttribute("key", key);
		// TODO Auto-generated method stub
		//Tselect.javaがpostした内容のデータベースを取得する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession();
		Login_user user = (Login_user)session.getAttribute("id");
		String id = user.getId();*/

		// リクエストパラメータを取得する
		//■requestスコープからジャンルとIDを取得
		request.setCharacterEncoding("UTF-8");
		//String question_number = request.getParameter("question_number");
		//String choice_number = request.getParameter("choice_number");
		//boolean true_false = request.getParameter("GENRE");

		//javaやHTMLなど、なんの問題かを取得
		//String testType = "java" 固定するためのもの
		String testType = request.getParameter("testType");

		//正解数を保持する変数
		int score = 0;
		//ループ２０回

		//変数の値は1文字扱いなのか
		// 1  →　01       0 + 1→ 01→01
		// 2  →　02

		// 20 →　20       0 + 20→ 020→20
		//画面上で0をつける
		for (int a = 1; a <= 20; a++) {
			//aを0を付けたString型のnumに変換
			String num = "0" + a;


			TestsresultDao resultDao = new TestsresultDao();

			//正解か間違いかを判断

			//System.out.println(num);
			//aが9までは0を抜き出さずそのまま出す(ifの処理は同じ)
			if(a<=9) {
				//対応する問題番号の選択した値を取得(1、2、3、4のみ)
				//この時点で例外発生
				int answer = Integer.parseInt(request.getParameter(testType + num));

				if (resultDao.select(testType + num, answer)) {
					//正解
					score++;
					System.out.println("正解!");

				} else {
					//不正解
					System.out.println("不正解・・・");

				}


			}
			//aが10は0を抜き出して出す(ifの処理は同じ)
			else if(a>9) {
				String b = num.substring(1);
				//対応する問題番号の選択した値を取得(1、2、3、4のみ)
				int answer = Integer.parseInt(request.getParameter(testType + b));

				if (resultDao.select(testType + b, answer)) {
					//正解
					score++;
					System.out.println("正解!");

				} else {
					//不正解
					System.out.println("不正解・・・");

				}


			}

		}

			//System.out.println(a.substring(0));
		//正解率を求める
		double rate ;

		//int型のscoreをdouble型のrateに入れる(rateの値を一度あるものにする)
		rate = score;

		//代入した数を問題数20で割り百分率
		rate = ((rate / 20) * 100);

				//ランクを決める
		String rank;

		rank = "ビギナー";

		if(score>10 && score<14) {
			rank = "ブロンズ";

		}

		if(score>14 && score<17) {
			rank = "シルバー";

		}

		if(score>17 && score<20) {
			rank = "ゴールド";

		}

		if(score==20) {
			rank = "プラチナ";

		}

		int i = 1;

			request.setAttribute("Test_result",
					new Test_result(rank, score, i++, rate, "reborn", testType));

			/*//ランク、正解率、正解数をupdateする処理
			if(request.getParameter("submit").equals("回答終了")) {
				AddCommentDao acdao = new AddCommentDao();
				acdao.update(new Test_result(rank, score, i++, rate, id, testType));
			}*/

		//正解数が取得できる

		System.out.println(score);
		if (false) {
			//エラーメッセージの出力
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Tjudge.jsp");
		dispatcher.forward(request, response);
	}

}