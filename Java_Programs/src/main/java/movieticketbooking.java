
class bookshow {
    String MovieTitle;
    String tickettype;
    int Priceticket;
    int Quantity;
    int studentdisc;
    boolean Bulkdisc;

    public bookshow(String MovieTitle, String tickettype, int Priceticket, int Quantity, int studentdisc, boolean Bulkdisc) {
        this.MovieTitle = MovieTitle;

        this.tickettype = tickettype;
        this.Priceticket = Priceticket;
        this.Quantity = Quantity;
        this.studentdisc = studentdisc;
        this.Bulkdisc = Bulkdisc;

    }

    public double totalprice() {
        double total = Priceticket * Quantity;

        total = total - (total * studentdisc) / 100;

        if (Bulkdisc && Quantity > 5) {
            total = total - (total * 10) / 100;

        }

        return total;
    }
}


public class movieticketbooking
{
    public static void main(String[] args)
    {
        bookshow[] moviebooking={
                new bookshow("Avengers", "Regular", 200, 3, 10, false),
                new bookshow("Inception", "VIP", 500, 5, 0, true),
                new bookshow("The Matrix", "Premium", 300, 2, 15, false)
        };

        double totalprice=0;
        bookshow totalamount=null;
        double maxcost=0;

        for (bookshow bookmovie:moviebooking)
        {
            double cost=bookmovie.totalprice();
            totalprice=totalprice+cost;

            if(cost>maxcost)
            {
                maxcost=cost;
                totalamount=bookmovie;

            }
        }
        System.out.println("Movie with the highest total price after discounts: " + totalamount.MovieTitle);
        System.out.println("Total amount payable: Rs. " + totalprice);
    }
    }

