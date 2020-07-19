package by.svirski.lesson6_1.controller.command;

import by.svirski.lesson6_1.controller.command.impl.*;

public enum TypeOfCommand {
	
	CREATE_STORAGE(new CreateStorageCommand()),
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
