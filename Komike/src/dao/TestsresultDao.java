package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import model.Test_question;

//データベースのTrue_falseの値を持ってくる
public class TestsresultDao {

	// 引数judgeで検索項目を指定し、検索結果のリストを返す
	public boolean select(String question_number, int choice_number) {
		Connection conn = null;
		boolean TestResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");

			// SQL文を準備する test_choice用
			//(question_number, choice_number)から参照する
			String sql_choice = "select true_false from test_choice where question_number = ? AND choice_number = ?";
			PreparedStatement st_chioce = conn.prepareStatement(sql_choice);

			// SQL文を完成させる
			st_chioce.setString(1, question_number);
			st_chioce.setInt(2, choice_number);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = st_chioce.executeQuery();

			// その問題の正解がtrueならtrueにしてそれ以外はfalseにする
			rs.next();//nextメソッド
			if (rs.getBoolean("true_false") == true) {
				TestResult = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			TestResult = false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			TestResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					TestResult = false;
				}
			}
		}
		//結果を返す
		return TestResult;

	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	/*public List<Test_question> select(String key) {
		Connection conn = null;
		List<Test_question> questionList = new ArrayList<Test_question>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");
			try {
				// SQL文を準備する test_question用
					String sql = "select * from test_question"
							+ "	where question_number IN ("
							+"		 select distinct (test_question.question_number) from test_question join test_choice on test_question.question_number = test_choice.question_number"
							+"		 where test_question.question_number like ?"
							+")";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, key + "%");

					// SQL文を準備する test_choice用
					String sql_choice = "select * from test_choice where question_number = ?";
					PreparedStatement st_chioce = conn.prepareStatement(sql_choice);

					try {
						// SQL文を実行し、結果表を取得する
						ResultSet rs = st.executeQuery();

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
								tcd.setTrue_false(rs_choice.getBoolean("True_false"));
								tcd.setChoice(rs_choice.getString("choice"));

								te.getChoice_detail().add(tcd);
							}


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

		    }*/
}