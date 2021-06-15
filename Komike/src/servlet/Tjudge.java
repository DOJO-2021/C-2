package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Tjudge
 */
@WebServlet("/Tjudge")
public class Tjudge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}*/
		//Test.javaで送られてきたテスト結果をこの中に取得する
		// テスト結果画面にフォワードする

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Tjudge.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String ganre = request.getParameter("ganre");
				String correct_answer_rate = request.getParameter("correct_answer_rate");
				String rank = request.getParameter("rank");
				String correct_answer = request.getParameter("correct_answer");



				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
				dispatcher.forward(request, response);


		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
