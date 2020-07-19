package by.svirski.lesson6_1.controller.invoker;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.provider.CommandProvider;
import by.svirski.lesson6_1.controller.response.CustomResponse;

public class CustomInvoker {

	public CustomResponse executeRequest(String request) {
		String[] parsedRequest = request.split(" ", 2);
		if (parsedRequest.length < 2 || parsedRequest[0].isBlank() || parsedRequest[1].isBlank()) {
			CustomResponse responseErr = new CustomResponse();
			responseErr.setError(true);
			return responseErr;
		}
		ActionCommand command = CommandProvider.defineCommand(parsedRequest[0].toUpperCase());
		CustomResponse response = command.execute(parsedRequest[1]);
		return response;
	}
}
