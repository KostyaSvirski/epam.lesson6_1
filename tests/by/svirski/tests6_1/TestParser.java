package by.svirski.tests6_1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;

import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.utils.parser.impl.ParserDateImpl;

public class TestParser {

	@Test
	public void testDate() {
		ParserDateImpl parser = new ParserDateImpl();
		try {
			Calendar date = parser.parse("1:1:2000");
			System.out.println(date.toString());
			Calendar expected = new GregorianCalendar(2000, 0, 1);
			System.out.println(expected.toString());
			assertEquals(date.compareTo(expected), 0);
		} catch (CustomParseException e) {
			fail();
			e.printStackTrace();
		}

	}
}
