package model;

import java.io.Serializable;

public class Test_choice implements Serializable {
	private int choice_number;
	private boolean true_false;
	private String question_number;
	private String choice;


	//コンストラクタの生成
	public Test_choice(int choice_number, boolean true_false, String question_number, String choice) {
		super();
		this.choice_number = choice_number;
		this.true_false = true_false;
		this.question_number = question_number;
		this. choice =   choice;
	}


	public int getChoice_number() {
		return choice_number;
	}


	public void setChoice_number(int choice_number) {
		this.choice_number = choice_number;
	}


	public boolean isTrue_false() {
		return true_false;
	}


	public void setTrue_false(boolean true_false) {
		this.true_false = true_false;
	}


	public String getQuestion_number() {
		return question_number;
	}


	public void setQuestion_number(String question_number) {
		this.question_number = question_number;
	}


	public String getChoice() {
		return choice;
	}


	public void setChoice(String choice) {
		this.choice = choice;
	}
}

