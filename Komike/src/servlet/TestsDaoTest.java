package servlet;


import java.util.List;

import dao.TestsDao;
import model.Test_choice_detail;
import model.Test_question;

public class TestsDaoTest {


	public static void main(String[] args) {
		TestsDao dao = new TestsDao();


		System.out.println("---------- select()のテスト ----------");
		List<Test_question> questionList = dao.select();
		for (Test_question test_question : questionList) {
			System.out.print(test_question.getQuestion_number() + " / ");
			System.out.print(test_question.getQuestion_sentence() + " / ");
			System.out.println();

			for (Test_choice_detail test_choice_detail : test_question.getTest_choice_detail()) {
				System.out.print(test_choice_detail.getChoice_number() + " / ");
				System.out.print(test_choice_detail.getTrue_false() + " / ");
				System.out.print(test_choice_detail.getChoice() + " / ");

				System.out.println();
			}
			System.out.println("--------------------");
		}
	}
}