package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddCommentDao;
import dao.FindCommentDao;
import model.Chat;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	 */

	public ChatServlet() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//データベースから全件取得
		List<Chat> infList = FindCommentDao.findcomment();

		//検索結果をリクエストスコープに格納
		request.setAttribute("infList", infList);

		//掲示板にフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
		rd.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*//idの情報の取得
		HttpSession session= request.getSession();
		String id = (String) session.getAttribute("id");
		*/

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String text = request.getParameter("text");


		// 登録処理を行う
			AddCommentDao cDao = new AddCommentDao();
			cDao.insert(new Chat(0, id, name, text, null));

			//掲示板にフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
			rd.forward(request, response);

	}

}
