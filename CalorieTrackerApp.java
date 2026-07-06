import java.util.Scanner;
import java.util.ArrayList;

public class CalorieTrackerApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TrackerMemory memory = new TrackerMemory();
        NutrientGoals goals = new NutrientGoals();
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
            System.out.println("9. View daily summary");
            System.out.println("10. View saved dates");
            System.out.println("11. View nutrient goals");
            System.out.println("12. Update nutrient goals");
            System.out.println("13. Check goals for a day");
            System.out.println("14. Quick add snack");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            int choice = InputHelper.readInt(keyboard);

            if (choice == 1) {
                addFood(memory, keyboard);
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
                System.out.print("Enter food name or category to search: ");
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
                copyDay(memory, keyboard);
            }
            else if (choice == 9) {
                showDailySummary(memory, keyboard);
            }
            else if (choice == 10) {
                memory.displaySavedDates();
            }
            else if (choice == 11) {
                goals.displayGoals();
            }
            else if (choice == 12) {
                goals.updateGoals(keyboard);
            }
            else if (choice == 13) {
                System.out.print("Enter date to check goals: ");
                String date = keyboard.nextLine();

                DailyLog log = memory.findLog(date);

                if (log == null) {
                    System.out.println("No log found for that date.");
                }
                else {
                    GoalChecker.checkGoals(log, goals);
                }
            }
            else if (choice == 14) {
                quickAddSnack(memory, keyboard);
            }
            else if (choice == 15) {
                programOn = false;
                System.out.println("Program closed.");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }

        keyboard.close();
    }

    public static void addFood(TrackerMemory memory, Scanner keyboard) {
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

    public static void quickAddSnack(TrackerMemory memory, Scanner keyboard) {
        System.out.print("Enter date: ");
        String day = keyboard.nextLine();

        DailyLog chosenLog = memory.findLog(day);

        if (chosenLog == null) {
            chosenLog = new DailyLog(day);
            memory.addLog(chosenLog);
        }

        System.out.print("Snack name: ");
        String snackName = keyboard.nextLine();

        System.out.print("Snack calories: ");
        int calories = InputHelper.readInt(keyboard);

        Nutrients snackNutrients = new Nutrients(0, 0, 0, 0, 0);
        FoodItem snack = new FoodItem(snackName, calories, snackNutrients, "Snack");

        chosenLog.addFood(snack);

        System.out.println("Quick snack added.");
    }

    public static void copyDay(TrackerMemory memory, Scanner keyboard) {
        System.out.print("Enter source date to copy from: ");
        String sourceDate = keyboard.nextLine();
        DailyLog sourceLog = memory.findLog(sourceDate);

        if (sourceLog == null) {
            System.out.println("No log found for that date.");
            return;
        }

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

    public static void showDailySummary(TrackerMemory memory, Scanner keyboard) {
        System.out.print("Enter date for summary: ");
        String date = keyboard.nextLine();

        DailyLog log = memory.findLog(date);

        if (log == null) {
            System.out.println("No log found for that date.");
            return;
        }

        if (log.getFoodList().size() == 0) {
            System.out.println("That day has no foods saved.");
            return;
        }

        System.out.println("\n===== Daily Summary =====");
        System.out.println("Date: " + log.getDate());
        System.out.println("Foods logged: " + log.getFoodList().size());
        System.out.println("Total calories: " + log.getTotalCalories());
        System.out.println("Total protein: " + log.getTotalProtein() + " g");
        System.out.println("Total carbs: " + log.getTotalCarbs() + " g");
        System.out.println("Total fat: " + log.getTotalFat() + " g");
        System.out.println("Total fiber: " + log.getTotalFiber() + " g");
        System.out.println("Total sugar: " + log.getTotalSugar() + " g");

        double averageCalories = (double) log.getTotalCalories() / log.getFoodList().size();
        System.out.println("Average calories per food: " + String.format("%.1f", averageCalories));
    }
}
