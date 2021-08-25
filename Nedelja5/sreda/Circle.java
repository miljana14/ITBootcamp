package domaciSreda;

public class Circle extends Shape{
    private double r;

    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double circumference() {
        return 2*r*Math.PI;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(r,2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
