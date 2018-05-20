import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void testMovieConstructorTitle() {
        String movieName = "Schulzeit Squad";
        Movie movie = new Movie(movieName, Movie.NEW_RELEASE);

        assertEquals(movie.getTitle(), movieName);
    }

    @Test
    public void testMovieConstructorPrice() {
        int[] priceCodes = {Movie.REGULAR, Movie.NEW_RELEASE, Movie.CHILDREN};

        for (int priceCode : priceCodes) {
            Movie movie = new Movie("", priceCode);
            assertEquals(priceCode, movie.getPrice().getPriceCode());
        }
    }

    @Test
    public void testSetMoviePrice() {
        int[] priceCodes = {Movie.REGULAR, Movie.NEW_RELEASE, Movie.CHILDREN};

        Movie movie = new Movie("", Movie.REGULAR);

        for (int priceCode : priceCodes) {
            movie.setPriceCode(priceCode);
            assertEquals(priceCode, movie.getPrice().getPriceCode());
        }
    }

}
