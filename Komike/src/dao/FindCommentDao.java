package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Chat;
import model.Question;
import model.Test_result;

//データベースから掲示板の内容を取り出すクラス
public class FindCommentDao {
	public static List<Chat> findcomment() {
		//id name commnetを書くのするリスト
		Connection conn = null;
		List<Chat> list = new ArrayList<Chat>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");
			try {
			// SQL文を準備する
				Statement st = conn.createStatement();
				String sql = "select * from chat";

				try {
				//sqlを送信
					ResultSet rs = st.executeQuery(sql);

					// SQL文を完成させる　〇
					while(rs.next()) {
						Chat ch = new Chat();
						ch.setChat_id(rs.getInt("chat_id"));
						ch.setId(rs.getString("id"));
						ch.setName(rs.getString("name"));
						ch.setText(rs.getString("text"));
						ch.setImage_name(rs.getString("image_name"));
						ch.setTime(rs.getDate("time"));

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

	public static List<Question> indcomment() {
		//id name commnetを書くのするリスト
		Connection conn = null;
		List<Question> list = new ArrayList<Question>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");
			try {
			// SQL文を準備する
				Statement st = conn.createStatement();
				String sql = "select * from question order by good_number desc limit 3";

				try {
				//sqlを送信
					ResultSet rs = st.executeQuery(sql);

					// SQL文を完成させる　〇
					while(rs.next()) {
						Question ch = new Question();
						ch.setQuestion_id(rs.getInt("question_id"));
						ch.setId(rs.getString("id"));
						ch.setTitle(rs.getString("title"));
						ch.setName(rs.getString("name"));
						ch.setText(rs.getString("text"));
						ch.setGood_number(rs.getInt("good_number"));
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

	//検索を行うメソッド
	public static List<Question> search(String key) {

		Connection conn = null;
		List<Question> list = new ArrayList<Question>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");
			try {
			// SQL文を準備する(questionrテーブル)
				Statement st = conn.createStatement();
				String sql = "select * from question where title like ? or text like ?";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, "%" + key + "%");
				pStmt.setString(2, "%" + key + "%");

			// SQL文を準備する(answerテーブル)
				String sql_answer = "select * from answer where question_id = ? and text like ?";
				PreparedStatement pStmt_answer= conn.prepareStatement(sql_answer);
				pStmt_answer.setString(2, "%" + key + "%");
				try {
				//sqlを送信
					ResultSet rs = pStmt.executeQuery();

					// SQL文を完成させる　〇
					while(rs.next()) {
						Question q = new Question();
						q.setQuestion_id(rs.getInt("question_id"));
						q.setId(rs.getString("id"));
						q.setTitle(rs.getString("title"));
						q.setName(rs.getString("name"));
						q.setText(rs.getString("text"));
						q.setGood_number(rs.getInt("good_number"));
						new ArrayList<Answer>();

						pStmt_answer.setInt(1, q.getQuestion_id());
						ResultSet rsr = pStmt_answer.executeQuery();

						while(rsr.next()) {
							Answer ans = new Answer();
							ans.setQuestion_id(rsr.getInt("question_id"));
							ans.setAnswer_id(rsr.getInt("answer_id"));
							ans.setId(rsr.getString("id"));
							ans.setName(rsr.getString("name"));
							ans.setText(rsr.getString("text"));

							q.getAnswer().add(ans);
						}
						list.add(q);
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

	//ランクを取得するメソッド
	public static List<Test_result> rank(Test_result tr) {
		//id name commnetを書くのするリスト
		Connection conn = null;
		List<Test_result> list = new ArrayList<Test_result>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/C-2/komike", "sa", "");
			try {
			// SQL文を準備する
				Statement st = conn.createStatement();
				String sql = "select rank from test_result where id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				try {
				//sql文を完成させる
					if (tr.getId() != null) {
						pStmt.setString(1, tr.getId());
					}
					else {
						pStmt.setString(1, "null");
					}


					ResultSet rs = st.executeQuery(sql);

					// SQL文を完成させる　〇
					while(rs.next()) {
						Test_result t_result = new Test_result();
						t_result.setRank(rs.getInt("rank"));
						list.add(t_result);
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



}




