public class Line implements BasicShape{
    private double length;

    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}