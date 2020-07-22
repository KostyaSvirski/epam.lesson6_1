package by.svirski.lesson6_1.model.dao;

import java.util.List;

import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomDaoException;

public interface BookListDaoDB {
	
	boolean addBook(String... parameters) throws CustomDaoException;

	boolean removeBook(String name) throws CustomDaoException;
	
	List<CustomBook> SortBooksByTag(String tag) throws CustomDaoException;
	
	List<CustomBook> FindBooksByTag(String tag, String value) throws CustomDaoException;
}
