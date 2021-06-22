package test;
import dao.TestsresultDao;

public class TestsresultTestDao {
	public static void main(String[] args) {

		testIsResultOK1();	// テストのデータが見つかる場合のテスト
	}

	//テストする際はH2のものを交互に見ながらやるとわかりやすい

	//問題番号と選択番号でデータを探す
	public static void testIsResultOK1() {
		TestsresultDao dao = new TestsresultDao();
		if (dao.select("java02", 2)) {
			//それがもしtrueなら正解になる
			System.out.println("testIsLoginOK1：正解!");
		}else {
			//それがもしfalseなら不正解になる
			System.out.println("testIsLoginOK1：不正解・・・");
		}


		if (dao.select("java03", 4)) {
			System.out.println("testIsLoginOK1：正解!");
		}else {
			System.out.println("testIsLoginOK1：不正解・・・");
		}
	}





}