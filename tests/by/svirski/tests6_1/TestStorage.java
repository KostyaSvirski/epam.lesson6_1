package by.svirski.tests6_1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.svirski.lesson6_1.model.entity.StorageOfBooks;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.impl.AppServiceImpl;

public class TestStorage {

	private StorageOfBooks storage;

	@BeforeSuite
	public void createStorage() {
		AppServiceImpl service = new AppServiceImpl();
		try {
			storage = service.createStorage("3");
		} catch (CustomServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@DataProvider(name = "booksParams")
	public Object[][] createParams() {
		return new Object[][] { { "a", "qwer", "A", "1:1:2000", "AAA" }, { "b", "qwer", "B", "1:1:2000", "BBB" },
				{ "c", "asdf zxcv", "C", "2:1:2000", "CCC" }};
	}

	@Test(dataProvider = "booksParams", groups = { "correctInput" })
	public void testAdding(String nameOfBook, String authors, String genre, String date, String publisher) {
		AppServiceImpl service = new AppServiceImpl();
		try {
			boolean actual = service.addBook(nameOfBook, authors, genre, date, publisher);
			assertEquals(actual, true);
		} catch (CustomServiceException e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test(groups = { "inCorrectInput" })
	public void testAddingExtra() {
		AppServiceImpl service = new AppServiceImpl();
		try {
			boolean actual = service.addBook("a", "qwer", "A", "1:1:2000", "AAA" );
			assertFalse(actual);
		} catch (CustomServiceException e) {
			fail();
			e.printStackTrace();
		}
	}

}
