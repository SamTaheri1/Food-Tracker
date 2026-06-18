import java.util.Scanner;

class LogDeleter {
    public static void deleteFoodFromLog(TrackerMemory memory, Scanner keyboard) {
        String date = InputHelper.readText(keyboard, "Enter date of the log: ");

        DailyLog foundLog = memory.findLog(date);

        if (foundLog == null) {
            System.out.println("No log found for that date.");
            return;
        }

        if (foundLog.getFoodList().size() == 0) {
            System.out.println("No food in that log.");
            return;
        }

        System.out.println("\nDelete food by:");
        System.out.println("1. Food number");
        System.out.println("2. Food name");
        int deleteChoice = InputHelper.readIntBetween(keyboard, "Choose option: ", 1, 2);

        int foodIndex = -1;

        if (deleteChoice == 1) {
            System.out.println("Foods in that day:");
            foundLog.displayShortFoods();

            int foodNumber = InputHelper.readIntBetween(
                    keyboard,
                    "Choose food number to delete: ",
                    1,
                    foundLog.getFoodList().size()
            );

            foodIndex = foodNumber - 1;
        }
        else {
            String foodName = InputHelper.readText(keyboard, "Enter food name to delete: ");

            for (int i = 0; i < foundLog.getFoodList().size(); i++) {
                String currentName = foundLog.getFoodList().get(i).getFoodName();

                if (currentName.equalsIgnoreCase(foodName)) {
                    foodIndex = i;
                }
            }

            if (foodIndex == -1) {
                System.out.println("No food found with that exact name.");
                return;
            }
        }

        FoodItem chosenFood = foundLog.getFoodList().get(foodIndex);

        System.out.println("\nFood selected:");
        chosenFood.displayFood();

        String reason = InputHelper.readOptionalText(
                keyboard,
                "Reason for deleting this food: "
        );

        boolean confirm = InputHelper.readYesNo(
                keyboard,
                "Confirm delete? "
        );

        if (!confirm) {
            System.out.println("Delete cancelled.");
            return;
        }

        foundLog.removeFood(foodIndex);

        System.out.println("\nDelete receipt:");
        System.out.println("Deleted food: " + chosenFood.getFoodName());
        System.out.println("Deleted from date: " + foundLog.getDate());
        System.out.println("Calories removed: " + chosenFood.getCalories());
        System.out.println("Reason: " + reason);
        System.out.println("Food deleted successfully.");
    }

    public static void deleteWholeLog(TrackerMemory memory, Scanner keyboard) {
        String date = InputHelper.readText(keyboard, "Enter date of the day log to delete: ");

        int index = memory.findLogIndex(date);

        if (index == -1) {
            System.out.println("No log found for that date.");
            return;
        }

        DailyLog log = memory.findLog(date);

        System.out.println("\nLog selected:");
        log.displayLog();

        String reason = InputHelper.readOptionalText(
                keyboard,
                "Reason for deleting this day log: "
        );

        boolean confirm = InputHelper.readYesNo(
                keyboard,
                "Confirm delete entire day? "
        );

        if (!confirm) {
            System.out.println("Delete cancelled.");
            return;
        }

        memory.removeLog(index);

        System.out.println("\nDelete receipt:");
        System.out.println("Deleted date: " + date);
        System.out.println("Reason: " + reason);
        System.out.println("Entire day log deleted successfully.");
    }
}
