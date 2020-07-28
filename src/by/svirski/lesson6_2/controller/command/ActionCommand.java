package by.svirski.lesson6_2.controller.command;

import by.svirski.lesson6_2.controller.response.CustomResponse;

public interface ActionCommand {
	
	CustomResponse execute(String request);

}
