import java.util.*;

class Show {
    String title;
    String type;
    String ticketType;
    int pricePerTicket;
    int quantity;
    String discountDetails;

    public Show(String title, String type, String ticketType, int pricePerTicket, int quantity, String discountDetails) {
        this.title = title;
        this.type = type;
        this.ticketType = ticketType;
        this.pricePerTicket = pricePerTicket;
        this.quantity = quantity;
        this.discountDetails = discountDetails;
    }

    public double calculateTotalCost() {
        double base = pricePerTicket * quantity;

        switch (type) {
            case "Movie":
                if (discountDetails.contains("Student Discount")) {
                    base -= base * 0.10;
                }
                if (discountDetails.contains("Bulk Discount") && quantity >= 5) {
                    base -= base * 0.10;
                }
                break;

            case "Concert":
                if (discountDetails.contains("Event Handling Surcharge")) {
                    base += base * 0.05;
                }
                break;

            case "Theatre":
                if (discountDetails.contains("Premium Surcharge")) {
                    base += 100 * quantity;
                }
                if (discountDetails.contains("Senior Citizen Discount")) {
                    base -= base * 0.20;
                }
                break;
        }

        return base;
    }
}

public class Multishow {
    public static void main(String[] args) {
        List<Show> shows = Arrays.asList(
                new Show("Avengers", "Movie", "Regular", 200, 3, "Student Discount: 10%"),
                new Show("Inception", "Movie", "VIP", 500, 5, "Bulk Discount: Yes"),
                new Show("Live Music Fest", "Concert", "Standard", 1000, 4, "Event Handling Surcharge: 5%"),
                new Show("Hamlet", "Theatre", "Premium", 300, 2, "Senior Citizen Discount: 20%; Premium Surcharge: Rs. 100")
        );

        double totalRevenue = 0;
        double maxRevenue = 0;
        String highestRevenueShow = null;

        System.out.println("Show-wise Total Cost:");

        for (Show s : shows) {
            double cost = s.calculateTotalCost();
            totalRevenue += cost;

            System.out.println(" - " + s.title + ": Rs. " + cost);

            if (cost > maxRevenue) {
                maxRevenue = cost;
                highestRevenueShow = s.title;
            }
        }

        System.out.println("\nTotal Revenue: Rs. " + totalRevenue);
        System.out.println("Highest Revenue Show: " + highestRevenueShow + " (Rs. " + maxRevenue + ")");
    }
}
