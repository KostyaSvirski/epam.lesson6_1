package by.svirski.lesson6_1.model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import by.svirski.lesson6_1.db.ConnectorDB;
import by.svirski.lesson6_1.model.dao.BookListDaoDB;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomDaoException;
import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.util.parser.impl.ParserDateImpl;

public class BookListDaoDbImpl implements BookListDaoDB {

	private final static String INSERT_SQL = "INSERT INTO books (NameOfBook, Authors, Genre, DateOfPublish, PublishHouse) VALUES (?, ?, ?, ?, ?)";
	private final static String SORTING_SQL = "SELECT NameOfBook, Authors, Genre, DateOfPublish, PublishHouse FROM books ORDER BY ? DESC";
	private final static String DELETE_SQL = "DELETE FROM books WHERE NameOfBook = ?";
	private final static String FIND_SQL = "SELECT NameOfBook, Authors, Genre, DateOfPublish, PublishHouse FROM books WHERE ? = ?";

	private Connection cn;

	public BookListDaoDbImpl() throws CustomDaoException {
		try {
			cn = ConnectorDB.getConnection();
		} catch (SQLException e) {
			throw new CustomDaoException("error in creating connection");
		}
	}

	@Override
	public boolean addBook(String... parameters) throws CustomDaoException {
		boolean flag = false;
		PreparedStatement pr = null;
		try {
			pr = cn.prepareStatement(INSERT_SQL);
			for (int i = 1; i <= parameters.length; i++) {
				pr.setString(i, parameters[i - 1]);
			}
			pr.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new CustomDaoException("error in adding" + e.getMessage());
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public boolean removeBook(String name) throws CustomDaoException {
		boolean flag = false;
		PreparedStatement pr = null;
		try {
			pr = cn.prepareStatement(DELETE_SQL);
			pr.setString(1, name);
			pr.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new CustomDaoException("error in remove");
		}
		finally {
			try {
				pr.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public List<CustomBook> SortBooksByTag(String tag) throws CustomDaoException {
		PreparedStatement pr = null;
		List<CustomBook> resultList = null;
		try {
			pr = cn.prepareStatement(SORTING_SQL);
			pr.setString(1, tag);
			ResultSet rs = pr.executeQuery();
			resultList = createResultList(rs);
		} catch (SQLException e) {
			throw new CustomDaoException("error in sorting");
		}
		finally {
			try {
				pr.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return resultList;
	}

	@Override
	public List<CustomBook> FindBooksByTag(String tag, String value) throws CustomDaoException {
		PreparedStatement pr = null;
		List<CustomBook> resultList = null;
		try {
			pr = cn.prepareStatement(FIND_SQL);
			pr.setString(1, tag);
			pr.setString(2, value);
			ResultSet rs = pr.executeQuery();
			resultList = createResultList(rs);
		} catch (SQLException e) {
			throw new CustomDaoException("error in finding");
		}
		finally {
			try {
				pr.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return resultList;
	}

	private List<CustomBook> createResultList(ResultSet rs) throws CustomDaoException {
		ParserDateImpl parser = new ParserDateImpl();
		List<CustomBook> listOfBooks = new ArrayList<CustomBook>();
		try {
			String[] parameters = new String[5];
			while (rs.next()) {
				for (int i = 0; i < parameters.length; i++) {
					parameters[i] = rs.getString(i + 1);
				}
				try {
					listOfBooks.add(new CustomBook(parameters[0], parameters[1].split(" "), parameters[2],
							parser.parse(parameters[3]), parameters[4]));
				} catch (CustomParseException e) {
					throw new CustomDaoException("error in parsing");
				}
			}
		} catch (SQLException e) {
			throw new CustomDaoException("error in reading result set" + e.getMessage());
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return listOfBooks;
	}

}
