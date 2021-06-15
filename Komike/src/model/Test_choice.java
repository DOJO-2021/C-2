package model;
//削除予定

import java.io.Serializable;
import java.util.ArrayList;

public class Test_choice implements Serializable {
	private String question_number;
	private ArrayList<Test_choice_detail> choice_detail;

	//コンストラクタの生成
	public Test_choice(String question_number, ArrayList<Test_choice_detail> choice_detail) {
		super();
		this.question_number = question_number;
		this.choice_detail = choice_detail;
	}


	public String getQuestion_number() {
		return question_number;
	}


	public void setQuestion_number(String question_number) {
		this.question_number = question_number;
	}


	public ArrayList<Test_choice_detail> getChoice_detail() {
		return choice_detail;
	}


	public void setChoice_detail(ArrayList<Test_choice_detail> choice_detail) {
		this.choice_detail = choice_detail;
	}
}
