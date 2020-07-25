package by.svirski.lesson6_1.model.dao.command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson6_1.model.entity.CustomBook;
import by.svirski.lesson6_1.model.exception.CustomDaoException;
import by.svirski.lesson6_1.model.exception.CustomParseException;
import by.svirski.lesson6_1.util.parser.impl.ParserDateImpl;

public interface TagActionCommand {
	
	List<CustomBook> find(String parameters);
	
	default List<CustomBook> createResultList(ResultSet rs) throws CustomDaoException {
		ParserDateImpl parser = new ParserDateImpl();
		List<CustomBook> listOfBooks = new ArrayList<CustomBook>();
		try {
			String[] parameters = new String[5];
			while (rs.next()) {
				for (int i = 0; i < parameters.length; i++) {
					parameters[i] = rs.getString(i + 1);
				}
				try {
					listOfBooks.add(new CustomBook(parameters[0], parameters[1].split(" "), parameters[2],
							parser.parse(parameters[3]), parameters[4]));
				} catch (CustomParseException e) {
					throw new CustomDaoException("error in parsing");
				}
			}
		} catch (SQLException e) {
			throw new CustomDaoException("error in reading result set" + e.getMessage());
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new CustomDaoException("error in closing resourse" + e.getMessage());
			}
		}
		return listOfBooks;
	}
}