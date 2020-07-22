package by.svirski.lesson6_1.model.service;

import java.util.List;

import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.entity.StorageOfBooks;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.exception.CustomValidationException;

public interface CustomService<T> {
	StorageOfBooks createStorage(String capacity) throws CustomServiceException;

	boolean addBook(String... parameters) throws CustomServiceException;

	boolean removeBook(String name) throws CustomServiceException;

	T sortByTag(String typeOfSorting) throws CustomServiceException, CustomValidationException;

	List<CustomBook> findBookByTag(String tagToFind, String parameter) throws CustomServiceException;

}
