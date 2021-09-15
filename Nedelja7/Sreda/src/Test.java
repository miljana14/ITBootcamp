import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSql;
import rs.itbootcamp.dao.MealDao;
import rs.itbootcamp.dao.MealDaoSql;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.util.Scanner;

public class Test {
    private static FoodModel userNewFood(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite id: ");
        int id = sc.nextInt();
        System.out.println("Unesite name: ");
        String name = sc.next();
        System.out.println("Unesite kcal: ");
        double kcal = sc.nextDouble();
        System.out.println("Unesite proteine: ");
        double proteins = sc.nextDouble();
        System.out.println("Unesite UH: ");
        double carbs = sc.nextDouble();
        System.out.println("Unesite masti: ");
        double fats = sc.nextDouble();
        return new FoodModel(id,name,kcal,proteins,carbs,fats);
    }
    private static MealModel userNewMeal(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite id: ");
        int id = sc.nextInt();
        System.out.println("Unesite name: ");
        String name = sc.next();
        System.out.println("Unesite desc: ");
        String desc = sc.next();
        System.out.println("Unesite difficulty: ");
        String difficulty = sc.next();
        return new MealModel(id, name, desc, difficulty);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDao fd = new FoodDaoSql();
        MealDao md = new MealDaoSql();

        String menu = """
                0. Exit
                1. Dodaj u tabelu Food
                2. Prikazi tabelu Food
                3. Dodaj u tabelu MealFood
                4. Izbrisi iz tabele Food
                5. Update Food (unesite postojeci id)
                6. Prikazi jedan element iz tabele Food(po id-ju)
                7. Dodaj u tabelu Meal
                8. Izbrisi iz tabele Meal
                9. Update Meal (unesite postojeci id)
                10. Prikazi jedan element iz tabele Meal(po id-ju)
                11. Prikazi tabelu Meal
                12. Prikazi imena Food-a koji se nalaze u tabeli MealFood po meal id-ju
                13. Prikazi sve iz Food-a koji se nalaze u tabeli MealFood po meal id-ju
                """;

        int choice = 5;
        while(choice != 0){
            System.out.println(menu);
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    break;
                case 1:
                    fd.insert(userNewFood());
                    break;
                case 2:
                    System.out.println(fd.getAllFood());
                    break;
                case 3:
                    System.out.println("Insert meal id, food id, mass:");
                    int mealId = sc.nextInt();
                    int foodId = sc.nextInt();
                    double mass = sc.nextDouble();
                    fd.addToMeal(mealId, foodId,mass);
                    break;
                case 4:
                    System.out.println("Insert food id:");
                    int id = sc.nextInt();
                    fd.delete(id);
                    break;
                case 5:
                    fd.update(userNewFood());
                    break;
                case 6:
                    System.out.println("Insert food id:");
                    int fId = sc.nextInt();
                    System.out.println(fd.getFood(fId));
                    break;
                case 7:
                    md.insert(userNewMeal());
                    break;
                case 8:
                    System.out.println("Insert meal id:");
                    int mId = sc.nextInt();
                    md.delete(mId);
                    break;
                case 9:
                    md.update(userNewMeal());
                    break;
                case 10:
                    System.out.println("Insert meal id:");
                    int meId = sc.nextInt();
                    System.out.println(md.getMeal(meId));
                    break;
                case 11:
                    System.out.println(md.getAllMeals());
                    break;
                case 12:
                    System.out.println("Insert meal id:");
                    int maId = sc.nextInt();
                    System.out.println(md.getFoodMealNames(maId));
                    break;
                case 13:
                    System.out.println("Insert meal id:");
                    int mlId = sc.nextInt();
                    System.out.println(md.getFoodMeal(mlId));
                    break;
            }
        }

    }
}
