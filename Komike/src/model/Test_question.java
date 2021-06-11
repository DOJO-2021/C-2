package model;
import java.io.Serializable;


public class Test_question implements Serializable {

	private int choice_number; //選択番号
	private String question_number; //問題番号
	private String question_sentence;//問題文
	private String choice;//選択肢文


	//引数があるコンストラクタ
	public Test_question(int choice_number, String question_number, String question_sentence, String choice) {
		super();
		this.choice_number= choice_number;
		this.question_number= question_number;
		this.question_sentence= question_sentence;
		this.choice= choice;

	}


	public Test_question() {
		super();
		this.choice_number= 0;
		this.question_number= "";
		this.question_sentence= "";
		this.choice= "";

	}

	public int getChoice_number() {
		return choice_number;
	}

	public void setChoice_number(int choice_number) {
		this.choice_number = choice_number;
	}

	public String getQuestion_number() {
		return question_number;
	}

	public void setQuestion_number(String question_number) {
		this.question_number = question_number;
	}

	public String getQuestion_sentence() {
		return question_sentence;
	}

	public void setQuestion_sentence(String question_sentence) {
		this.question_sentence = question_sentence;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}



}

