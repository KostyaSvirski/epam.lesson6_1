package by.svirski.lesson6_2.util.parser;

import by.svirski.lesson6_2.model.exception.CustomParseException;

public interface CustomParser<T> {
	T parse(String sourceValue) throws CustomParseException;
}
