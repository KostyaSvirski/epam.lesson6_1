package by.svirski.lesson6_1.controller.command.impl;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.response.CustomResponse;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.impl.AppServiceImpl;

public class AddCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			boolean result = service.addBook(request.split(" ", 5));
			response.setResultOfExecution(result);
		} catch (CustomServiceException e) {
			response.setError(true);
		}
		return response;
	}

}
