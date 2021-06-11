package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestsDao;
import model.Test_question;
/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// リクエストパラメータを取得する
					request.setCharacterEncoding("UTF-8");
					/*String select1 = request.getParameter("Question1");
					String select2 = request.getParameter("Question2");
					String select3 = request.getParameter("Question3");
					String select4 = request.getParameter("Question4");
					String select5 = request.getParameter("Question5");*/

                    int choice_number =  Integer.parseInt(request.getParameter("CHOICE_NUMBER"));
					String question_number = request.getParameter("QUESTION_NUMBER");
					String question_sentence = request.getParameter("QUESTION_SENTENCE");
					String choice = request.getParameter("CHOICE");


					// 採点処理を行う
					TestsDao bDao = new TestsDao();

					// 採点結果をリクエストスコープに格納する
					request.setAttribute("Test_question",
							new Test_question (11, "IDまたはPWに間違いがあります。", "IDまたはPWに間違いがあります。", "IDまたはPWに間違いがあります。"));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Tjudge.jsp");
					dispatcher.forward(request, response);
	}



}