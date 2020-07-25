package by.svirski.lesson6_1.model.dao.provider;

import by.svirski.lesson6_1.model.dao.command.TagActionCommand;
import by.svirski.lesson6_1.model.dao.command.TagDefault;
import by.svirski.lesson6_1.model.dao.command.TagTypes;

public class TagProvider {
	
	public static TagActionCommand defineTag(String tagToFind) {
		TagTypes[] allTags = TagTypes.values();
		for(TagTypes tag : allTags) {
			if(tag.getTag().equalsIgnoreCase(tagToFind)) {
				return tag.getCommand();
			}
		}
		return new TagDefault();
	}
}