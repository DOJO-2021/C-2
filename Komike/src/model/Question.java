package model;

import java.io.Serializable;
import java.util.ArrayList;

//ArrayList<Answer> ans;
public class Question implements Serializable {
	private int question_id;
	private String id;
	private String title;
	private String name;
	private String text;
	private int good_number;
	private ArrayList<Answer> Answer;

	//コンストラクタの生成
			public Question(int question_id, String id, String title, String name, String text, int good_number, ArrayList<Answer> answer) {
				super();
				this.question_id =question_id;
				this.id = id;
				this.title = title;
				this.name = name;
				this.text = text;
				this.good_number =good_number;
				this.Answer = answer;
            }
			//引数がないコンストラクタ
			public Question() {
					super();
					this.question_id =0;
					this.id = "";
					this.title = "";
					this.name = "";
					this.text = "";
					this.good_number =0;
					this.Answer = new ArrayList<Answer>();
			}
			public int getQuestion_id() {
				return question_id;
			}
			public void setQuestion_id(int question_id) {
				this.question_id = question_id;
			}
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
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
			public int getGood_number() {
				return good_number;
			}
			public void setGood_number(int good_number) {
				this.good_number = good_number;
			}
			public ArrayList<Answer> getAnswer() {
				return Answer;
			}
			public void setAnswer(ArrayList<Answer> answer) {
				Answer = answer;
			}

}