package by.svirski.lesson6_1.controller.command.impl;

import java.util.List;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.response.CustomResponse;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.impl.AppServiceDbImpl;

public class SortCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			List<CustomBook> sortedList = service.sortByTag(request);
			response.setListFound(sortedList);
		} catch (CustomServiceException e) {
			response.setError(true);
			return response;
		}
		return response;
	}
}
