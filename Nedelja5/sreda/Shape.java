package domaciSreda;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double circumference();

    public abstract double area();

    @Override
    public String toString() {
        return "Shape: " + name + "\nCircumference: " + circumference() + "\nArea: " + area() + "\n--------------------------------";
    }


}
