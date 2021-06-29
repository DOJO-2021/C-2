package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Chat;
import model.Test_result;

public class AddCommentDao{

	//データベースに格納するメソッド
	public boolean insert(Chat ch) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する
			String sql = "insert into chat values (null, ?, ?, ?, ?, now(0))";
			PreparedStatement pStmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);


			// SQL文を完成させる
			if (ch.getId() != null) {
				pStmt.setString(1, ch.getId());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (ch.getName() != null ) {
				pStmt.setString(2, ch.getName());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (ch.getText() != null) {
				pStmt.setString(3, ch.getText());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (ch.getImage_name() != null) {
				pStmt.setString(4, ch.getImage_name());
			}
			else {
				pStmt.setString(4, "null");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				ch.setChat_id(rs.getInt(1));
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

	//データベースから削除するメソッド
	public boolean delete(int chat_id) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する
			String sql ="delete from chat where chat_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, chat_id);

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


//評価数の更新処理
	public boolean update(int number, int q) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する
			String sql = "update question set good_number =? where question_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, number);
			pStmt.setInt(2, q);



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

	public boolean update(Test_result tr) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する
			String sql = "update test_result set rank = ?, correct_answer = ?, correct_answer_rate = ? where id = ? and genre = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (tr.getRank() != null) {
				pStmt.setString(1, tr.getRank());
			}
			else {
				pStmt.setString(1, "null");
			}
			pStmt.setInt(2, tr.getCorrect_answer());

			pStmt.setDouble(3, tr.getCorrect_answer_rate());

			if (tr.getId() != null) {
				pStmt.setString(4, tr.getId());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (tr.getGenre() != null) {
				pStmt.setString(5, tr.getGenre());
			}
			else {
				pStmt.setString(5, "null");
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

	public boolean insert2(Test_result tr) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する
			String sql = "insert into test_result values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);


			// SQL文を完成させる
			if (tr.getId() != null) {
				pStmt.setString(1, tr.getId());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (tr.getGenre() != null ) {
				pStmt.setString(2, tr.getGenre());
			}
			else {
				pStmt.setString(2, "null");
			}
				pStmt.setDouble(3, tr.getCorrect_answer_rate());

			if (tr.getRank() != null) {
				pStmt.setString(4, tr.getRank());
			}
			else {
				pStmt.setString(4, "null");
			}
			pStmt.setInt(5, tr.getCorrect_answer());

			pStmt.setInt(6, tr.getNumber());

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














