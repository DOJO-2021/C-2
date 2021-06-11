package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Chat;

public class AddCommentDao{

	public AddCommentDao(Chat ch) {
		if(ch.getName().isEmpty()) {
			ch.setName("名無し");
		}
		if(ch.getText().isEmpty()) {
			ch.setText("本文無し");
		}

		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");
			try {
				PreparedStatement ps = conn.prepareStatement("insert into chat(name, text) values(?, ?)");

				ps.setString(1, ch.getName());
				ps.setString(2, ch.getText());

				int r = ps.executeUpdate();

				if(r !=0) {
					System.out.println(r + "件の書き込みを追加しました");
				} else {
					System.out.println("書き込みできませんでした");
					}

				ps.close();
				}

			}
	}
}

