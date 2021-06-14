package model;
import java.io.Serializable;

public class Regist_result implements Serializable{
	private String title;		// タイトル //privateにすることで他の人に変えられないようにする
	private String message;		// メッセージ
	private String backTo;		// 戻り先
	public Regist_result() {
		this(null, null, null);
	}

	public Regist_result(String title, String message, String backTo) {
		this.title = title;
		this.message = message;
		this.backTo = backTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}
}


