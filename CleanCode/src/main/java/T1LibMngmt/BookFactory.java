package T1LibMngmt;

public class BookFactory {
	
	public static Book createBook(String id, String title) {
        return new Book(id, title);
    }
}
