
import java.lang.*;
import java.util.*;

class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer (String newname){
        name = newname;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName (){
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental nextRental : rentals) {
            double thisAmount = 0;
            //determine amounts for nextRental line
            thisAmount = amountFor(nextRental);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((nextRental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && nextRental.getDaysRented() > 1) {
                frequentRenterPoints ++;
            }
            //show figures for this rental
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append("\t")
                    .append(each.getDaysRented())
                    .append("\t")
                    .append(String.valueOf(thisAmount))
                    .append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ")
                .append(String.valueOf(totalAmount))
                .append("\n");
        result.append("You earned ")
                .append(String.valueOf(frequentRenterPoints))
                .append(" frequent renter points");
        return result.toString();
    }

    private double amountFor(Rental rental) {
        double thisAmount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

}
    