import java.util.ArrayList;

import dao.BookDAO;
import model.Book;

public class SelectBooks {

	public static void main(String[] args) {

		// bookテーブルの全レコードを取得

		BookDAO bookDAO = new BookDAO();
		ArrayList<Book> booklist = bookDAO.findAll();

		// 取得したレコードの内容を出力

		for (Book book : booklist) {
			System.out.println("Title :" + book.getTitle());
			System.out.println("Author :" + book.getAuthor());
			System.out.println("Publisher :" + book.getPublisher());
		}
	}

}
