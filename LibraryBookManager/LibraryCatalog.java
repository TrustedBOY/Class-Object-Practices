package LibraryBookManager;

public class LibraryCatalog {

    public static final int MAX_BOOKS_PER_SECTION = 3;
    static Book[][] books = new Book[2][MAX_BOOKS_PER_SECTION]; // Fiction - Non Fiction
    private static int totalFictionBookCount = 0;
    private static int totalnonFictionBookCount = 0;

    public static boolean addBook(Book book, int section) {
        if (section == 0){// Fiction
            if (totalFictionBookCount < MAX_BOOKS_PER_SECTION){
                books[0][totalFictionBookCount++] = book;
                System.out.println("Added Fiction Book " + book.getTitle());
                return true;
            }
            System.out.println("This Category is Already Full.");
            return false;
        }
        else if (section == 1){//nonFiction
            if(totalnonFictionBookCount < MAX_BOOKS_PER_SECTION){
                books[1][totalnonFictionBookCount++] = book;
                System.out.println("Added Non Fiction Book " + book.getTitle());
                return true;
            }
            System.out.println("This Category is Already Full.");
            return false;
        }
        System.out.println("This Category does not Exist.");
        return false;
    }

    public static boolean removeBook(String bookID, int section){
        if( removeBookRecursively(bookID ,section,0)){
            System.out.println("Removed Book " + bookID);
            return true;
        }
        System.out.println("Book does not exist: " + bookID);
        return false;
    }
    private static boolean removeBookRecursively(String bookID, int section, int index){
        if (index >= books[section].length) return false;

        if(books[section][index].getBookID().equals(bookID)){
            for(int i = index; i < (section==0?totalFictionBookCount-1:totalnonFictionBookCount-1) ; i ++){
                books[section][i] = books[section][i+1];
            }
            books[section][(section==0?totalFictionBookCount-1:totalnonFictionBookCount-1)] = null;
            switch(section){
                case 0-> totalFictionBookCount --;
                case 1-> totalnonFictionBookCount --;
            }
            return true;
        }
        return removeBookRecursively(bookID ,section,index+1);
    }

    public static Book getBook(String title, int section){
        return getBookRecursively(title , section,0);
    }
    private static Book getBookRecursively(String title, int section, int index){
        if (index < (section==0? totalFictionBookCount:totalnonFictionBookCount) ){
            if (books[section][index].getTitle().equals(title)){
                return books[section][index];
            }
            return getBookRecursively(title,section,index+1);
        }
        return null;
    }

    public static Book getOldestBook(int section){
        Book oldestBook = books[section][0];
        return getOldestBookRecursively(section, 1 , oldestBook);
    }
    private static Book getOldestBookRecursively(int section, int index, Book oldestBook){
        if(index < (section==0? totalFictionBookCount:totalnonFictionBookCount) ){
            if (books[section][index].getYear_of_publication() < oldestBook.getYear_of_publication()){
                oldestBook = books[section][index];
            }
            return getOldestBookRecursively(section, index+1, oldestBook);
        }
        return oldestBook;
    }

    public static void displayBooks(){
        for (int i = 0; i < books.length; i++){
            System.out.println((i==0?"\nFiction: ":"\nNonFiction: "));
            displayBooksRecursively(i , 0);
        }
    }
    private static void displayBooksRecursively(int i,int j){
        if(j < (i==0? totalFictionBookCount:totalnonFictionBookCount) ){
            System.out.println(books[i][j].toString() + "\n--------------------" );
            displayBooksRecursively(i, j+1);
        }
    }


}
