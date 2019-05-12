
public class Circle extends AShape {

    @Override
    public void area() {
        System.out.println("Circle area is: ");
    }

    @Override
    public void parameter () {
        System.out.println("Circle parameter is: ");
    }

    private String name;
    private double pi;

    public String getName() {
        return name;
    }

    public double getPi() {
        return pi;
    }
}
