package by.svirski.lesson6_1.util.parser;

import by.svirski.lesson6_1.model.exception.CustomParseException;

public interface CustomParser<T> {
	T parse(String sourceValue) throws CustomParseException;
}
