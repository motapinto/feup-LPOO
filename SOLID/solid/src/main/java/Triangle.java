public class Triangle implements AreaShape {
    private double base, height;

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public Triangle(double b, double h) {
        base = b;
        height = h;
    }

    @Override
    public double getArea() {
        return base * height / 2;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
