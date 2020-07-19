package by.svirski.lesson6_1.controller.command.impl;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.response.CustomResponse;
import by.svirski.lesson6_1.model.exception.CustomServiceException;
import by.svirski.lesson6_1.model.service.impl.AppServiceImpl;

public class RemoveCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		AppServiceImpl service = new AppServiceImpl();
		CustomResponse response = new CustomResponse();
		try {
			boolean result = service.removeBook(request);
			response.setResultOfExecution(result);
		} catch (CustomServiceException e) {
			response.setError(true);
		}
		return response;
	}

}
