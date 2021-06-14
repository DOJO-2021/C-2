package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");

			// SQL文を準備する
			String sql = "insert into chat values (null, ?, ?, ?, current_timestamp)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (ch.getId() != null) {
				pStmt.setString(1, ch.getId());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (ch.getName() != null) {
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

	//データベースから削除するメソッド
	public boolean delete(int[] id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を完成させる（for文で複数削除に対応）
			for(int i = 0; i < id.length; i++) {

			// SQL文を準備する
				String sql = "delete from BC where id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setInt(1, id[i]);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
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



