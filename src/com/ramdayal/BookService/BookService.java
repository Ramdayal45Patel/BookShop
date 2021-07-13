package com.ramdayal.BookService;

import java.util.ArrayList;
import java.util.List;

import com.ramdayal.dao.AddDataBase;
import com.ramdayal.model.BookAdd;

public class BookService {
	// singleton design pattern
	private static BookService bookService = new BookService();

	private BookService() {
	}

	public static BookService getBookService() {
		return bookService;
	}

	public String insert(BookAdd book) {
		String msg = "";
		try {
			msg = (AddDataBase.getAddDataBase().insert(book) > 0) ? "Successfully Added" : "Book Added Failed";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}

	public List<BookAdd> getAllBooks() {

		try {
			return AddDataBase.getAddDataBase().getAllBooks();
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}

	public String deleteBookbyName(String books) {
		String msg = "";
		try {
			msg = (AddDataBase.getAddDataBase().deleteBooks(books) > 0) ? "Successfully Deleted"
					: "Book Deleted Failed";
		} catch (Exception e) {
			msg = e.toString();
		}
		return msg;
	}
}
