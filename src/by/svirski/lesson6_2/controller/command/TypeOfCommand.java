package by.svirski.lesson6_2.controller.command;

import by.svirski.lesson6_2.controller.command.impl.*;

public enum TypeOfCommand {
	
	ADD_BOOK(new AddCommand()),
	REMOVE_BOOK(new RemoveCommand()),
	SORT_BOOKS(new SortCommand()),
	FIND_BOOKS(new FindCommand());
	
	private ActionCommand command;

	private TypeOfCommand(ActionCommand command) {
		this.command = command;
	}

	public ActionCommand getCommand() {
		return command;
	}

}
