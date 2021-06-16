package model;

import java.io.Serializable;

public class Test_result implements Serializable {
	private int rank;						//ランク
	private int correct_answer;			//正解数
	private int number;					//受けた回数
	private double correct_answer_rate;	//正解率
	private String id;						//ユーザーid
	private String genre;					//ジャンル


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

	//引数がないコンストラクタ
		public Test_result() {
			super();
			this.rank = 0;
			this.correct_answer = 0;
			this.number =  0;
			this.correct_answer_rate = 0;
			this.id = "";
			this.genre = "";
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
