package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.AddCommentDao;
import dao.FindCommentDao;
import dao.Q_AsDao;
import model.Answer;
import model.Login_user;
import model.Question;

/**
 * Servlet implementation class Q_A
 */
@WebServlet("/Q_AServlet")
@MultipartConfig(location = "C:\\pleiades\\workspace\\C-2\\Komike\\WebContent\\images")
public class Q_A extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープからidの情報の取得
//		HttpSession session = request.getSession();
//		Login_user user = (Login_user)session.getAttribute("id");
//		String id = user.getId();

		//質問の一覧を取得する
		//DAOを使う→Q_AsDaoのインスタンス化
		Q_AsDao dao = new Q_AsDao();
		List<Question> questionList = dao.select();

		//ランクを取得
		//List <Test_result> question = FindCommentDao.rank(new Test_result(0, 0, 0, 0, , ""));

		//質問の一覧をjspに渡す
		request.setAttribute("questionList", questionList);

		//request.setAttribute("questionList", question);

		// 質問ルームにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q_a.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DAOを使う→Q_AsDaoのインスタンス化
		Q_AsDao dao = new Q_AsDao();

		//リクエストパラメータを取得する。
		request.setCharacterEncoding("UTF-8");
		//セッションスコープからidの情報の取得
		HttpSession session = request.getSession();
		Login_user user = (Login_user)session.getAttribute("id");
		String id = user.getId();




		// 登録処理を行う
		if (request.getParameter("submit").equals("書き込む")) {
			String title = request.getParameter("title");
			String name = request.getParameter("name");
			String text = request.getParameter("text");

			//画像のファイル名のパラメータを取得
			Part part = request.getPart("image");//画像のパラメータを取得
			String image = this.getFileName(part);//画像のファイル名の取得
			//ファイルの書込み
			if (!image.equals("")) {
				part.write(image);
			}
			dao.insert(new Question(0, id, title, name, text, image, 0, null));

		}
			//answerのinsertの命令文を書く
	    	//リクエストパラメータを取得する。
			//request.setCharacterEncoding("UTF-8");



			//登録処理を行う
			if (request.getParameter("submit").equals("回答する")) {
				String name1 = request.getParameter("name1");
				String text1 = request.getParameter("text1");
				int ans =  Integer.parseInt(request.getParameter("question_id"));
				//ファイルの書込み
				dao.a_insert(new Answer(ans, 0, id, name1, text1));
			}


			//高評価の処理
			if(request.getParameter("submit").equals("グッド")) {
				AddCommentDao acdao = new AddCommentDao();
				int q = Integer.parseInt(request.getParameter("question"));
				int number =Integer.parseInt(request.getParameter("number"));
				int i = number + 1;
				acdao.update(i, q);
			}


			//検索を行う処理
			if(request.getParameter("submit").equals("検索する")) {
				String key = request.getParameter("key");
				List<Question> question = FindCommentDao.search(key);
				request.setAttribute("question", question);
				//search_result.jspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
				dispatcher.forward(request, response);
			}
			//質問ルームにリダイレクトする　〇
			response.sendRedirect("/komike/Q_AServlet");



	}

	//画像のファイル名を取得するメソッド
	private String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}

}
