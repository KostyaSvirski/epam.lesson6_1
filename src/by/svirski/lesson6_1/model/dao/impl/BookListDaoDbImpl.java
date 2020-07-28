package by.svirski.lesson6_1.model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import by.svirski.lesson6_1.db.ConnectorDB;
import by.svirski.lesson6_1.model.dao.BookListDaoDB;
import by.svirski.lesson6_1.model.dao.command.TagActionCommand;
import by.svirski.lesson6_1.model.dao.provider.TagProvider;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomCommandException;
import by.svirski.lesson6_1.model.exception.CustomDaoException;

public class BookListDaoDbImpl implements BookListDaoDB {

	private final static String INSERT_SQL = "INSERT INTO books (NameOfBook, Authors, Genre, DateOfPublish, PublishHouse) VALUES (?, ?, ?, ?, ?)";
	private final static String SORTING_SQL = "SELECT NameOfBook, Authors, Genre, DateOfPublish, PublishHouse FROM books ORDER BY ";
	private final static String DELETE_SQL = "DELETE FROM books WHERE NameOfBook = ?";

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
	public List<CustomBook> sortBooksByTag(String tag) throws CustomDaoException {
		PreparedStatement pr = null;
		List<CustomBook> resultList = null;
		StringBuilder sb = new StringBuilder(SORTING_SQL);
		sb.append(tag);
		try {
			pr = cn.prepareStatement(sb.toString());
			ResultSet rs = pr.executeQuery();
			resultList = createResultList(rs);
		} catch (SQLException e) {
			throw new CustomDaoException("error in sorting");
		}
		finally {
			try {
				pr.close();
				cn.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return resultList;
	}
	
	@Override
	public List<CustomBook> findBooksByTag(String tag, String value) throws CustomDaoException {
		TagActionCommand command = TagProvider.defineTag(tag);
		List<CustomBook> listOfBooks = new ArrayList<CustomBook>();
		try {
			listOfBooks = command.find(value, cn);
		} catch (CustomCommandException e) {
			throw new CustomDaoException("error in finding " + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return listOfBooks;
	}

	

}
