package LibraryBookManager;

public class Book {

    private String bookID;
    private String title;
    private String author;
    private int year_of_publication;
    private static int last_used_ID = 100;

    public Book(String title, String author, int year_of_publication) {
        this.bookID = Integer.toString(++last_used_ID);
        this.title = title;
        this.author = author;
        this.year_of_publication = year_of_publication;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    @Override
    public String toString() {
        return    " Title = " + title +
                "\nBookID = " + bookID +
                "\nAuthor = " + author +
                "\n Year  = " + year_of_publication;
    }
}
