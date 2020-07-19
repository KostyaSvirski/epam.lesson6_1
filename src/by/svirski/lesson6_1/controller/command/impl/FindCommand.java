package by.svirski.lesson6_1.controller.command.impl;

import java.util.List;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.response.CustomResponse;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.impl.AppServiceImpl;

public class FindCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		String[] parsedRequest = request.split(" ", 2);
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			List<CustomBook> resultList = service.findBookByTag(parsedRequest[0], parsedRequest[1]);
			response.setListFound(resultList);
		} catch (CustomServiceException e) {
			response.setError(true);
		}		
		return response;
	}

}
