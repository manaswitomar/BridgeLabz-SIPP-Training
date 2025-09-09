import java.util.*;

class Movie {
    private String title;
    private double rating;
    private int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() { return title; }
    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") ⭐" + rating;
    }
}

public class TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", 8.8, 2010),
            new Movie("The Dark Knight", 9.0, 2008),
            new Movie("Avengers: Endgame", 8.4, 2019),
            new Movie("Interstellar", 8.6, 2014),
            new Movie("Dune", 8.3, 2021),
            new Movie("Oppenheimer", 8.9, 2023),
            new Movie("Spider-Man: No Way Home", 8.2, 2021),
            new Movie("The Batman", 7.9, 2022),
            new Movie("Tenet", 7.4, 2020)
        );

        System.out.println("=== Top 5 Trending Movies ===");

        movies.stream()
              .filter(m -> m.getRating() >= 7.5) 
              .sorted(Comparator
                      .comparingDouble(Movie::getRating).reversed() 
                      .thenComparing(Comparator.comparingInt(Movie::getReleaseYear).reversed())) 
              .limit(5) 
              .forEach(System.out::println);
    }
}
