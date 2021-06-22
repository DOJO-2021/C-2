package model;

import java.io.Serializable;

public class Select implements Serializable {
	private String genre;

	//
	//引数があるコンストラクタの生成
	public Select(String genre) {
		super();
		this.genre = genre;

	}

	//引数がないコンストラクタ
	public Select() {
		super();

		this.genre = "";
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
