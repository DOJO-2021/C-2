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
import javax.servlet.http.Part;

import dao.AddCommentDao;
import dao.FindCommentDao;
import model.Chat;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
@MultipartConfig(location = "C:\\pleiades\\workspace\\C-2\\Komike\\WebContent\\images")
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

		//データベースから全件取得 　〇
		List<Chat> infList = FindCommentDao.findcomment();

		//検索結果をリクエストスコープに格納　〇
		request.setAttribute("infList", infList);

		//掲示板にフォワード　〇
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
		rd.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*//セッションスコープからidの情報の取得
		HttpSession session= request.getSession();
		String id = (String) session.getAttribute("id");
		*/

		// リクエストパラメータを取得する　partで取得できるようにする

//		Part p = request.getPart("chat_id");
//		try(InputStream inputStream = p.getInputStream()) {
//			BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
//			//実際のデータを取ってくる
//			String val = (String)bufReader.lines().collect(Collectors.joining());
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}

		//AddCommentDaoのインスタンスを生成
		AddCommentDao cDao = new AddCommentDao();

		//パラメータを取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String text = request.getParameter("text");


		//削除機能の実装　〇
		//削除ボタンが押されたらchat_idをもとに削除する
		if(request.getParameter("submit").equals("削除")) {
			int chat_id = Integer.parseInt(request.getParameter("chat_id"));
			cDao.delete(chat_id);
		}
		//登録処理の実装
		//書き込みボタンを押されたら、登録処理を行う
		else if(request.getParameter("submit").equals("書き込む")) {
			//画像のファイル名のパラメータを取得
			Part part = request.getPart("image");//画像のパラメータを取得
			String image = this.getFileName(part);//画像のファイル名の取得
			//ファイルの書込み
			part.write(image);
			cDao.insert(new Chat(0, id, name, text, image,null));
		}

			//掲示板にリダイレクトする　〇
			response.sendRedirect("/komike/ChatServlet");
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
