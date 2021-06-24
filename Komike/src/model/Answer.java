package model;

import java.io.Serializable;
import java.util.ArrayList;

	public class Answer implements Serializable {
			private int question_id;
			private int answer_id;
			private String id;
			private String name;
			private String text;
			private ArrayList<Test_result> Test_result;

			public Answer(int question_id, int answer_id, String id, String name, String text,
					ArrayList<Test_result> test_result) {
				super();
				this.question_id = question_id;
				this.answer_id = answer_id;
				this.id = id;
				this.name = name;
				this.text = text;
				this.Test_result = test_result;
			}

			public Answer() {
				super();
				this.question_id = 0;
				this.answer_id = 0;
				this.id = "";
				this.name = "";
				this.text = "";
				this.Test_result = new ArrayList<Test_result>();
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

			public ArrayList<Test_result> getTest_result() {
				return Test_result;
			}

			public void setTest_result(ArrayList<Test_result> test_result) {
				Test_result = test_result;
			}


		}

