package LibraryBookManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanL = new Scanner(System.in);
        Scanner scanD = new Scanner(System.in);

        String title;
        String author;
        int year;
        Book book;

        System.out.println("Enter information for Fiction Books");
        for (int i = 0; i < LibraryCatalog.MAX_BOOKS_PER_SECTION; i++) {
            System.out.print(" Title: ");
            title = scanL.nextLine();
            System.out.print("Author: ");
            author = scanL.nextLine();
            System.out.print("  Year: ");
            year = scanD.nextInt();
            book = new Book(title, author, year);
            if (LibraryCatalog.addBook(book, 0)) {
                System.out.println("Book added successfully");
            } else {
                System.out.println("The Category is Full.");
            }
        }

        System.out.println("Enter information for NonFiction Books");
        for (int i = 0; i < LibraryCatalog.MAX_BOOKS_PER_SECTION; i++) {
            System.out.print(" Title: ");
            title = scanL.nextLine();
            System.out.print("Author: ");
            author = scanL.nextLine();
            System.out.print("  Year: ");
            year = scanD.nextInt();
            book = new Book(title, author, year);
            if (LibraryCatalog.addBook(book, 1)) {
                System.out.println("Book added successfully");
            } else {
                System.out.println("The Category is Full.");
            }
        }

        System.out.println("----------------");

        LibraryCatalog.displayBooks();

        System.out.println("----------------");

        System.out.print("ID to remove: ");
        String id = scanL.nextLine();
        System.out.print("Which section? (0/1): ");
        int section = scanD.nextInt();
        LibraryCatalog.removeBook(id , section);

        System.out.println("----------------");

        System.out.println("What is the title? What is the Genre (0/1)? ");
        String[] search = scanL.nextLine().split(" ");
        System.out.println(LibraryCatalog.getBook(search[0] , Integer.parseInt(search[1])).toString());

        System.out.println("----------------");

        System.out.println("Oldest Fiction Book: ");
        System.out.println(LibraryCatalog.getOldestBook(0));

        System.out.println("Oldest nonFiction Book: ");
        System.out.println(LibraryCatalog.getOldestBook(1));
    }
}
