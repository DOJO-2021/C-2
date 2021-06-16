package model;

import java.io.Serializable;

	public class Answer implements Serializable {
		private int question_id;
		private int answer_id;
		private String id;
		private String name;
		private String text;

		//引数があるコンストラクタの生成
		public Answer(int question_id, int answer_id, String id, String name, String text ) {
			super();
			this.question_id = question_id;
			this.answer_id = answer_id;
			this.id = id;
			this.name = name;
			this.text = text;
		}

		//引数がないコンストラクタ
		public Answer() {
			super();
			this.question_id =0;
			this.answer_id = 0;
			this.id = "";
			this.name = "";
			this.text = "";
		}

		public int getQuestion_id() {
			return question_id;
		}

		public void setQuestion_id(int question_id) {
			this.question_id = question_id;
		}

		public int getAnswer_id() {
			return answer_id;
		}

		public void setAnswer_id(int answer_id) {
			this.answer_id = answer_id;
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

		}