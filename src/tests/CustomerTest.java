import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerName() {
        String customerName = "Felix";
        Customer customer = new Customer(customerName);

        assertEquals(customerName, customer.getName());
    }

    @Test
    public void testEmptyCustomerName() {
        String customerName = "";
        Customer customer = new Customer(customerName);

        assertEquals(customerName, customer.getName());
    }

    @Test
    public void testEmptyRental() {
        Customer customer = new Customer("");

        String customerStatement = customer.statement();
        assertEquals(customerStatement.split("\n").length, 4);
    }

    @Test
    public void testFilledRental() {
        Customer customer = new Customer("");

        customer.addRental(new Rental(new Movie("", Movie.NEW_RELEASE), 30));

        String customerStatement = customer.statement();
        assertEquals(customerStatement.split("\n").length, 5);
    }
}
