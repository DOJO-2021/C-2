package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.Chat;
public class ChatsDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Chat> select() {
			Connection conn = null;
			List<Chat> chatList = new ArrayList<Chat>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");

				// SQL文を準備する
				String sql = "select * from chat";
				PreparedStatement pStmt = conn.prepareStatement(sql);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// SQL文を完成させる
				while(rs.next()) {
					Chat comment = new Chat(
					rs.getInt("chat_id"),
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("text"),
					rs.getDate("time")
					);
				chatList.add(comment);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				chatList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				chatList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						chatList = null;
					}
				}
			}

			// 結果を返す
			return chatList;
		}

//コメントを見つけるクラス
public class FindCommentLogic {
    public List<Chat> executeFindComment() {
    	ChatsDao fcdao = new ChatsDao ();
        List<Chat> list = fcdao.select();
        return list;
    }

}


//入力されたものをデータベースに入れるクラス
public class AddCommentDao{
	//データベースにchat_id, id, name, text, dateを加えるメソッド
	Connection conn = null;
	public AddCommentDao(Chat comment) {
		if(comment.getId().isEmpty()) {
			comment.setId("ID無し");
		}
		if(comment.getName().isEmpty()) {
			comment.setName("名無し");
		}
		if(comment.getText().isEmpty()) {
			comment.setText("コメント無し");
		}
		try {

			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");

				// SQL文を準備する
				String sql = "insert into chat value(chat_id, id, name, text, time)";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, comment.getChat_id());
				ps.setString(2, comment.getId());
				ps.setString(3, comment.getName());
				ps.setString(4, comment.getText());
				ps.setDate(5, comment.getTime());

				//ひな形を送信
				int r = ps.executeUpdate();

				if(r != 0) {
					System.out.println(r + "件の書き込みを追加しました");
				} else {
					System.out.println("書き込みできませんでした");
					}
				ps.close();
			}
		catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース接続の切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


	}
}

