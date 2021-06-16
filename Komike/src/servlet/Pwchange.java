package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.Regist_result;
import model.User;

/**
 * Servlet implementation class Pwchange
 */
@WebServlet("/Pwchange")
public class Pwchange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パスワード変更ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pwchange.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		} */

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// パスワード変更処理を行う
		UsersDao uDao = new UsersDao();
		if (uDao.update(new User(id,password))) {	// 登録成功

		/*	// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new Login_user(id));
	*/
			request.setAttribute("Regist_result",
			new Regist_result("登録成功！", "新規登録完了しました。", "/komike/Login"));
		}
		else {												// 登録失敗
			request.setAttribute("Regist_result",
			new Regist_result("登録失敗！", "もう一度やり直してください。", "/komike/Login"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_result.jsp");
		dispatcher.forward(request, response);
	}
}
