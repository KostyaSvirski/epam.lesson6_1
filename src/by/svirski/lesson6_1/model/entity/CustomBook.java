package by.svirski.lesson6_1.model.entity;

import java.util.Arrays;
import java.util.Calendar;

public class CustomBook {
	private static int counterId = 0;

	private int bookId;
	private String bookName;
	private String[] authors;
	private String genre;
	private Calendar publishDate;
	private String publishingHouse;

	public CustomBook() {

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId() {
		counterId += 1;
		this.bookId = counterId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Calendar getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishHouse() {
		return publishingHouse;
	}

	public void setPublishHouse(String publishHouse) {
		this.publishingHouse = publishHouse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + bookId;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomBook other = (CustomBook) obj;
		if (!Arrays.equals(authors, other.authors)) {
			return false;
		}
		if (bookName == null) {
			if (other.bookName != null) {
				return false;
			}
		} else if (!bookName.equals(other.bookName)) {
			return false;
		}
		if (genre == null) {
			if (other.genre != null) {
				return false;
			}
		} else if (!genre.equals(other.genre)) {
			return false;
		}
		if (publishDate == null) {
			if (other.publishDate != null) {
				return false;
			}
		} else if (publishDate.get(1) != other.publishDate.get(1) || publishDate.get(2) != other.publishDate.get(2)
				|| publishDate.get(3) != other.publishDate.get(3)) {
			return false;
		}
		if (publishingHouse == null) {
			if (other.publishingHouse != null) {
				return false;
			}
		} else if (!publishingHouse.equals(other.publishingHouse)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomBook [bookId=");
		builder.append(bookId);
		builder.append(", bookName=");
		builder.append(bookName);
		builder.append(", authors=");
		builder.append(Arrays.toString(authors));
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", publishingHouse=");
		builder.append(publishingHouse);
		builder.append("]");
		return builder.toString();
	}
}
