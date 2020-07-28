package by.svirski.lesson6_2.controller.command.impl;

import by.svirski.lesson6_2.controller.command.ActionCommand;
import by.svirski.lesson6_2.controller.response.CustomResponse;
import by.svirski.lesson6_2.model.exception.CustomServiceException;
import by.svirski.lesson6_2.model.service.impl.AppServiceDbImpl;

public class AddCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceDbImpl service = new AppServiceDbImpl();
		try {
			boolean result = service.addBook(request.split(" ", 5));
			response.setResultOfExecution(result);
		} catch (CustomServiceException e) {
			response.setError(true);
		}
		return response;
	}

}
