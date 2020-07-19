package by.svirski.lesson6_1.controller.provider;

import by.svirski.lesson6_1.controller.command.ActionCommand;
import by.svirski.lesson6_1.controller.command.TypeOfCommand;
import by.svirski.lesson6_1.controller.command.impl.DefaultCommand;

public class CommandProvider {
	public static ActionCommand defineCommand(String command) {
		TypeOfCommand[] values = TypeOfCommand.values();
		for(TypeOfCommand value : values) {
			if(command.equals(value.name())) {
				return value.getCommand();
			}
		}
		return new DefaultCommand();
		
	}
}
