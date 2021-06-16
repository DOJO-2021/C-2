package model;
import java.io.Serializable;

public class  User implements Serializable{ //インターフェース
		private String id;
		private String password;
		//引数のあるコンストラクタ
		public User(String id, String password) {
			super();
			this.id = id;
			this.password = password;
		}
		//引数のないコンストラクタ
		public User() {
			super();
			this.id = "";
			this.password= "";
		}

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

}
