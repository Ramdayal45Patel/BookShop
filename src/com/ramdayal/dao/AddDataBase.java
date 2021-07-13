package com.ramdayal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramdayal.model.BookAdd;

public class AddDataBase {
	// singleton design pattern
	private static AddDataBase add = new AddDataBase();

	private AddDataBase() {
	}

	public static AddDataBase getAddDataBase() {
		return add;
	}

	public int insert(BookAdd add) {
		int i = 0;
		try (Connection con = Dao.getConnection()) {
			PreparedStatement smt = con.prepareStatement("insert into bookdata values(?,?,?,?,?,?,?)");
			smt.setInt(1, add.getId());
			smt.setString(2, add.getBook());
			smt.setString(3, add.getAuthor());
			smt.setString(4, add.getCategory());
			smt.setString(5, add.getDate());
			smt.setInt(6, add.getPrice());
			smt.setString(7, add.getImages());
			i = smt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return i;
	}

	public int deleteBooks(String book) throws SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("delete from bookdata where BookName=?");
		ps.setString(1, book);
		return ps.executeUpdate();
	}

	public List<BookAdd> getAllBooks() throws SQLException {
		List<BookAdd> books = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from bookdata");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BookAdd book = new BookAdd(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7));
			book.setBook(rs.getString(2));
			books.add(book);
		}
		return books;
	}

}
