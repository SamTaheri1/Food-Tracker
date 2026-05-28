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

        System.out.println("Foods in that day:");
        foundLog.displayShortFoods();

        System.out.print("Choose food number to delete: ");
        int foodNumber = InputHelper.readInt(keyboard);

        if (foodNumber < 1 || foodNumber > foundLog.getFoodList().size()) {
            System.out.println("Invalid food number.");
            return;
        }

        FoodItem chosenFood = foundLog.getFoodList().get(foodNumber - 1);

        boolean confirm = InputHelper.readYesNo(
                keyboard,
                "Are you sure you want to delete " + chosenFood.getFoodName() + "? "
        );

        if (!confirm) {
            System.out.println("Delete cancelled.");
            return;
        }

        foundLog.removeFood(foodNumber - 1);
        System.out.println(chosenFood.getFoodName() + " deleted successfully.");
    }

    public static void deleteWholeLog(TrackerMemory memory, Scanner keyboard) {
        String date = InputHelper.readText(keyboard, "Enter date of the day log to delete: ");

        int index = memory.findLogIndex(date);

        if (index == -1) {
            System.out.println("No log found for that date.");
            return;
        }

        DailyLog log = memory.findLog(date);

        System.out.println("\nLog found:");
        log.displayLog();

        boolean confirm = InputHelper.readYesNo(
                keyboard,
                "Are you sure you want to delete this entire day? "
        );

        if (!confirm) {
            System.out.println("Delete cancelled.");
            return;
        }

        memory.removeLog(index);
        System.out.println("Entire day log deleted successfully.");
    }
}
