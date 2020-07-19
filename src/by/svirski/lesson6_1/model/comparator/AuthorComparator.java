package by.svirski.lesson6_1.model.comparator;

import java.util.Comparator;

import by.svirski.lesson6_1.model.entity.CustomBook;

public class AuthorComparator implements Comparator<CustomBook>{

	@Override
	public int compare(CustomBook o1, CustomBook o2) {
		int arrLength;
		if (o1.getAuthors().length <= o2.getAuthors().length) {
			arrLength = o1.getAuthors().length;
		} else {
			arrLength = o2.getAuthors().length;
		}
		for (int i = 0; i < arrLength; i++) {
			if (o1.getAuthors()[i].compareTo(o2.getAuthors()[i]) == 1) {
				return 1;
			} else if (o1.getAuthors()[i].compareTo(o2.getAuthors()[i]) == -1) {
				return -1;
			}
		}
		return 0;
	}

}
