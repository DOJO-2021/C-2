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
import model.Test_question;
//import dao.TestsDao;
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

		TestsDao TDao=new TestsDao();
		List<Test_question> questions =TDao.select();



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
		String id = request.getParameter("ID");
		String genre = request.getParameter("GENRE");

		// 選ばれたラジオボタンの情報を取得
		//String s = request.getParameter("radiobutton");
		String[] q1 = request.getParameterValues("Question1");
		String[] q2 = request.getParameterValues("Question2");
		String[] q3 = request.getParameterValues("Question3");
		String[] q4 = request.getParameterValues("Question4");
		String[] q5 = request.getParameterValues("Question5");
		String[] q6 = request.getParameterValues("Question6");
		String[] q7 = request.getParameterValues("Question7");
		String[] q8 = request.getParameterValues("Question8");
		String[] q9 = request.getParameterValues("Question9");
		String[] q10 = request.getParameterValues("Question10");
		String[] q11 = request.getParameterValues("Question11");
		String[] q12 = request.getParameterValues("Question12");

		request.setAttribute("Test_result",
				new Test_result(1, 15,  2,49, "reborn","CSS"));

		//それぞれのラジオボタンから抜き出した選択肢を正誤フラグと比べる
		//そこからあっていた数だけ正解数correct_answerに代入する


		//(正解数/20)×100のパーセンテージにして正解数correct_answer_rateに代入する

		//正解数に応じてランクの数字を決める

		// 採点結果をリクエストスコープに格納する
		//request.setAttribute("Test_question",
		//new Test_choice ("Java", 11));

		//ArrayList<Test_question> questions = new ArrayList<Test_question>();

		if(false) {
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