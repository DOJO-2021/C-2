package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chat;

//データベースから掲示板の内容を取り出すクラス
public class FindCommentDao {
	public List<Chat> findcomment() {
		//id name commnetを書くのするリスト
		Connection conn = null;
		List<Chat> list = new ArrayList<Chat>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");
			try {
			// SQL文を準備する
				Statement st = conn.createStatement();
				String sql = "select * from chat";

				try {
				//sqlを送信
					ResultSet rs = st.executeQuery(sql);
					// SQL文を完成させる
					while(rs.next()) {
						Chat ch = new Chat();
						ch.setChat_id(rs.getInt("chat_id"));
						ch.setId(rs.getString("id"));
						ch.setName(rs.getString("name"));
						ch.setText(rs.getString("text"));
						ch.setTime(rs.getTimestamp("time"));

						list.add(ch);
					}

					rs.close();
					st.close();

				}catch(SQLException e) {
                    e.printStackTrace();
                }
			} catch (SQLException e) {
	                e.printStackTrace();
	            }finally {
	                // データベース接続の切断
	                if (conn != null) {
	                    try {
	                        conn.close();

	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Connection Failed.");
	            return null;
	        }
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			list = null;
		}
	        return list;

	    }



	public class FindComment {
		public List<Chat> executeFindComment() {
			FindCommentDao fcdao = new FindCommentDao ();
			List<Chat> list = fcdao.findcomment();
			return list;
		}
	}
}

