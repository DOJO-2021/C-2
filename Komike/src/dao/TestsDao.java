package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

				    }

			}


