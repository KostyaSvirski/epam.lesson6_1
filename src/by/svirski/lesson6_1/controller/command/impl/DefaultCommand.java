package by.svirski.lesson6_1.controller.command.impl;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.response.CustomResponse;

public class DefaultCommand implements ActionCommand {

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		response.setError(true);
		return response;
	}

}
