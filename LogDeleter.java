import java.util.Scanner;


class LogDeleter {
    public static void deleteFoodFromLog(TrackerMemory memory, Scanner keyboard) {
        System.out.print("Enter date of the log: ");
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
        System.out.print("Choose food number to delete: ");
        int foodNumber = InputHelper.readInt(keyboard);

        if (foodNumber < 1 || foodNumber > foundLog.getFoodList().size()) {
            System.out.println("Invalid food number.");
            return;
        }

        foundLog.removeFood(foodNumber - 1);
        System.out.println("Food deleted successfully.");
    }

    public static void deleteWholeLog(TrackerMemory memory, Scanner keyboard) {
        System.out.print("Enter date of the day log to delete: ");
        String date = keyboard.nextLine();

        int index = memory.findLogIndex(date);

        if (index == -1) {
            System.out.println("No log found for that date.");
            return;
        }

        memory.removeLog(index);
        System.out.println("Entire day log deleted successfully.");
    }
}