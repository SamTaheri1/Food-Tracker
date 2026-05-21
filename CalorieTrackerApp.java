import java.util.Scanner;
import java.util.ArrayList;

public class CalorieTrackerApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TrackerMemory memory = new TrackerMemory();
        boolean programOn = true;

        while (programOn) {
            System.out.println("\n===== Calorie Food Tracker =====");
            System.out.println("1. Add food to a day");
            System.out.println("2. View one day");
            System.out.println("3. View all days");
            System.out.println("4. Search food");
            System.out.println("5. Edit a food log");
            System.out.println("6. Delete a food from a day");
            System.out.println("7. Delete an entire day log");
            System.out.println("8. Copy a day's log to another day");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = InputHelper.readInt(keyboard);

            if (choice == 1) {
                System.out.print("Enter date: ");
                String day = keyboard.nextLine();

                DailyLog chosenLog = memory.findLog(day);

                if (chosenLog == null) {
                    chosenLog = new DailyLog(day);
                    memory.addLog(chosenLog);
                }

                System.out.print("Enter food name: ");
                String foodName = keyboard.nextLine();

                System.out.print("Enter category: ");
                String category = keyboard.nextLine();

                System.out.print("Enter calories: ");
                int calories = InputHelper.readInt(keyboard);

                System.out.print("Enter protein (g): ");
                double protein = InputHelper.readDouble(keyboard);

                System.out.print("Enter carbs (g): ");
                double carbs = InputHelper.readDouble(keyboard);

                System.out.print("Enter fat (g): ");
                double fat = InputHelper.readDouble(keyboard);

                System.out.print("Enter fiber (g): ");
                double fiber = InputHelper.readDouble(keyboard);

                System.out.print("Enter sugar (g): ");
                double sugar = InputHelper.readDouble(keyboard);

                Nutrients foodNutrients = new Nutrients(protein, carbs, fat, fiber, sugar);
                FoodItem newFood = new FoodItem(foodName, calories, foodNutrients, category);

                chosenLog.addFood(newFood);

                System.out.println("Food added successfully.");
            }
            else if (choice == 2) {
                System.out.print("Enter date to view: ");
                String wantedDay = keyboard.nextLine();

                DailyLog foundLog = memory.findLog(wantedDay);

                if (foundLog == null) {
                    System.out.println("No log found for that date.");
                }
                else {
                    foundLog.displayLog();
                }
            }
            else if (choice == 3) {
                memory.displayAllLogs();
            }
            else if (choice == 4) {
                System.out.print("Enter food name to search: ");
                String searchWord = keyboard.nextLine();
                memory.searchFood(searchWord);
            }
            else if (choice == 5) {
                LogEditor.editFoodInLog(memory, keyboard);
            }
            else if (choice == 6) {
                LogDeleter.deleteFoodFromLog(memory, keyboard);
            }
            else if (choice == 7) {
                LogDeleter.deleteWholeLog(memory, keyboard);
            }
            else if (choice == 8) {
                System.out.print("Enter source date to copy from: ");
                String sourceDate = keyboard.nextLine();
                DailyLog sourceLog = memory.findLog(sourceDate);

                if (sourceLog == null) {
                    System.out.println("No log found for that date.");
                }
                else {
                    System.out.print("Enter target date to copy to: ");
                    String targetDate = keyboard.nextLine();
                    DailyLog targetLog = memory.findLog(targetDate);

                    if (targetLog == null) {
                        targetLog = new DailyLog(targetDate);
                        memory.addLog(targetLog);
                    }

                    for (FoodItem item : sourceLog.getFoodList()) {
                        targetLog.addFood(item);
                    }

                    System.out.println("Log copied successfully.");
                }
            }
            else if (choice == 9) {
                programOn = false;
                System.out.println("Program closed.");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        keyboard.close();
    }
}
