
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
                    .append(String.valueOf(nextRental.getCharge()))
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
    