public class Rectangle implements AreaShape {

    private double width, height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}