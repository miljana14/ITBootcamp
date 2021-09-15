package rs.itbootcamp.model;

public class FoodModel {
    private int food_id;
    private String food_name;
    private double kcal, proteins, carbohydrates, food_fat;

    public FoodModel(int food_id, String food_name, double kcal, double proteins, double carbohydrates, double food_fat) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.food_fat = food_fat;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFood_fat() {
        return food_fat;
    }

    public void setFood_fat(double food_fat) {
        this.food_fat = food_fat;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "food_id=" + food_id +
                ", food_name='" + food_name + '\'' +
                ", kcal=" + kcal +
                ", proteins=" + proteins +
                ", carbohydrates=" + carbohydrates +
                ", food_fat=" + food_fat +
                '}';
    }
}
