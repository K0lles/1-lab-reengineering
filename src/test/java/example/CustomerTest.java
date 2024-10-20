package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        // Створимо фільми
        Movie rembo = new Movie("Rembo", Movie.MovieType.REGULAR);
        Movie lotr = new Movie("Lord of the Rings", Movie.MovieType.NEW_RELEASE);
        Movie harryPotter = new Movie("Harry Potter", Movie.MovieType.CHILDRENS);

        // Створимо прокати фільмів
        Rental rental1 = new Rental(rembo, 1);
        Rental rental2 = new Rental(lotr, 4);
        Rental rental3 = new Rental(harryPotter, 5);

        // Створимо клієнта з прокатами
        customer = new Customer("John Doe", List.of(rental1, rental2, rental3));
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testStatement() {
        String expectedStatement = 
                "Rental Record for John Doe\n" +
                "\tRembo\t2.0\n" +
                "\tLord of the Rings\t12.0\n" +
                "\tHarry Potter\t4.5\n" +
                "Amount owed is 18.5\n" +
                "You earned 4 frequent renter points";
        
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    void testRegularMovieWithMoreThanTwoDays() {
        Movie movie = new Movie("Some Regular Movie", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 5);
        Customer customer = new Customer("Jane Doe", List.of(rental));

        String expectedStatement = "Rental Record for Jane Doe\n" +
                "\tSome Regular Movie\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    void testChildrensMovieWithMoreThanThreeDays() {
        Movie movie = new Movie("Some Children's Movie", Movie.MovieType.CHILDRENS);
        Rental rental = new Rental(movie, 5);
        Customer customer = new Customer("Jane Doe", List.of(rental));

        String expectedStatement = "Rental Record for Jane Doe\n" +
                "\tSome Children's Movie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    void testNewReleaseMovieWithTwoDays() {
        Movie movie = new Movie("Some New Release", Movie.MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("Jane Doe", List.of(rental));

        String expectedStatement = "Rental Record for Jane Doe\n" +
                "\tSome New Release\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";

        assertEquals(expectedStatement, customer.statement());
    }
}
