package by.svirski.lesson6_1.util.parser.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.util.parser.CustomParser;

public class ParserDateImpl implements CustomParser<Calendar> {

	@Override
	public Calendar parse(String sourceValue) throws CustomParseException {
		String[] values = sourceValue.split(":");
		if(values.length < 3) {
			throw new CustomParseException("error in parsing");
		} 
		for(String checkValue: values) {
			if(checkValue.isBlank()) {
				throw new CustomParseException("error in parsing");
			}
		}
		Calendar date = new GregorianCalendar();
		if (Integer.parseInt(values[2]) <= 2020 && Integer.parseInt(values[2]) >= 1800) {
			date.set(Calendar.YEAR, Integer.parseInt(values[2]));
			if (Integer.parseInt(values[1]) >= 1 && Integer.parseInt(values[1]) <= 12) {
				date.set(Calendar.MONTH, Integer.parseInt(values[1]) - 1);
				if (Integer.parseInt(values[0]) >= date.getActualMinimum(Calendar.DAY_OF_MONTH)
						&& Integer.parseInt(values[0]) <= date.getActualMaximum(Calendar.DAY_OF_MONTH)) {
					date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(values[0]));
					return date;
				}

			}
		}
		throw new CustomParseException("error in parsing");
	}

}
