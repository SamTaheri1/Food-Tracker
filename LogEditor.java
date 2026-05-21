import java.util.Scanner;
import java.util.ArrayList;

class LogEditor {
    public static void editFoodInLog(TrackerMemory memory, Scanner keyboard) {
        System.out.print("Enter date of the log you want to edit: ");
        String date = keyboard.nextLine();

        DailyLog foundLog = memory.findLog(date);

        if (foundLog == null) {
            System.out.println("No log found for that date.");
            return;
        }

        if (foundLog.getFoodList().size() == 0) {
            System.out.println("No food in that log.");
            return;
        }

        System.out.println("Foods in that day:");
        foundLog.displayShortFoods();

        System.out.print("Choose food number to edit: ");
        int foodNumber = InputHelper.readInt(keyboard);

        if (foodNumber < 1 || foodNumber > foundLog.getFoodList().size()) {
            System.out.println("Invalid food number.");
            return;
        }

        FoodItem chosenFood = foundLog.getFoodList().get(foodNumber - 1);

        System.out.print("Enter new food name: ");
        String newName = keyboard.nextLine();

        System.out.print("Enter new category: ");
        String newCategory = keyboard.nextLine();

        System.out.print("Enter new calories: ");
        int newCalories = InputHelper.readInt(keyboard);

        System.out.print("Enter new protein (g): ");
        double newProtein = InputHelper.readDouble(keyboard);

        System.out.print("Enter new carbs (g): ");
        double newCarbs = InputHelper.readDouble(keyboard);

        System.out.print("Enter new fat (g): ");
        double newFat = InputHelper.readDouble(keyboard);

        System.out.print("Enter new fiber (g): ");
        double newFiber = InputHelper.readDouble(keyboard);

        System.out.print("Enter new sugar (g): ");
        double newSugar = InputHelper.readDouble(keyboard);

        Nutrients newNutrients = new Nutrients(newProtein, newCarbs, newFat, newFiber, newSugar);

        chosenFood.setFoodName(newName);
        chosenFood.setCategory(newCategory);
        chosenFood.setCalories(newCalories);
        chosenFood.setNutrients(newNutrients);

        System.out.println("Food log updated successfully.");
    }
}
