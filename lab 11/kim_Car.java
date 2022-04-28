import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

public class kim_Car implements CarFunctions{
    private final String id;
    private final int fuelEconomyInMilesPerGallon;
    private final int fuelCapacityInGallons;
    private double currentFuelInGallons;

    public kim_Car(String id, int fuelEconomyInMilesPerGallon, int fuelCapacityInGallons, double currentFuelInGallons) {
        this.id = id;
        this.fuelEconomyInMilesPerGallon = fuelEconomyInMilesPerGallon;
        this.fuelCapacityInGallons = fuelCapacityInGallons;
        this.currentFuelInGallons = currentFuelInGallons;
    }

    public int getFuelEconomyInMilesPerGallon() {
        return fuelEconomyInMilesPerGallon;
    }
    
    public int getFuelCapacityInGallons() {
        return fuelCapacityInGallons;
    }

    public double getCurrentFuelInGallons() {
        return currentFuelInGallons;
    }

    public String getId() {
		return id;
	}

    public String toString() {
        return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
    }

    public void setCurrentFuelInGallons(double v) {
        currentFuelInGallons = v;
    }
}
