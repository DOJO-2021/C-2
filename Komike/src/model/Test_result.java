package model;

import java.io.Serializable;

public class Test_result implements Serializable {
	private int rank;
	private int correct_answer;
	private int number;
	private double correct_answer_rate;
	private String id;
	private String genre;


	//コンストラクタの生成
	public Test_result(int rank, int correct_answer, int number, double correct_answer_rate, String id, String genre) {
		super();
		this.rank = rank;
		this.correct_answer = correct_answer;
		this.number =  number;
		this.correct_answer_rate = correct_answer_rate;
		this.id = id;
		this.genre =  genre;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getCorrect_answer() {
		return correct_answer;
	}


	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public double getCorrect_answer_rate() {
		return correct_answer_rate;
	}


	public void setCorrect_answer_rate(double correct_answer_rate) {
		this.correct_answer_rate = correct_answer_rate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
}
