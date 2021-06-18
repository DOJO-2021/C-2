package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Test_result;

public class TestsresultDao {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<Test_result> select() {
				Connection conn = null;


				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");
					try {
						// SQL文を準備する
							String sql = "select * from test_question";
							PreparedStatement st = conn.prepareStatement(sql);

							String sql_choice = "select * from test_choice where question_number = ?";
							PreparedStatement st_chioce = conn.prepareStatement(sql_choice);

							try {
								// SQL文を実行し、結果表を取得する
								ResultSet rs = st.executeQuery();

								// SQL文を完成させる
								while(rs.next()) {
									Test_result te = new Test_result();
									te.setrank(rs.getInt("rank"));
									te.setQuestion_sentence(rs.getInt("correct_answer"));

									st_chioce.setString(1, te.getQuestion_number());
									ResultSet rs_choice = st_chioce.executeQuery();

									/*while(rs_choice.next()){
										Test_choice_detail tcd = new Test_choice_detail();
										tcd.setChoice_number(rs_choice.getInt("choice_number"));
										tcd.setTrue_false(rs_choice.getBoolean("True_false"));
										tcd.setChoice(rs_choice.getString("choice"));

										te.getChoice_detail().add(tcd);
									}*/


									questionList.add(te);
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
						questionList = null;
					}
				        return questionList;

				    }

			}
/*public List<Test_question> select(String key) {
Connection conn = null;
	ArrayList<Test_question> results = new ArrayList<Test_question>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");




		// SQL文を準備する	testテーブル用
		String sql = "select * from Test_question "
				+ "where test_id IN ("
				+ "					select distinct(test.test_id) "
				+ "					from test join test_result on test.test_id = test_result.test_id"
				+ "        			where name like ? or remarks like ? or comment like ?"
				+ ")";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, "%" + key + "%");
		pStmt.setString(2, "%" + key + "%");
		pStmt.setString(3, "%" + key + "%");

		// SQL文を準備する	test_resultテーブル用
		String sql_result = "select * from test_result where question_number= ? order by ex_datetime";
		PreparedStatement pStmt_result = conn.prepareStatement(sql_result);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();




		// SQL文を完成させる
		while(rs.next()) {
			Test_question te = new Test_question();
			te.setQuestion_number(rs.getString("question_number"));
			te.setQuestion_sentence(rs.getString("question_sentence"));

			st_chioce.setString(1, te.getQuestion_number());
			ResultSet rs_choice = st_chioce.executeQuery();

			while(rs_choice.next()){
				Test_choice_detail tcd = new Test_choice_detail();
				tcd.setChoice_number(rs_choice.getInt("choice_number"));
				tcd.setTrue_false(rs_choice.getBoolean("true_false"));
				tcd.setChoice(rs_choice.getString("choice"));

				te.getChoice_detail().add(tcd);
			}


			questionList.add(te);
		}

		rs.close();
		st.close();

	}
	catch (SQLException e) {
		e.printStackTrace();
		results = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		results = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				results = null;
			}
		}
	}
	return results;
}

}*/





