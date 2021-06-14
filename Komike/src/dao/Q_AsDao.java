package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				rs.getInt("good_number"),
			    null
				);
				QuestionList.add(comment);
			}
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

/*
		public boolean insert(Question data) {
			Connection conn = null;
			ArrayList<Question>  = new ArrayList<Question>();
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");

				// SQL文を準備する
				String sql = "insert into Question values (question_id,id,title,name,text,good_number,answer)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (data.getQuestion_id() != null) {
					pStmt.setInt(1, data.getQuestion_id());
				}
				else {
					pStmt.setInt(1, "null");
				}
				if (card.getDepartment() != null) {
					pStmt.setString(2, card.getDepartment());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (card.getName() != null) {
					pStmt.setString(3, card.getName());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (card.getZipcode() != null) {
					pStmt.setString(4, card.getZipcode());
				}
				else {
					pStmt.setString(4, "null");
				}
				if (card.getAddress() != null) {
					pStmt.setString(5, card.getAddress());
				}
				else {
					pStmt.setString(5, "null");
				}
				if (card.getPhone() != null) {
					pStmt.setString(6, card.getPhone());
				}
				else {
					pStmt.setString(6, "null");
				}
				if (card.getFax() != null) {
					pStmt.setString(7, card.getFax());
				}
				else {
					pStmt.setString(7, "null");
				}
				if (card.getEmail() != null) {
					pStmt.setString(8, card.getEmail());
				}
				else {
					pStmt.setString(8, "null");
				}
				if (card.getPhone() != null) {
					pStmt.setString(9, card.getPhone());
				}
				else {
					pStmt.setString(9, "null");
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


*/
		}
	}
