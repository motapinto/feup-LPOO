import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider{

    List<House> houses = new ArrayList<House>();

    public City(List<House> houses_list) {
        houses = houses_list;
    }

    public void addHouse(House h) {
        houses.add(h);
    }

    public double sum() {
        double sum = 0;
        for (House house : houses)
            sum += house.getArea();
        return sum;
    }
}
