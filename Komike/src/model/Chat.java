package model;

import java.io.Serializable;
import java.sql.Date;

public class Chat implements Serializable {
	private int chat_id;
	private String id;
	private String name;
	private String text;
	private Date time  ;

	//コンストラクタの生成
	public Chat(int chat_id, String id, String name, String text, Date time) {
			super();
			this.chat_id = chat_id;
			this.id = id;
			this.name = name;
			this.text = text;
			this.time = time;
		}
	public Chat() {
		super();
	}

	public int getChat_id() {
		return chat_id;
	}


	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}

}

