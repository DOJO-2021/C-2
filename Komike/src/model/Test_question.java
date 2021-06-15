package model;
import java.io.Serializable;
import java.util.ArrayList;


public class Test_question implements Serializable {
	private String question_number; //問題番号
	private String question_sentence;//問題文
	private ArrayList<Test_choice_detail> choice_detail;


	//private int choice_number; //選択番号
	//private String choice;//選択肢文


	//引数があるコンストラクタ
	public Test_question( String question_number, String question_sentence, ArrayList<Test_choice_detail> choice_detail) {
		super();

		this.question_number= question_number;
		this.question_sentence= question_sentence;
		this.choice_detail = choice_detail;

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


	public ArrayList<Test_choice_detail> getChoice_detail() {
		return choice_detail;
	}


	public void setChoice_detail(ArrayList<Test_choice_detail> choice_detail) {
		this.choice_detail = choice_detail;
	}




}

