package by.svirski.tests6_1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import by.svirski.lesson6_1.controller.invoker.CustomInvoker;
import by.svirski.lesson6_1.controller.response.CustomResponse;

public class TestInvoker {

	@Test(groups = { "correct" })
	public void testCreateStorage() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE 5");
		assertEquals(response.getResultOfExecution(), true);
	}

	@Test(groups = { "correct" })
	public void testAddingBook() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE 5");
		response = invoker.executeRequest("ADD_BOOK a qwerty AAA 1:1:2000 aaa");
		assertTrue(response.getResultOfExecution());
	}

	@Test(groups = { "correct" })
	public void testRemoveBook() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE 5");
		response = invoker.executeRequest("ADD_BOOK a qwerty AAA 1:1:2000 aaa");
		response = invoker.executeRequest("REMOVE_BOOK a");
		assertTrue(response.getResultOfExecution());
	}
	
	@Test(groups = { "incorrect" })
	public void testRemoveIncBook() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE 5");
		response = invoker.executeRequest("ADD_BOOK a qwerty AAA 1:1:2000 aaa");
		response = invoker.executeRequest("REMOVE_BOOK b");
		assertFalse(response.getResultOfExecution());
	}
	
	@Test(groups = { "incorrect" })
	public void testInvalidRequest() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE");
		assertEquals(response.getError(), true);

	}

	@Test(groups = { "incorrect" })
	public void testInvalidBlankRequest() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE   ");
		assertEquals(response.getError(), true);
	}

	@Test(groups = { "incorrect" })
	public void testInvalidCommand() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAE 5");
		assertEquals(response.getError(), true);

	}

	@Test(groups = { "incorrect" })
	public void testInvlalidParameter() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE a");
		assertEquals(response.getError(), true);
	}

	@Test(groups = { "incorrect" })
	public void testNegativeParameter() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE -5");
		assertEquals(response.getError(), true);
	}

	@Test(groups = { "incorrect" })
	public void testNullParameter() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE 0");
		assertEquals(response.getError(), true);
	}

	@Test(groups = { "incorrect" })
	public void testFractionalParameter() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("CREATE_STORAGE 1.5");
		assertEquals(response.getError(), true);
	}
}
