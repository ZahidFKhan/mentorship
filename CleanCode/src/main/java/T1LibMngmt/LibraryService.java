package T1LibMngmt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryService {
	private final Map<String, Book> books = new ConcurrentHashMap<>();
	private final Map<String, List<String>> reservations = new HashMap<>();

	public void addBook(Book book) {
		books.put(book.getId(), book);
	}

	public String checkOutBook(String bookId, String userId) {
		Book book = books.get(bookId);
		if (book == null) {
			return "Book not found.";
		}
		if (!book.isAvailable()) {
			return "Book is currently unavailable. Reservation suggested.";
		}
		book.checkOut(userId);
		return "Book checked out successfully to " + userId;
	}

	public String returnBook(String bookId) {
		Book book = books.get(bookId);
		if (book == null || book.isAvailable()) {
			return "Invalid return attempt. Book was not checked out.";
		}
		book.returnBook();
		return "Book returned successfully.";
	}

	public void reserveBook(String bookId, String userId) {
		reservations.computeIfAbsent(bookId, k -> new ArrayList<>()).add(userId);
	}

	public List<String> getReservations(String bookId) {
		return reservations.getOrDefault(bookId, Collections.emptyList());
	}
}
