package by.svirski.lesson6_1.model.creator;

import by.svirski.lesson6_1.model.exception.CustomCreationException;

public interface CustomCreator<T> {
	T create(String... parameters) throws CustomCreationException;
}
