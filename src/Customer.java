
import java.lang.*;
import java.util.*;

class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer (String newName){
        name = newName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName (){
        return name;
    }


    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints += rentals.size();
        for (Rental r : rentals) {
            if (r.getMovie().getPriceCode() == Movie.NEW_RELEASE && r.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += amountFor(each);
        }
        return totalAmount;
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
            case Movie.CHILDREN
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental nextRental : rentals) {
            //show figures for this rental
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append("\t")
                    .append(each.getDaysRented())
                    .append("\t")
                    .append(String.valueOf(amountFor(nextRental)))
                    .append("\n");
        }
        //add footer lines
        result.append("Amount owed is ")
                .append(String.valueOf(getTotalAmount()))
                .append("\n");
        result.append("You earned ")
                .append(getFrequentRenterPoints())
                .append(" frequent renter points");
        return result.toString();
    }



}
    