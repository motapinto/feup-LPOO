import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider {
    private List<HasArea> elems = new ArrayList<>();

    public void addElem(HasArea elem) {
        elems.add(elem);
    }

    public double sum() {
        double sum = 0;
        for (HasArea elem: elems) {
            sum += elem.getArea();
        }
        return sum;
    }
}