package by.svirski.lesson6_1.model.creator.impl;

import java.util.Calendar;

import by.svirski.lesson6_1.model.creator.CustomCreator;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomCreationException;
import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.utils.parser.CustomParser;
import by.svirski.lesson6_1.utils.parser.impl.ParserDateImpl;

public class BookCreatorImpl implements CustomCreator<CustomBook> {

	@Override
	public CustomBook create(String... parameters) throws CustomCreationException {
		CustomBook newBook = new CustomBook();
		newBook.setBookId();
		newBook.setBookName(parameters[0]);
		newBook.setAuthors(parameters[1].split(" "));
		newBook.setGenre(parameters[2]);
		try {
			CustomParser<Calendar> parserDate = new ParserDateImpl();
			newBook.setPublishDate(parserDate.parse(parameters[3]));
		} catch (CustomParseException e) {
			throw new CustomCreationException(e.getMessage());
		}
		newBook.setPublishHouse(parameters[4]);
		return newBook;
	}

}
