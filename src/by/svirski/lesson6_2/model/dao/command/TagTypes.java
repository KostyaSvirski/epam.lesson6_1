package by.svirski.lesson6_2.model.dao.command;

import by.svirski.lesson6_2.model.dao.command.impl.*;

public enum TagTypes {
	
	TAG_NAME(new TagName(), "name"),
	TAG_AUTHORS(new TagAuthors(), "author"),
	TAG_GENRE(new TagGenre(), "genre"),
	TAG_DATE(new TagDate(), "date"),
	TAG_PUBLISHER(new TagPublisher(), "publishing house");
	
	private TagActionCommand command;
	private String tag;

	private TagTypes(TagActionCommand command, String tag) {
		this.command = command;
		this.tag = tag;
	}

	public TagActionCommand getCommand() {
		return command;
	}

	public String getTag() {
		return tag;
	}

}
