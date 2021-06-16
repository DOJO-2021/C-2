package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Test_choice_detail;
import model.Test_question;

public class TestsDao {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<Test_question> select() {
				Connection conn = null;
				List<Test_question> questionList = new ArrayList<Test_question>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/komike", "sa", "");
					try {
						// SQL文を準備する
							Statement st = conn.createStatement();
							String sql = "select * from test_question";
							String sql_choice = "select * from test_choice";


							try {
								// SQL文を実行し、結果表を取得する
								ResultSet rs = st.executeQuery(sql);

								// SQL文を完成させる
								while(rs.next()) {
									Test_question te = new Test_question();
									te.setQuestion_number(rs.getString("question_number"));
									te.setQuestion_sentence(rs.getString("question_sentence"));

									st_test_question.setInt(1, te.getQuestion_number());
									ResultSet rs_choice = st.executeQuery(sql_choice);

									while(rs_choice.next()){
										Test_choice_detail tcd = new Test_choice_detail();
										tcd.setChoice_number(0);
										tcd.setTrue_false(false);
										tcd.setChoice(rs.getString("choice"));

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

				    }

			}


