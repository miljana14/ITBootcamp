package domaciSreda;

public class Triangle extends Shape{
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double circumference() {
        return a+b+c;
    }

    @Override
    public double area() {
        double s = (a+b+c)/2;
        return Math.sqrt(s *(s-a)*(s-b)*(s-c));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
