package by.svirski.tests6_1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.util.parser.impl.ParserDateImpl;

public class TestParser {

	@Test
	public void testDate() {
		ParserDateImpl parser = new ParserDateImpl();
		try {
			Calendar date = parser.parse("19:12:2000");
			Calendar expected = new GregorianCalendar();
			expected.set(Calendar.YEAR, 2000);
			expected.set(Calendar.MONTH, 11);
			expected.set(Calendar.DAY_OF_MONTH, 19);
			assertEquals(date.compareTo(expected), 0);
		} catch (CustomParseException e) {
			fail();
			e.printStackTrace();
		}

	}

	@DataProvider(name = "incData")
	public Object[][] createParams() {
		return new Object[][] { { "1:0:2000" }, { "1::2000" }, { "102000" }, { "45:12:2000" }, { "31:11:2000" },
				{ "12:12:1799" }, { "12:12:2021" } };
	}

	@Test(dataProvider = "incData", groups = { "incorrect" }, expectedExceptionsMessageRegExp = "error in parsing")
	public void testDateInc(String parameter) {
		ParserDateImpl parser = new ParserDateImpl();
		try {
			Calendar date = parser.parse(parameter);
			fail();
		} catch (CustomParseException e) {
			assertEquals(e.getMessage(), "error in parsing");
		}

	}
}
