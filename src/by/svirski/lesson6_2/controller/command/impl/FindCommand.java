package by.svirski.lesson6_2.controller.command.impl;

import java.util.List;

import by.svirski.lesson6_2.controller.command.ActionCommand;
import by.svirski.lesson6_2.controller.response.CustomResponse;
import by.svirski.lesson6_2.model.entity.CustomBook;
import by.svirski.lesson6_2.model.exception.CustomServiceException;
import by.svirski.lesson6_2.model.service.impl.AppServiceDbImpl;

public class FindCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		String[] parsedRequest = request.split(" ", 2);
		CustomResponse response = new CustomResponse();
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			List<CustomBook> resultList = service.findBookByTag(parsedRequest[0], parsedRequest[1]);
			response.setListFound(resultList);
		} catch (CustomServiceException e) {
			response.setError(true);
		}		
		return response;
	}

}
