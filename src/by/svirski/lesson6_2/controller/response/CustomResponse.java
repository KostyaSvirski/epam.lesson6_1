package by.svirski.lesson6_2.controller.response;

import java.util.List;

import by.svirski.lesson6_2.model.entity.CustomBook;

public class CustomResponse {
	
	private List<CustomBook> sortedList;
	private List<CustomBook> listFound;
	private boolean isExecuted;
	private boolean isError;

	public CustomResponse() {
		sortedList = null;
		listFound = null;
		isExecuted = false;
		isError = false;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public void setSortedList(List<CustomBook> sortedList) {
		this.sortedList = sortedList;
	}

	public void setListFound(List<CustomBook> listFound) {
		this.listFound = listFound;
	}

	public void setResultOfExecution(boolean resultOfCommand) {
		this.isExecuted = resultOfCommand;
	}
	
	public boolean getResultOfExecution() {
		return isExecuted;
	}
	
	public boolean getError() {
		return isError;
	}

	public List<CustomBook> getSortedList() {
		return sortedList;
	}
	
	public List<CustomBook> getListFound() {
		return listFound;
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomResponse [");
		if (sortedList != null) {
			builder.append(" sortedList=");
			builder.append(sortedList);
		}
		if (listFound != null) {
			builder.append(" listFound=");
			builder.append(listFound);
		}
		if (isExecuted != false) {
			builder.append(" resultOfCommand=");
			builder.append(isExecuted);
		}
		if(isError != false) {
			builder.append(" Error!");
		}
		builder.append("]");
		return builder.toString();
	}

}
