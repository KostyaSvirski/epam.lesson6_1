package by.svirski.lesson6_1.model.service.impl;

import java.util.List;

import by.svirski.lesson6_1.model.dao.BookListDaoDB;
import by.svirski.lesson6_1.model.dao.impl.BookListDaoDbImpl;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.entity.StorageOfBooks;
import by.svirski.lesson6_1.model.exception.CustomDaoException;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.CustomService;
import by.svirski.lesson6_1.util.validator.impl.ValidatorDateImpl;
import by.svirski.lesson6_1.util.validator.impl.ValidatorStringsImpl;

public class AppServiceDbImpl implements CustomService<List<CustomBook>> {

	@Override
	public StorageOfBooks createStorage(String capacity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(String... parameters) throws CustomServiceException {
		BookListDaoDB bookListDao;
		try {
			bookListDao = new BookListDaoDbImpl();
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in creating dao");
		}
		ValidatorStringsImpl validatorForStrings = new ValidatorStringsImpl();
		ValidatorDateImpl validatorForDate = new ValidatorDateImpl();
		for (int i = 0; i < parameters.length; i++) {
			if (!validatorForStrings.validate(parameters[i]) && i != 3) {
				throw new CustomServiceException("not valid name");
			} else if (i == 3 && !validatorForDate.validate(parameters[i])) {
				throw new CustomServiceException("not valid date");
			}
		}
		boolean resultOfExecuting = false;
		try {
			resultOfExecuting = bookListDao.addBook(parameters);
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in adding");
		}
		return resultOfExecuting;
	}

	@Override
	public boolean removeBook(String name) throws CustomServiceException {
		BookListDaoDbImpl bookListDao;
		try {
			bookListDao = new BookListDaoDbImpl();
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in creating dao");
		}
		ValidatorStringsImpl validator = new ValidatorStringsImpl();
		boolean resultOfExecuting = false;
		if(validator.validate(name)) {
			try {
				resultOfExecuting = bookListDao.removeBook(name);
			} catch (CustomDaoException e) {
				throw new CustomServiceException(e.getMessage());
			}
		}
		return resultOfExecuting;
	}

	@Override
	public List<CustomBook> sortByTag(String typeOfSorting) throws CustomServiceException {
		BookListDaoDbImpl bookListDao;
		try {
			bookListDao = new BookListDaoDbImpl();
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in creating dao");
		}
		ValidatorStringsImpl validator = new ValidatorStringsImpl();
		List<CustomBook> listOfBooks = null;
		if(validator.validate(typeOfSorting)) {
			try {
				listOfBooks = bookListDao.sortBooksByTag(typeOfSorting);
			} catch (CustomDaoException e) {
				throw new CustomServiceException(e.getMessage());
			}
		}
		return listOfBooks;
	}

	@Override
	public List<CustomBook> findBookByTag(String tagToFind, String parameter) throws CustomServiceException {
		BookListDaoDbImpl bookListDao;
		try {
			bookListDao = new BookListDaoDbImpl();
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in creating dao");
		}
		ValidatorStringsImpl validator = new ValidatorStringsImpl();
		List<CustomBook> listOfBooks = null;
		if(validator.validate(tagToFind) && validator.validate(parameter)) {
			try {
				listOfBooks = bookListDao.findBooksByTag(tagToFind, parameter);
			} catch (CustomDaoException e) {
				throw new CustomServiceException(e.getMessage());
			}
		}
		return listOfBooks;
	}

}
