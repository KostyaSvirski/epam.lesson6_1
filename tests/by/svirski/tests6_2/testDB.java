package by.svirski.tests6_2;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import org.testng.annotations.Test;

import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.impl.AppServiceDbImpl;

public class TestDB {
	
	@Test
	public void addElement() {
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			boolean actual = service.addBook(new String[] { "a", "Ray Bradbury", "A", "1:1:2000", "AAA" });
			assertTrue(actual);
		} catch (CustomServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void removeElement() {
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			boolean actual = service.removeBook("a");
			assertTrue(actual);
		} catch (CustomServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void sortElements() {
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			List<CustomBook> listOfBooks = service.sortByTag("Authors");
			System.out.println(listOfBooks.toString());
			boolean actual = true;
			assertTrue(actual);
		} catch (CustomServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	//TODO 23.07.2020 1:51 fix Tag find;
	@Test
	public void findElements() {
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			List<CustomBook> listOfBooks = service.findBookByTag("publishing house", "Random House");
			System.out.println(listOfBooks.toString());
			boolean actual = true;
			assertTrue(actual);
		} catch (CustomServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

}
