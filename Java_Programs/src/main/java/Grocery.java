class Product {
    String name;
    String category;
    int price;
    int quantity;
    int bulkDiscount;
    int nonPerishableDiscount;

    public Product(String name, String category, int price, int quantity, int bulkDiscount, int nonPerishableDiscount) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.bulkDiscount = bulkDiscount;
        this.nonPerishableDiscount = nonPerishableDiscount;
    }

    public double getTotalPriceBeforeDiscount() {
        return price * quantity;
    }

    public double getDiscountedPrice() {
        double total = getTotalPriceBeforeDiscount();

        if (category.equalsIgnoreCase("Perishable") && quantity > 5) {
            total = total - (total * bulkDiscount / 100.0);
        } else if (category.equalsIgnoreCase("Non-Perishable") && total > 2000) {
            total = total - (total * nonPerishableDiscount / 100.0);
        }
        System.out.println(total);

        return total;
    }
}

public class Grocery {
    public static void main(String[] args) {
        Product[] products = {
                new Product("Apples", "Perishable", 100, 6, 10, 0),
                new Product("Rice (5kg bag)", "Non-Perishable", 500, 4, 0, 5),
                new Product("Milk (1 liter)", "Perishable", 50, 10, 5, 0)
        };

        double totalAmount = 0;
        double maxCost = 0;
        Product maxProduct = null;

        for (Product p : products) {
            double discountedPrice = p.getDiscountedPrice();
            totalAmount += discountedPrice;

            if (discountedPrice > maxCost) {
                maxCost = discountedPrice;
                maxProduct = p;
            }
        }

        System.out.println("Product with highest total cost after discount: " + maxProduct.name);
        System.out.println("Total amount payable after all discounts: Rs. " + totalAmount);
    }
}
