package test;
import dao.TestsresultDao;

public class TestsresultTestDao {
	public static void main(String[] args) {

		testIsResultOK1();	// テストのデータが見つかる場合のテスト
	}

	public static void testIsResultOK1() {
		TestsresultDao dao = new TestsresultDao();
		if (dao.select("java01", 1)) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		}else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}

	}





}