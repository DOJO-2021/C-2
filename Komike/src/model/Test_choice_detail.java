package model;

public class Test_choice_detail {
	private int choice_number;
	private boolean true_false;
	private String choice;

	//コンストラクタの生成
		public Test_choice_detail(int choice_number, boolean true_false, String choice) {
			super();
			this.choice_number = choice_number;//選択番号
			this.true_false = true_false;//正誤フラグ
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

		public String getChoice() {
			return choice;
		}

		public void setChoice(String choice) {
			this.choice = choice;
		}
}
