package by.svirski.lesson6_1.model.creator.impl;

import by.svirski.lesson6_1.model.creator.CustomCreator;
import by.svirski.lesson6_1.model.entity.StorageOfBooks;
import by.svirski.lesson6_1.model.exception.CustomCreationException;
import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.util.parser.CustomParser;
import by.svirski.lesson6_1.util.parser.impl.ParserNumberImpl;

public class StorageCreatorImpl implements CustomCreator<StorageOfBooks> {

	@Override
	public StorageOfBooks create(String... parameters) throws CustomCreationException {
		CustomParser<Integer> parser = new ParserNumberImpl();
		StorageOfBooks storageOfBooks;
		try {
			storageOfBooks = StorageOfBooks.createStorage(parser.parse(parameters[0]));
		} catch (CustomParseException e) {
			throw new CustomCreationException(e.getMessage());
		}
		return storageOfBooks;
	}

}
