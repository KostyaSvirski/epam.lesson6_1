package by.svirski.lesson6_1.model.comparator;

import java.util.Comparator;

import by.svirski.lesson6_1.model.entity.CustomBook;

public class GenreComparator implements Comparator<CustomBook> {

	@Override
	public int compare(CustomBook o1, CustomBook o2) {
		return o1.getGenre().compareTo(o2.getGenre());
	}

}
