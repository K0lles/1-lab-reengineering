package example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testGetDaysRented() {
        Movie movie = new Movie("Rembo", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 3);
        assertEquals(3, rental.getDaysRented());
    }

    @Test
    void testGetMovie() {
        Movie movie = new Movie("Rembo", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 3);
        assertEquals(movie, rental.getMovie());
        assertEquals("Rembo", rental.getMovie().getTitle());
    }
}
