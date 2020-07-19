package by.svirski.lesson6_1.utils.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.svirski.lesson6_1.utils.validator.AbstractValidator;

public class ValidatorStringsImpl extends AbstractValidator{

	@Override
	public boolean validate(String value) {
		Pattern pattern = Pattern.compile(REGEX_STRING);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
