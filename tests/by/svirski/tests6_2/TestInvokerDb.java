package by.svirski.tests6_2;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import by.svirski.lesson6_1.controller.invoker.CustomInvoker;
import by.svirski.lesson6_1.controller.response.CustomResponse;

public class TestInvokerDb {

	@Test
	public void removeElement() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("REMOVE_BOOK a");
		assertTrue(response.getResultOfExecution());
	}
	
	@Test
	public void testAddingBook() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("ADD_BOOK a qwerty AAA 1:1:2000 aaa");
		assertTrue(response.getResultOfExecution());
	}
	
	@Test
	public void testFindingBooks() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("FIND_BOOKS name Fahrenheit 451");
		assertFalse(response.getError());
	}
	
	@Test
	public void testSortingBooks() {
		CustomInvoker invoker = new CustomInvoker();
		CustomResponse response = new CustomResponse();
		response = invoker.executeRequest("SORT_BOOKS nameOfBook");
		assertFalse(response.getError());
	}
	
}
