package by.svirski.lesson6_1.controller.command;

import by.svirski.lesson6_1.controller.response.CustomResponse;

public interface ActionCommand {
	
	CustomResponse execute(String request);

}
