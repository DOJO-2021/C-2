package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Chat;

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
			String sql = "insert into chat values (null, ?, ?, ?, ?, current_timestamp)";
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
}














