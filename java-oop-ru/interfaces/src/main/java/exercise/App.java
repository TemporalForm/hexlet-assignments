package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App{
    public static List<String> buildApartmentsList(List<Home> houses, int countToDisplay) {
        houses.sort((house1, house2) -> Double.compare(house1.getArea(), house2.getArea()));
        if (countToDisplay > houses.size()) {
            countToDisplay = houses.size();
        }
        List<String> housesAsStrings = new ArrayList<>();
        for (int i = 0; i < countToDisplay; i++) {
            housesAsStrings.add(houses.get(i).toString());
        };
        return housesAsStrings;
    }
}
// END
