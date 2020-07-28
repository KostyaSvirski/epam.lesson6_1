package by.svirski.lesson6_1.model.dao.command.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson6_1.model.dao.command.TagActionCommand;
import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomCommandException;

public class TagDefault implements TagActionCommand {

	private static final String FIND_ALL_SQL = "SELECT NameOfBook, Authors, Genre, DateOfPublish,"
			+ "PublishHouse FROM books";

	@Override
	public List<CustomBook> find(String parameters, Connection cn) throws CustomCommandException {
		PreparedStatement pr= null;
		List<CustomBook> listOfBooks = new ArrayList<CustomBook>();
		try {
			pr = cn.prepareStatement(FIND_ALL_SQL);
			ResultSet rs = pr.executeQuery();
			listOfBooks = createResultList(rs);
		} catch (SQLException e) {
			throw new CustomCommandException("error in command " + e.getMessage());
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				throw new CustomCommandException("error in closing resourses");
			}
		}
		return listOfBooks;
	}

}
