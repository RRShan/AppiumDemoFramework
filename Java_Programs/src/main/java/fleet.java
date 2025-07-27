import java.util.*;

class Vehicle {
    String vehicleID;
    String vehicleType;
    String serviceType;
    int distanceTravelled;
    int fuelCostPerKm;
    int maintenanceCost;
    int tollCharges;
    String discountOrSurcharge;

    public Vehicle(String vehicleID, String vehicleType, String serviceType, int distanceTravelled,
                   int fuelCostPerKm, int maintenanceCost, int tollCharges, String discountOrSurcharge) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.serviceType = serviceType;
        this.distanceTravelled = distanceTravelled;
        this.fuelCostPerKm = fuelCostPerKm;
        this.maintenanceCost = maintenanceCost;
        this.tollCharges = tollCharges;
        this.discountOrSurcharge = discountOrSurcharge;
    }

    public double calculateTotalCost() {
        double baseCost = (distanceTravelled * fuelCostPerKm) + maintenanceCost;

        switch (serviceType) {
            case "Cargo Transport":
                return baseCost + tollCharges;

            case "Passenger Transport":
                double discount = 0.05; // 5% discount
                return baseCost - (baseCost * discount);

            case "Taxi Service":
                int surchargePerKm = 2;
                return baseCost + (surchargePerKm * distanceTravelled);

            default:
                return baseCost;
        }
    }

    public double getAverageCostPerKm() {
        return calculateTotalCost() / distanceTravelled;
    }
}

public class fleet {
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("T001", "Truck", "Cargo Transport", 700, 10, 3000, 700, "N/A"),
                new Vehicle("V001", "Van", "Passenger Transport", 1200, 8, 1500, 0, "Route Discount: 5%"),
                new Vehicle("C001", "Car", "Taxi Service", 400, 12, 800, 0, "Per-Km Surcharge: Rs. 2")
        );

        Map<String, Double> serviceCostSummary = new HashMap<>();
        Map<String, Double> serviceDistanceSummary = new HashMap<>();

        System.out.println("Vehicle-wise Cost Details:");
        for (Vehicle v : vehicles) {
            double totalCost = v.calculateTotalCost();
            System.out.println(" - Vehicle ID: " + v.vehicleID + ", Service: " + v.serviceType +
                    ", Total Cost: Rs. " + totalCost);

            // Accumulate cost and distance per service type
            serviceCostSummary.put(v.serviceType,
                    serviceCostSummary.getOrDefault(v.serviceType, 0.0) + totalCost);
            serviceDistanceSummary.put(v.serviceType,
                    serviceDistanceSummary.getOrDefault(v.serviceType, 0.0) + v.distanceTravelled);
        }

        System.out.println("\nFleet-level Summary (Grouped by Service Type):");
        for (String service : serviceCostSummary.keySet()) {
            System.out.println(" - " + service + ": Rs. " + serviceCostSummary.get(service));
        }

        // Find most cost-efficient service (lowest avg cost per km)
        String bestService = null;
        double lowestAvgCost = Double.MAX_VALUE;

        for (String service : serviceCostSummary.keySet()) {
            double totalCost = serviceCostSummary.get(service);
            double totalKm = serviceDistanceSummary.get(service);
            double avgCost = totalCost / totalKm;

            if (avgCost < lowestAvgCost) {
                lowestAvgCost = avgCost;
                bestService = service;
            }
        }

        System.out.println("\nMost Cost-Efficient Service: " + bestService + " (Avg Cost per Km: Rs. " + lowestAvgCost + ")");
    }
}
