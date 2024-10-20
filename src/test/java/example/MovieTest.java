package example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testGetTitle() {
        Movie movie = new Movie("Rembo", Movie.MovieType.REGULAR);
        assertEquals("Rembo", movie.getTitle());
    }

    @Test
    void testGetPriceCode() {
        Movie movie = new Movie("Rembo", Movie.MovieType.REGULAR);
        assertEquals(Movie.MovieType.REGULAR, movie.getPriceCode());
    }

    @Test
    void testEnumValues() {
        assertEquals(3, Movie.MovieType.values().length);
        assertEquals(Movie.MovieType.REGULAR, Movie.MovieType.valueOf("REGULAR"));
        assertEquals(Movie.MovieType.NEW_RELEASE, Movie.MovieType.valueOf("NEW_RELEASE"));
        assertEquals(Movie.MovieType.CHILDRENS, Movie.MovieType.valueOf("CHILDRENS"));
    }
}
