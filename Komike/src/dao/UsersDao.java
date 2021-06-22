package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDao {
	// ログインできるならtrueを返す
	public boolean isLoginOK(String id, String password) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/Komike", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from USER where id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql); //PreparedStatementはscript要素を無害化してくれる
			pStmt.setString(1, id);
			pStmt.setString(2, password);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();//nextメソッド
			if (rs.getInt("count(*)") == 1) { //count(*)をもってくることでID、PW当てはまった一件を取得できる。
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close(); //変数connを用意してデータベースに接続する
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	//新規登録の処理
	public boolean insert(User data) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する
			String sql = "insert into USER values (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (data.getId() != null) {
				pStmt.setString(1, data.getId());
			} else {
				pStmt.setString(1, "null");
			}
			if (data.getPassword() != null) {
				pStmt.setString(2, data.getPassword());
			} else {
				pStmt.setString(2, "null");
			}

			// SQL文を実行する 処理されたレコード件数
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	//パスワード変更の処理
	public boolean update(User data) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/Komike", "sa", "");

			// SQL文を準備する
			String sql = "update USER set password =? where id =?"; //UPDATE user SET password = 'okutomi' WHERE ID='dojo';
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (data.getPassword() != null) {
				pStmt.setString(1, data.getPassword());
			} else {
				pStmt.setString(1, "null");
			}

			if (data.getId() != null) {
				pStmt.setString(2, data.getId());
			} else {
				pStmt.setString(2, "null");
			}
			// SQL文を実行する 処理されたレコード件数
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
