package by.svirski.lesson6_1.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.svirski.lesson6_1.model.exception.CustomStorageException;

public class StorageOfBooks {
	
	private static StorageOfBooks instance = null;
	private List<CustomBook> listOfBooks;
	private final int maxCountOfBooks;

	private StorageOfBooks(int maxCountOfBooks) {
		this.listOfBooks = new ArrayList<CustomBook>();
		this.maxCountOfBooks = maxCountOfBooks;
	}

	public static StorageOfBooks createStorage(int maxCountOfBooks) {
		if (!isExist()) {
			instance = new StorageOfBooks(maxCountOfBooks);
		}
		return instance;
	}

	public static StorageOfBooks getInstance() throws CustomStorageException {
		if (instance == null) {
			throw new CustomStorageException("storage is not exist");
		}
		return instance;
	}

	private static boolean isExist() {
		return (instance != null) ? true : false;
	}

	public boolean addBookToStorage(CustomBook book) throws CustomStorageException {
		if (book != null) {
			for(CustomBook bookToCheck : listOfBooks) {
				if(book.equals(bookToCheck)) {
					throw new CustomStorageException("book is already exist");					
				}
			}
			if (listOfBooks.size() + 1 <= maxCountOfBooks) {
				listOfBooks.add(book);
				return true;
			}
		}
		return false;
	}

	public boolean removeBookFromStorage(CustomBook book) {
		if (book != null) {
			listOfBooks.remove(book);
			return true;
		}
		return false;
	}

	public List<CustomBook> getListOfBooks() {
		List<CustomBook> listOfBooksReadOnly = Collections.unmodifiableList(listOfBooks);
		return listOfBooksReadOnly;
	}

	public CustomBook findBookById(int id) {
		CustomBook book = null;
		for (CustomBook bookToCheck : listOfBooks) {
			if (bookToCheck.getBookId() == id) {
				book = bookToCheck;
			}
		}
		return book;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StorageOfBooks [listOfBooks=");
		builder.append(listOfBooks);
		builder.append(", maxCountOfBooks=");
		builder.append(maxCountOfBooks);
		builder.append("]");
		return builder.toString();
	}
}
