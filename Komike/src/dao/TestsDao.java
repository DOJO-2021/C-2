package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Test_question;

public class TestsDao {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<Test_question> select() {
				Connection conn = null;
				List<Test_question> questionList = new ArrayList<Test_question>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");

					// SQL文を準備する
					String sql = "select * from question";
					PreparedStatement pStmt = conn.prepareStatement(sql);


					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// SQL文を完成させる
					while(rs.next()) {
						Test_question comment = new Test_question(
						rs.getString("question_number"),
						rs.getString("question_sentence"),
						rs.getString("choice"),
						rs.getInt("choice_number"),//選択番号
						rs.getBoolean("true_false")//正誤フラグ


						);
						questionList.add(comment);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					questionList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					questionList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							questionList = null;
						}
					}
				}

				// 結果を返す
				return questionList;
			}

}
