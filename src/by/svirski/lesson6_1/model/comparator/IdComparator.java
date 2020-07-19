package by.svirski.lesson6_1.model.comparator;

import java.util.Comparator;

import by.svirski.lesson6_1.model.entity.CustomBook;

public class IdComparator implements Comparator<CustomBook>{

	@Override
	public int compare(CustomBook o1, CustomBook o2) {
		if(o1.getBookId() < o2.getBookId()) {
			return -1;
		} else if(o1.getBookId() > o2.getBookId()) {
			return 1;
		}
		return 0;
	}

}
