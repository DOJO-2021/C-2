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
		//List<Test_question> questions =TDao.select();
		List<Test_question> questions = TDao.select(key);

		//Tselect.jspのジャンル名がTest.jspの問題番号に使う
		request.setAttribute("Select",
				new Select(key));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("questions", questions);
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

		// 1  →　01       0 + 1→ 01→01
		// 2  →　02

		// 20 →　20       0 + 20→ 020→20
		/*for (int a = 1; a <= 20; a++) {

			System.out.println("0" + a);
			String b = a.substring(0);
			System.out.println(b);*/


			//対応する問題番号の選択した値を取得(1、2、3、4のみ)
			int answer = Integer.parseInt(request.getParameter(testType + "1"));
			//正解か間違いかを判断
			TestsresultDao resultDao = new TestsresultDao();
			//正解していたら＋１
			if (resultDao.select(testType + "1", answer)) {
				//正解
				score++;
				System.out.println("正解!");

			} else {
				//不正解
				System.out.println("不正解・・・");

			}

			/*request.setAttribute("Test_result",
					new Test_result(1, 15, 2, 49, "reborn", "CSS"));*/

		//}
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