import java.util.Scanner;
import java.util.ArrayList;

class DailyLog {
    private String date;
    private ArrayList<FoodItem> foodList;

    public DailyLog(String date) {
        this.date = date;
        foodList = new ArrayList<FoodItem>();
    }

    public String getDate() {
        return date;
    }

    public ArrayList<FoodItem> getFoodList() {
        return foodList;
    }

    public void addFood(FoodItem food) {
        foodList.add(food);
    }

    public void removeFood(int index) {
        foodList.remove(index);
    }

    public int getTotalCalories() {
        int total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getCalories();
        }
        return total;
    }

    public double getTotalProtein() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getNutrients().getProtein();
        }
        return total;
    }

    public double getTotalCarbs() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getNutrients().getCarbs();
        }
        return total;
    }

    public double getTotalFat() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getNutrients().getFat();
        }
        return total;
    }

    public void displayShortFoods() {
        if (foodList.size() == 0) {
            System.out.println("No food added.");
            return;
        }

        for (int i = 0; i < foodList.size(); i++) {
            System.out.println((i + 1) + ". " + foodList.get(i).getFoodName());
        }
    }

    public void displayLog() {
        System.out.println("\n----- Log for " + date + " -----");

        if (foodList.size() == 0) {
            System.out.println("No food added.");
            return;
        }

        for (int i = 0; i < foodList.size(); i++) {
            System.out.println("\nFood #" + (i + 1));
            foodList.get(i).displayFood();
        }

        System.out.println("\nDaily totals:");
        System.out.println("Total calories: " + getTotalCalories());
        System.out.println("Total protein: " + getTotalProtein() + " g");
        System.out.println("Total carbs: " + getTotalCarbs() + " g");
        System.out.println("Total fat: " + getTotalFat() + " g");
        System.out.println("Total fiber: " + getTotalFiber() + " g");
        System.out.println("Total sugar: " + getTotalSugar() + " g");
    }

    public double getTotalFiber() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getNutrients().getFiber();
        }
        return total;
    }

    public double getTotalSugar() {
        double total = 0;
        for (int i = 0; i < foodList.size(); i++) {
            total += foodList.get(i).getNutrients().getSugar();
        }
        return total;
    }
}