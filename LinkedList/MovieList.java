class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev;
    Movie next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

public class MovieList {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Added at beginning: " + title);
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Added at end: " + title);
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie current = head;
        int index = 0;
        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(title, director, year, rating);
        } else {
            Movie newMovie = new Movie(title, director, year, rating);
            Movie prevNode = current.prev;
            newMovie.next = current;
            newMovie.prev = prevNode;
            if (prevNode != null) {
                prevNode.next = newMovie;
            } else {
                head = newMovie;
            }
            current.prev = newMovie;
            System.out.println("Added at position " + position + ": " + title);
        }
    }

    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Removed: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    public void searchByDirector(String director) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    public void searchByRating(double rating) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    public void displayForward() {
        System.out.println("\nMovies in Forward Order:");
        Movie current = head;
        while (current != null) {
            displayMovie(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        System.out.println("\nMovies in Reverse Order:");
        Movie current = tail;
        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }

    private void displayMovie(Movie movie) {
        System.out.println("Title: " + movie.title +
                ", Director: " + movie.director +
                ", Year: " + movie.year +
                ", Rating: " + movie.rating);
    }

    // For testing
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addAtEnd("Inception", "Christopher Nolan", 2010, 9.0);
        list.addAtBeginning("The Matrix", "Wachowskis", 1999, 8.7);
        list.addAtPosition(1, "Interstellar", "Christopher Nolan", 2014, 8.6);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.7);

        list.updateRating("Inception", 9.1);
        list.removeByTitle("The Matrix");

        list.displayForward();
    }
}
