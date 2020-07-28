package by.svirski.lesson6_2.controller.command.impl;

import java.util.List;

import by.svirski.lesson6_2.controller.command.ActionCommand;
import by.svirski.lesson6_2.controller.response.CustomResponse;
import by.svirski.lesson6_2.model.entity.CustomBook;
import by.svirski.lesson6_2.model.exception.CustomServiceException;
import by.svirski.lesson6_2.model.service.impl.AppServiceDbImpl;

public class SortCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			List<CustomBook> sortedList = service.sortByTag(request);
			response.setSortedList(sortedList);
		} catch (CustomServiceException e) {
			response.setError(true);
			return response;
		}
		return response;
	}
}
