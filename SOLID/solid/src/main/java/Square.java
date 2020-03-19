public class Square implements AreaShape {
    private double side;

    public Square(double s) {
        side = s;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}