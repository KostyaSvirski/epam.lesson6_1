package by.svirski.lesson6_1.model.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.model.exception.CustomSelectionException;
import by.svirski.lesson6_1.utils.parser.impl.ParserDateImpl;

public enum CustomSelect {
	
	BY_AUTHOR("author") {
		@Override
		public List<CustomBook> exectuteSelection(List<CustomBook> listOfBooks, String author) {
			List<CustomBook> foundList = new ArrayList<CustomBook>();
			for(CustomBook book : listOfBooks) {
				for(String authorToCheck : book.getAuthors()) {
					if(authorToCheck.equalsIgnoreCase(author)) {
						foundList.add(book);
					}
				}
			}
			return foundList;
		}
	},
	
	BY_NAME("name") {
		@Override
		public List<CustomBook> exectuteSelection(List<CustomBook> listOfBooks, String nameOfBook) {
			List<CustomBook> foundList = new ArrayList<CustomBook>();
			for(CustomBook book : listOfBooks) {
				if(book.getBookName().equalsIgnoreCase(nameOfBook)) {
					foundList.add(book);
				}
			}
			return foundList;
		}
	},
	
	BY_GENRE("genre") {
		@Override
		public List<CustomBook> exectuteSelection(List<CustomBook> listOfBooks, String genre) {
			List<CustomBook> foundList = new ArrayList<CustomBook>();
			for(CustomBook book : listOfBooks) {
				if(book.getGenre().equalsIgnoreCase(genre)) {
					foundList.add(book);
				}
			}
			return foundList;
		}
	},
	
	BY_DATE("date") {
		@Override
		public List<CustomBook> exectuteSelection(List<CustomBook> listOfBooks, String date) throws CustomSelectionException {
			List<CustomBook> foundList = new ArrayList<CustomBook>();
			ParserDateImpl parser = new ParserDateImpl();
			try {
				Calendar parsedDate =  parser.parse(date);
				for(CustomBook book : listOfBooks) {
					if(book.getPublishDate().equals(parsedDate)) {
						foundList.add(book);
					}
				}
			} catch (CustomParseException e) {
				throw new CustomSelectionException("error in selection");
			}
			
			return foundList;
		}
	},
	
	BY_PUBLISHING_HOUSE("publisher") {
		@Override
		public List<CustomBook> exectuteSelection(List<CustomBook> listOfBooks, String publHouse) {
			List<CustomBook> foundList = new ArrayList<CustomBook>();
			for(CustomBook book : listOfBooks) {
				if(book.getPublishHouse().equalsIgnoreCase(publHouse)) {
					foundList.add(book);
				}
			}
			return foundList;
		}
	};
	
	private String tag;
	
	public String getTag() {
		return tag;
	}

	private CustomSelect(String tag) {
		this.tag = tag;
	}

	public abstract List<CustomBook> exectuteSelection(List<CustomBook> listOfBooks, String parameter) throws CustomSelectionException;

}
