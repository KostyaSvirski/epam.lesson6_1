package by.svirski.lesson6_2.model.dao.command.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson6_2.model.dao.command.TagActionCommand;
import by.svirski.lesson6_2.model.entity.CustomBook;
import by.svirski.lesson6_2.model.exception.CustomCommandException;
import by.svirski.lesson6_2.util.validator.impl.ValidatorDateImpl;

public class TagDate implements TagActionCommand {

	private final static String FIND_DATE_SQL = "SELECT NameOfBook, Authors, Genre, DateOfPublish,"
			+ "PublishHouse FROM books WHERE DateOfPublish = ?";

	@Override
	public List<CustomBook> find(String parameters, Connection cn) throws CustomCommandException {
		PreparedStatement pr = null;
		ValidatorDateImpl validator = new ValidatorDateImpl();
		List<CustomBook> resultList = new ArrayList<CustomBook>();
		if (validator.validate(parameters)) {
			try {
				pr = cn.prepareStatement(FIND_DATE_SQL);
				pr.setString(1, parameters);
				ResultSet rs = pr.executeQuery();
				resultList = createResultList(rs);
			} catch (SQLException e) {
				throw new CustomCommandException("error in command" + e.getMessage());
			} finally {
				try {
					pr.close();
				} catch (SQLException e) {
					throw new CustomCommandException("error in closing resourse");
				}
			}	
		}
		return resultList;
	}

}
