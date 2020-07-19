package by.svirski.lesson6_1.model.dao;

import java.util.List;

import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.entity.StorageOfBooks;
import by.svirski.lesson6_1.model.exception.CustomDaoException;

public interface BookListDao {

	StorageOfBooks createStorage(String capacity) throws CustomDaoException;

	boolean addBook(String... parameters) throws CustomDaoException;

	boolean removeBookById(int id) throws CustomDaoException;

	List<CustomBook> sellectBookList() throws CustomDaoException;
}
