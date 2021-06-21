package test;
import java.util.List;

import model.Test_question;

public class TestsresultTestDao {
	public static void main(String[] args) {
		TestsresultTestDao dao = new TestsresultTestDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Test_question> ResultList = dao.select(new Test_question(0, "", ""));
		for (Test_question card : ResultList) {
			
			
		}
	}
}