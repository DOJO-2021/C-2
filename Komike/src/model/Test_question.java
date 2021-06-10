package model;
import java.io.Serializable;


public class Test_question implements Serializable {
	private int question_number; //問題番号
	private String question_sentence;//問題文

	//引数があるコンストラクタ
	public Test_question(int question_number, String question_sentence) {
		super();
		this.question_number= question_number;
		this.question_sentence= question_sentence;


	}

	public int getQuestion_number() {
		return question_number;
	}

	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
	}

	public String getQuestion_sentence() {
		return question_sentence;
	}

	public void setQuestion_sentence(String question_sentence) {
		this.question_sentence = question_sentence;
	}

}

