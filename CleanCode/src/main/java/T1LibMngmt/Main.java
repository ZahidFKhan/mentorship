package T1LibMngmt;

public class Main {

	public static void main(String[] args) {
		LibraryService libraryService = new LibraryService();

		Book book1 = BookFactory.createBook("BK001", "Effective Java");
		libraryService.addBook(book1);

		System.out.println(libraryService.checkOutBook("BK001", "USR001"));
		System.out.println(libraryService.returnBook("BK001"));

		libraryService.reserveBook("BK001", "USR002");
		System.out.println("Reservations: " + libraryService.getReservations("BK001"));

	}

}
