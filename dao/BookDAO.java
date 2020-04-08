package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;

public class BookDAO {

	// データベース接続に利用する情報
	private final String dbUrl = "jdbc:mariadb://localhost/db1";
	private final String dbUserName = "root";
	private final String dbPassword = "1234";

	public ArrayList<Book> findAll(){
		ArrayList<Book> bookList = new ArrayList<>();

		// データベースへ接続する
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword)){

			// SQL文
			String sql = "select title, author, publisher from book";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文の実行、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// レコードの内容をBookインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");

				Book book = new Book(title, author, publisher);
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bookList;

	}


}
