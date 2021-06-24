package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Chat implements Serializable {
	private int chat_id;
	private String id;
	private String name;
	private String text;
	private String image_name;
	private Timestamp time  ;


//コンストラクタの生成
	public Chat(int chat_id, String id, String name, String text, String image_name, Timestamp time) {
		super();
		this.chat_id = chat_id;
		this.id = id;
		this.name = name;
		this.text = text;
		this.image_name = image_name;
		this.time = time;
	}

	public Chat() {
		super();
	}

	//getter setterの作成
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

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


}
