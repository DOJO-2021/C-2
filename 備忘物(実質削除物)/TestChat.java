package servlet;

import java.util.List;

import dao.AddCommentDao;
import dao.FindCommentDao;
import model.Chat;

public class TestChat {

	public static void main(String[] args) {
			  AddCommentDao dao = new AddCommentDao();

				// select()のテスト(addressに"東京"を含むデータの検索)
				System.out.println("---------- select()のテスト ----------");
				List<Chat> cardList = FindCommentDao.findcomment();
				for (Chat card : cardList) {
					System.out.println(card.getChat_id());
					System.out.println(card.getId());
					System.out.println(card.getName());
					System.out.println(card.getText());
					System.out.println(card.getTime());

					System.out.println();
					System.out.println();
				}


				// insert()のテスト
				System.out.println("---------- insert()のテスト ----------");
				Chat insRec = new Chat(0, "test", "test", "test", null );
				if (dao.insert(insRec)) {
					System.out.println("登録成功！");
				}
				else {
					System.out.println("登録失敗！");
				}

				// delete()のテスト
				int insId = insRec.getChat_id();

				System.out.println("---------- delete()のテスト ----------");
				if (dao.delete(insId)) {
					System.out.println("削除成功！");
				}
				else {
					System.out.println("削除失敗！");
				}
	}

}
