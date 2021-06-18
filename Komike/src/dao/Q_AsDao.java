package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Question;


public class Q_AsDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す

	public List<Question> select() {
		Connection conn = null;
		List<Question> QuestionList = new ArrayList<Question>();


		try {
	       //JDBCドライバを読み込む
	       Class.forName("org.h2.Driver");

	       // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

	      // SQL文を準備する
	       String sql = "select * from Question";
	       PreparedStatement pStmt = conn.prepareStatement(sql);

	       // SQL文を準備するAnswerテーブル
	       String sql_2 = "select * from Answer where question_id = ?";
	       PreparedStatement pStmt1 = conn.prepareStatement(sql_2);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// SQL文を完成させる
			while(rs.next()) {
				Question comment = new Question(
						rs.getInt("question_id"),
						rs.getString("id"),
						rs.getString("title"),
						rs.getString("name"),
						rs.getString("text"),
						rs.getString("image_name"),
						rs.getInt("good_number"),
						null
						);

				pStmt1.setInt(1, comment.getQuestion_id());
				ResultSet rsr = pStmt1.executeQuery();

					while(rsr.next()) {
						Answer ans = new Answer();
						  ans.setQuestion_id(rsr.getInt("question_id"));
						  ans.setAnswer_id(rsr.getInt("answer_id"));
						  ans.setId(rsr.getString("id"));
						  ans.setName(rsr.getString("name"));
						  ans.setText(rsr.getString("text"));

						  comment.getAnswer().add(ans);
					}


				QuestionList.add(comment);
			}
			rs.close();


		}
		catch (SQLException e) {
			e.printStackTrace();
			QuestionList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			QuestionList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					QuestionList = null;
				}
			}
		}
		// 結果を返す
		return QuestionList;

	}


		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Question question) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

				// SQL文を準備する
				String sql = "insert into Question values (null,?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				//question.getQuestion_id();
				//String null OK
				//Int    null NG  0はOK
				//Question null OK


				if (question.getId() != null) {
					pStmt.setString(1, question.getId());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (question.getTitle() != null) {
					pStmt.setString(2, question.getTitle());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (question.getName() != null) {
					pStmt.setString(3, question.getName());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (question.getText() != null) {
					pStmt.setString(4,question.getText());
				}
				else {
					pStmt.setString(4, "null");
				}
				if (question.getImage_name() != null) {
					pStmt.setString(5, question.getImage_name());
				}
				else {
					pStmt.setString(5, "null");
				}
				if (question.getGood_number() != 0) {
					pStmt.setInt(6, question.getGood_number());
				}
				else {
					pStmt.setInt(6, 0);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			// 結果を返す
			return result;
		}


		}




