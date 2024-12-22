package Film;

public class FilmList {
    public static final int MAX_SIZE = 4;
    private static Film[] myFilms = new Film[MAX_SIZE];
    private static int count = 0;
    public FilmList(){

    }
    public static boolean addFilm(Film film){
        if(count >= MAX_SIZE){
            return false;
        }
        else{
            myFilms[count++] = film;
            return true;
        }
    }
    public static boolean removeFilm(String name){
        for(int i = 0; i < count; i++){
            if(myFilms[i].getArchiveId() == Integer.parseInt(name)){
                myFilms[i] = myFilms[count-- - 1];
                return true;
            }
        }
        return false;
    }
    public static Film getFilm(String name){
        for(int i = 0; i < count; i++){
            if(myFilms[i].getName() == name){
                return myFilms[i];
            }
        }
        return null;
    }
    public static Film[] getAll(){
        return myFilms;
    }
    public static Film getLongestFilm(){
        int max = 0;
        for(int i = 0; i < count; i++){
            if(myFilms[i].getTime() > myFilms[max].getTime())
                max = i;
        }
        return myFilms[max];
    }
    public static void display(){
        for(int i = 0; i < count; i++){
            System.out.println(myFilms[i].toString());
        }
    }
}
