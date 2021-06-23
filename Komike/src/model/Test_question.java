package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Test_question implements Serializable {
	private String question_number; //問題番号
	private int number;//問題の数
	private String question_sentence;//問題文
	private ArrayList<Test_choice_detail> choice_detail;//問題文の子を持ってくる

	//private int choice_number; //選択番号
	//private String choice;//選択肢文

	//引数があるコンストラクタ
	public Test_question(String question_number, int number, String question_sentence, ArrayList<Test_choice_detail> choice_detail) {
		super();
		this.question_number = question_number;
		this.number = number;
		this.question_sentence = question_sentence;
		this.choice_detail = choice_detail;

	}

	//引数がないコンストラクタ
	public Test_question() {
		super();
		this.question_number = "";
		this.number = 1;
		this.question_sentence = "";
		this.choice_detail = new ArrayList<Test_choice_detail>();

	}

	public String getQuestion_number() {
		return question_number;
	}

	public void setQuestion_number(String question_number) {
		this.question_number = question_number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumbers(int number) {
		this.number = number;
	}

	public String getQuestion_sentence() {
		return question_sentence;
	}

	public void setQuestion_sentence(String question_sentence) {
		this.question_sentence = question_sentence;
	}

	public ArrayList<Test_choice_detail> getChoice_detail() {
		return choice_detail;
	}

	public void setChoice_detail(ArrayList<Test_choice_detail> choice_detail) {
		this.choice_detail = choice_detail;
	}

}
