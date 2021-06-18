package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.Login_user;
import model.Regist_result;
import model.User;

/**
 * Servlet implementation class Pwchange
 */
@WebServlet("/PwchangeServlet")
public class Pwchange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/komike/Login");
			return;
		}

		// パスワード変更ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pwchange.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/komike/Login");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String id = request.getParameter("id");

		//ユーザーIDを取得
		Login_user user = (Login_user) session.getAttribute("id");
		String id = user.getId();


		String password = request.getParameter("password");         //旧パスワード
		String password2 = request.getParameter("password2");    //新パスワード


		//古いパスワードと入力されたものが一致しているかどうか
		UsersDao uDao = new UsersDao();
		if (uDao.isLoginOK(id, password)) {	// 一致してた
			// メニューサーブレットにリダイレクトする
			request.setAttribute("Regist_result",
					new Regist_result("登録成功！", "変更完了しました。", "/komike/Login"));
		}
		else {// 一致してない
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("Regist_result", //Regist_result.java	の３つのString型をもってくる
			new Regist_result("ログイン失敗！", "パスワードに間違いがあります。", "/komike/PwchangeServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_result.jsp");
			dispatcher.forward(request, response);
		}

		// パスワード変更処理を行う
		UsersDao usDao = new UsersDao();
		if (usDao.update(new User(id, password2))) { // 登録成功
			request.setAttribute("Regist_result",
					new Regist_result("登録成功！", "変更完了しました。", "/komike/Login"));
		} else { // 登録失敗
			request.setAttribute("Regist_result",
					new Regist_result("登録失敗！", "もう一度やり直してください。", "/komike/Login"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist_result.jsp");
		dispatcher.forward(request, response);
	}
}

