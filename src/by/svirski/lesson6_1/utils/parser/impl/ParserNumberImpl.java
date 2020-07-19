package by.svirski.lesson6_1.utils.parser.impl;

import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.utils.parser.CustomParser;

public class ParserNumberImpl implements CustomParser<Integer> {

	@Override
	public Integer parse(String sourceValue) throws CustomParseException {
		if(Integer.parseInt(sourceValue) > 0 && Integer.parseInt(sourceValue) < 100) {
			int value = Integer.parseInt(sourceValue);
			return value;
		} else {
			throw new CustomParseException("not correct number");
		}
	}

}
