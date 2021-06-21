package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tselect
 */
@WebServlet("/Tselect")
public class Tselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Komike/LoginServlet");
			return;
		}

		TestresultDao TRDao=new TestresultDao();
		List<Test_result> resultds =TRDao.select();




		// 検索結果をリクエストスコープに格納する
		request.setAttribute("results", results);
		// TODO Auto-generated method stub
		//Tselect.javaがpostした内容のデータベースを取得する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/.jsp");
		dispatcher.forward(request, response);
*/
		// 理解度テスト選択画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Tselect.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;
				}*/
			/*リクエストパラメータを取得する
			String question_number = request.getParameter("QUESTION_NUMBER");
			String question_sentence = request.getParameter("QUESTION_SENTENCE");
			ArrayList<Test_question> questions = new ArrayList<Test_question>();

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("questions", questions);*/


			//テスト画面にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Test.jsp");
			dispatcher.forward(request, response);

	}

}
