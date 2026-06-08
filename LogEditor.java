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

        System.out.println("\nPress ENTER to keep the old value.");

        System.out.print("New food name [" + chosenFood.getFoodName() + "]: ");
        String newName = keyboard.nextLine();

        if (newName.length() != 0) {
            chosenFood.setFoodName(newName);
        }

        System.out.print("New category [" + chosenFood.getCategory() + "]: ");
        String newCategory = keyboard.nextLine();

        if (newCategory.length() != 0) {
            chosenFood.setCategory(newCategory);
        }

        int newCalories = readOptionalInt(keyboard, "New calories [" + chosenFood.getCalories() + "]: ", chosenFood.getCalories());

        double newProtein = readOptionalDouble(keyboard, "New protein [" + chosenFood.getNutrients().getProtein() + "]: ", chosenFood.getNutrients().getProtein());

        double newCarbs = readOptionalDouble(keyboard, "New carbs [" + chosenFood.getNutrients().getCarbs() + "]: ", chosenFood.getNutrients().getCarbs());

        double newFat = readOptionalDouble(keyboard, "New fat [" + chosenFood.getNutrients().getFat() + "]: ", chosenFood.getNutrients().getFat());

        double newFiber = readOptionalDouble(keyboard, "New fiber [" + chosenFood.getNutrients().getFiber() + "]: ", chosenFood.getNutrients().getFiber());

        double newSugar = readOptionalDouble(keyboard, "New sugar [" + chosenFood.getNutrients().getSugar() + "]: ", chosenFood.getNutrients().getSugar());

        Nutrients updatedNutrients = new Nutrients(newProtein, newCarbs, newFat, newFiber, newSugar);

        chosenFood.setCalories(newCalories);
        chosenFood.setNutrients(updatedNutrients);

        System.out.println("Food log updated successfully.");
    }

    private static int readOptionalInt(Scanner keyboard, String message, int oldValue) {
        while (true) {
            try {
                System.out.print(message);
                String input = keyboard.nextLine();

                if (input.length() == 0) {
                    return oldValue;
                }

                int value = Integer.parseInt(input);

                if (value < 0) {
                    throw new NumberFormatException();
                }

                return value;
            }
            catch (NumberFormatException e) {
                System.out.println("Enter a valid whole number or press ENTER.");
            }
        }
    }

    private static double readOptionalDouble(Scanner keyboard, String message, double oldValue) {
        while (true) {
            try {
                System.out.print(message);
                String input = keyboard.nextLine();

                if (input.length() == 0) {
                    return oldValue;
                }

                double value = Double.parseDouble(input);

                if (value < 0) {
                    throw new NumberFormatException();
                }

                return value;
            }
            catch (NumberFormatException e) {
                System.out.println("Enter a valid number or press ENTER.");
            }
        }
    }
}
