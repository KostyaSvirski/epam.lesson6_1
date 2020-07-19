package by.svirski.lesson6_1.controller.command.impl;

import java.util.TreeSet;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.response.CustomResponse;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.exception.CustomValidationException;
import by.svirski.lesson6_1.model.service.impl.AppServiceImpl;

public class SortCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			TreeSet<CustomBook> sortedList = service.sortByTag(request);
			response.setSortedList(sortedList);
		} catch (CustomServiceException e) {
			response.setError(true);
		} catch (CustomValidationException e) {
			response.setError(true);
		}
		return response;
	}

}
