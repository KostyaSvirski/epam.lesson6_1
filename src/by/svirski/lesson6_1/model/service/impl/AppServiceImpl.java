package by.svirski.lesson6_1.model.service.impl;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6_1.model.dao.impl.BookListDaoImpl;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.entity.StorageOfBooks;
import by.svirski.lesson6_1.model.exception.CustomDaoException;
import by.svirski.lesson6_1.model.exception.CustomSelectionException;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.exception.CustomStorageException;
import by.svirski.lesson6_1.model.exception.CustomValidationException;
import by.svirski.lesson6_1.model.service.CustomSelect;
import by.svirski.lesson6_1.model.service.CustomService;
import by.svirski.lesson6_1.model.service.CustomSort;
import by.svirski.lesson6_1.util.validator.impl.ValidatorDateImpl;
import by.svirski.lesson6_1.util.validator.impl.ValidatorNumberImpl;
import by.svirski.lesson6_1.util.validator.impl.ValidatorStringsImpl;

public class AppServiceImpl implements CustomService {

	@Override
	public StorageOfBooks createStorage(String capacity) throws CustomServiceException {
		BookListDaoImpl bookListDao = new BookListDaoImpl();
		ValidatorNumberImpl validator = new ValidatorNumberImpl();
		if (validator.validate(capacity)) {
			try {
				StorageOfBooks storage = bookListDao.createStorage(capacity);
				return storage;
			} catch (CustomDaoException e) {
				throw new CustomServiceException("error in dao: " + e.getMessage());
			}
		} else {
			throw new CustomServiceException("error in validation");
		}
	}

	@Override
	public boolean addBook(String... parameters) throws CustomServiceException {
		BookListDaoImpl bookListDao = new BookListDaoImpl();
		ValidatorStringsImpl validatorForStrings = new ValidatorStringsImpl();
		ValidatorDateImpl validatorForDate = new ValidatorDateImpl();
		for (int i = 0; i < parameters.length; i++) {
			if (!validatorForStrings.validate(parameters[i]) && i != 3) {
				throw new CustomServiceException("not valid name");
			} else if (i == 3 && !validatorForDate.validate(parameters[i])) {
				throw new CustomServiceException("not valid date");
			}
		}
		boolean result = false;
		try {
			result = bookListDao.addBook(parameters);
			return result;
		} catch (CustomDaoException e) {
			//throw new CustomServiceException("error in storage: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean removeBook(String nameOfBook) throws CustomServiceException {
		ValidatorStringsImpl validator = new ValidatorStringsImpl();
		if (validator.validate(nameOfBook)) {
			BookListDaoImpl bookListDao = new BookListDaoImpl();
			List<CustomBook> listOfBooks;
			try {
				listOfBooks = bookListDao.sellectBookList();
				for (CustomBook book : listOfBooks) {
					if (book.getBookName().equalsIgnoreCase(nameOfBook)) {
						try {
							return bookListDao.removeBookById(book.getBookId());
						} catch (CustomDaoException e) {
							throw new CustomServiceException("error in dao: " + e.getMessage());
						}
					}
				}
			} catch (CustomDaoException e1) {
				throw new CustomServiceException("error in dao: " + e1.getMessage());
			}
		}
		return false;
	}

	@Override
	public TreeSet<CustomBook> sortByTag(String typeOfSortingStr)
			throws CustomServiceException, CustomValidationException {
		try {
			ValidatorStringsImpl validator = new ValidatorStringsImpl();
			CustomSort typeOfSorting;
			if (validator.validate(typeOfSortingStr)) {
				typeOfSorting = CustomSort.valueOf(typeOfSortingStr);
			} else {
				throw new CustomServiceException("error in validation");
			}
			BookListDaoImpl bookListDao = new BookListDaoImpl();
			List<CustomBook> listToSort = bookListDao.sellectBookList();
			TreeSet<CustomBook> sortedList;
			switch (typeOfSorting) {
			case BY_ID: {
				sortedList = CustomSort.BY_ID.sort(listToSort);
				break;
			}
			case BY_NAME: {
				sortedList = CustomSort.BY_NAME.sort(listToSort);
				break;
			}
			case BY_AUTHOR: {
				sortedList = CustomSort.BY_AUTHOR.sort(listToSort);
				break;
			}
			case BY_GENRE: {
				sortedList = CustomSort.BY_GENRE.sort(listToSort);
				break;
			}
			case BY_DATE: {
				sortedList = CustomSort.BY_DATE.sort(listToSort);
				break;
			}
			case BY_PUBLISHING_HOUSE: {
				sortedList = CustomSort.BY_PUBLISHING_HOUSE.sort(listToSort);
			}
			default: {
				throw new CustomServiceException("not valid type of sorting");
			}
			}
			return sortedList;
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in storage: " + e.getMessage());
		}
	}

	@Override
	public List<CustomBook> findBookByTag(String tag, String parameter) throws CustomServiceException {
		try {
			ValidatorStringsImpl validator = new ValidatorStringsImpl();
			CustomSelect typeOfSelection;
			if (validator.validate(tag)) {
				typeOfSelection = CustomSelect.valueOf(tag);
			} else {
				throw new CustomServiceException("error in validation");
			}
			BookListDaoImpl bookList = new BookListDaoImpl();
			List<CustomBook> listToCheck = bookList.sellectBookList();
			List<CustomBook> foundList;

			switch (typeOfSelection) {
			case BY_AUTHOR: {
				foundList = CustomSelect.BY_AUTHOR.exectuteSelection(listToCheck, parameter);
				break;
			}
			case BY_NAME: {
				foundList = CustomSelect.BY_NAME.exectuteSelection(listToCheck, parameter);
				break;
			}
			case BY_GENRE: {
				foundList = CustomSelect.BY_GENRE.exectuteSelection(listToCheck, parameter);
				break;
			}
			case BY_DATE: {
				foundList = CustomSelect.BY_DATE.exectuteSelection(listToCheck, parameter);
				break;
			}
			case BY_PUBLISHING_HOUSE: {
				foundList = CustomSelect.BY_PUBLISHING_HOUSE.exectuteSelection(listToCheck, parameter);
				break;
			}
			default: {
				throw new CustomServiceException("not valid type of sorting");
			}
			}
			return foundList;
		} catch (CustomDaoException | CustomSelectionException e) {
			throw new CustomServiceException("error in storage: " + e.getMessage());
		}
	}

}
