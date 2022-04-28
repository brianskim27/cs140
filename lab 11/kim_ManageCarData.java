import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

public class kim_ManageCarData implements ManageCarDataFunctions {
    private final ArrayList<CarFunctions> carList;
    private final PriorityQueue<CarFunctions> carListByTotalRange;
    private final PriorityQueue<CarFunctions> carListByRemainingRange;

    public kim_ManageCarData() {
        carList = new ArrayList<>();
        carListByTotalRange = new PriorityQueue<>(new TotalRangeComparator());
        carListByRemainingRange = new PriorityQueue<>(new RemainingRangeComparator());
    }

    public void readData(String filename) {
        try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;
            while((inn = input.readLine()) != null) {
                String[] tokens = inn.split("\t");
                kim_Car car = new kim_Car(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
                carList.add(car);
                carListByTotalRange.add(car);
                carListByRemainingRange.add(car);
            }
            input.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<CarFunctions> getCarList() {
        ArrayList<CarFunctions> returnList = new ArrayList<>();
        for(CarFunctions c: carList) {
            returnList.add(c);
        }
        return returnList;
    }

    public PriorityQueue<CarFunctions> getCarListByTotalRange() {
        PriorityQueue<CarFunctions> returnQueue = new PriorityQueue<>(new TotalRangeComparator());
        for(CarFunctions c: carListByTotalRange) {
            returnQueue.add(c);
        }
        return returnQueue;
    }

    public ArrayList<CarFunctions> getCarListByTotalRangeUsingIterator() {
        ArrayList<CarFunctions> returnList = new ArrayList<>();
        Iterator<CarFunctions> iter = carListByTotalRange.iterator();
        while(iter.hasNext()) {
            returnList.add(iter.next());
        }
        return returnList;
    }

    public PriorityQueue<CarFunctions> getCarListByRemainingRange() {
        PriorityQueue<CarFunctions> returnQueue = new PriorityQueue<>(new RemainingRangeComparator());
        for(CarFunctions c: carListByRemainingRange) {
            returnQueue.add(c);
        }
        return returnQueue;
    }

    public ArrayList<CarFunctions> getCarListByRemainingRangeUsingIterator() {
        ArrayList<CarFunctions> returnList = new ArrayList<>();
        Iterator<CarFunctions> iter = carListByRemainingRange.iterator();
        while(iter.hasNext()) {
            returnList.add(iter.next());
        }
        return returnList;
    }

    public ArrayList<String> getCarListByTotalRangeViaPoll(double minTotalRange, double maxTotalRange) {
        ArrayList<String> returnList = new ArrayList<>();
        while(!carListByTotalRange.isEmpty()) {
            CarFunctions current = carListByTotalRange.poll();
            
            if(current.getTotalRangeInMiles() > minTotalRange && current.getTotalRangeInMiles() < maxTotalRange) {
                String currentString = current.toString();
                currentString += "\t" + carList.indexOf(current);
                
                for(int i = 0; i < carList.size(); i++) {
                    if(current.getFuelEconomyInMilesPerGallon() == carList.get(i).getFuelEconomyInMilesPerGallon()) {
                        currentString += "\t" + i;
                    }
                }
                returnList.add(currentString);
            }
        }
        for(CarFunctions c : carList)
            carListByTotalRange.add(c);
        return returnList;
    }

    public ArrayList<String> getCarListByRemainingRangeViaPoll(double minRemainingRange, double maxRemainingRange) {
        ArrayList<String> returnList = new ArrayList<>();
        while(!carListByRemainingRange.isEmpty()) {
            CarFunctions current = carListByRemainingRange.poll();
            
            if(current.getRemainingRangeInMiles() > minRemainingRange && current.getRemainingRangeInMiles() < maxRemainingRange) {
                String currentString = current.toString();
                currentString += "\t" + carList.indexOf(current);
                
                for(int i = 0; i < carList.size(); i++) {
                    if(current.getFuelEconomyInMilesPerGallon() == carList.get(i).getFuelEconomyInMilesPerGallon()) {
                        currentString += "\t" + i;
                    }
                }
                returnList.add(currentString);
            }
        }
        for(CarFunctions c: carList) {
            carListByRemainingRange.add(c);
        }
        return returnList;
    }
}