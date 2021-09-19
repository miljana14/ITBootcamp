import org.postgresql.util.PSQLException;
import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;
import rs.itbootcamp.model.MealModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static FoodDao fd = new FoodDaoSql();
    static MealDao md = new MealDaoSql();
    static FridgeDao fridgeD = new FridgeDaoSql();
    static int fridge_id = 1;
    static int meal_id = 1;
    private static void welcomeMessage(){
        System.out.println("Welcome to kitchen!!!");
        System.out.println("------------------------");
    }

    private static void addFoodToFridge(Scanner sc){
        int choice = -1;

        while(choice != 0){
            List<FoodModel> foodList = fd.getAllFood();
            for(int i = 0; i < foodList.size(); i++){
                System.out.println((i+1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if(choice > 0 && choice <= foodList.size()){
                System.out.println("How much: (in grams)");
                double mass = sc.nextDouble();
                fd.addToFridge(fridge_id,foodList.get(choice - 1).getFood_id(),mass);
                System.out.println("++");
            }
            else if (choice != 0 && choice > foodList.size()){
                System.out.println("Insert name: ");
                String name = sc.next();
                System.out.println("Insert kcal");
                double kcal = sc.nextDouble();
                System.out.println("Insert proteins: ");
                double proteins = sc.nextDouble();
                System.out.println("Insert carbohydrates: ");
                double carbohydrates = sc.nextDouble();
                System.out.println("Insert fat: ");
                double fat = sc.nextDouble();
                FoodModel fm = new FoodModel(choice,name,kcal,proteins,carbohydrates,fat);
                fd.update(fm);
                System.out.println("++");
            }
        }
    }

    private static void deleteFoodFromFridge(Scanner sc){

        int choice = -1;

        while(choice != 0){
            List<FoodModel> foodList = fd.getAllFood();
            for(int i = 0; i < foodList.size(); i++){
                System.out.println((i+1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if(choice > 0 && choice <= foodList.size()){
                fd.delete(foodList.get(choice - 1).getFood_id());
                System.out.println("Removed");
                fd.getAllFood();
            }
        }
    }

    private static void LookInFridge(){

            List<FoodModel> foodList = fd.getAllFood();
            for(int i = 0; i < foodList.size(); i++){
                System.out.println((i+1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");
    }

    private static void createMeal(Scanner sc){
            int choice = -1;

            while(choice != 0){
                List<FoodModel> foodList = fd.getAllFood();
                for(int i = 0; i < foodList.size(); i++){
                    System.out.println((i+1) + ". " + foodList.get(i));
                }
                System.out.println("0. Back");

                choice = sc.nextInt();

                if(choice > 0 && choice <= foodList.size()){
                    System.out.println("Insert meal id: ");
                    int mealId = sc.nextInt();
                    System.out.println("How much: (in grams)");
                    double mass = sc.nextDouble();
                    fd.addToMeal(mealId,foodList.get(choice - 1).getFood_id(),mass);
                    System.out.println("++");
                }
            }
        }

    private static void fridgeMenu(Scanner sc){
        int choice;
        do{
            System.out.println("My Fridge:");
            System.out.println("--------");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Look in");
            System.out.println("4. Create meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch(choice){
                case 1 -> addFoodToFridge(sc);
                case 2 -> deleteFoodFromFridge(sc);
                case 3 -> LookInFridge();
                case 4 -> createMeal(sc);
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    private static void search(Scanner sc){
        int choice = -1;

        while(choice != 0){
            List<FoodModel> foodList = fd.getAllFood();
            String s = sc.next();
            char[] charArray = s.toCharArray();
            for(int i = 0; i < foodList.size(); i++){
                char ch = charArray[i];
                if (foodList.get(i).getFood_name().contains(s)){
                    System.out.println(foodList.get(i));
                }
            }
            System.out.println("0. Back");
        }
    }

    private static void mainMenu(Scanner sc){
        int choice;
        do{
            System.out.println("Main menu:");
            System.out.println("-----------");
            System.out.println("1. My Fridge");
            System.out.println("2. Meals");
            System.out.println("3. All food");
            System.out.println("4. Add new food");
            System.out.println("5. Search");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1 -> fridgeMenu(sc);
                case 2 -> System.out.println("Meals");
                case 3 -> System.out.println("All food");
                case 4 -> System.out.println("Add new food");
                case 5 -> search(sc); //za sada radi samo za food_name
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeMessage();

        mainMenu(sc);
    }
}
