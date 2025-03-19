package T1LibMngmt;

public class Book {
	private final String id;
	private final String title;
	private boolean isAvailable;
	private String borrowedBy;

	public Book(String id, String title) {
		this.id = id;
		this.title = title;
		this.isAvailable = true;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public String getBorrowedBy() {
		return borrowedBy;
	}

	public void checkOut(String userId) {
		this.isAvailable = false;
		this.borrowedBy = userId;
	}

	public void returnBook() {
		this.isAvailable = true;
		this.borrowedBy = null;
	}
}
