package Film;
import java.util.Scanner;
public class Archive {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int count = 0;
        for(int i = 0; i < 5; i++){
            System.out.printf("Film NO.%d\n", i + 1);
            System.out.println("Enter the name of the film");
            String name = sc1.nextLine();
            System.out.println("Enter the director of the film");
            String director = sc1.nextLine();
            System.out.println("Enter the time of the film");
            int time = sc2.nextInt();
            Film film = new Film(name, director, time);
            boolean flag = FilmList.addFilm(film);
            if(flag){
                System.out.println("Film added");
                count++;
            }
            else{
                System.out.println("Film not added.Max size is reached!");
            }
        }
        FilmList.display();
        System.out.println("Enter movie id:");
        String movieId = sc1.nextLine();
        if(FilmList.getFilm(movieId) == null){
            System.out.println("Film not found");
        }
        else{
            FilmList.removeFilm(movieId);
            System.out.println("Film removed");
            count--;
        }
        FilmList.display();
        System.out.println("Witch movie would you like to search?");
        String searchMovie = sc1.nextLine();
        Film[] myfilms = new Film[count];
        for(int i = 0; i < count; i++){
            if(myfilms[i].getName().equals(searchMovie)){
                System.out.println("Film found");
                System.out.println(myfilms[i].toString());
            }
        }
        
    }
}
