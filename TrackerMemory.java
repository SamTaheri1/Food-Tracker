import java.util.Scanner;
import java.util.ArrayList;

class TrackerMemory {
    private ArrayList<DailyLog> allLogs;

    public TrackerMemory() {
        allLogs = new ArrayList<DailyLog>();
    }

    public void addLog(DailyLog log) {
        allLogs.add(log);
    }

    public DailyLog findLog(String date) {
        for (int i = 0; i < allLogs.size(); i++) {
            if (allLogs.get(i).getDate().equalsIgnoreCase(date)) {
                return allLogs.get(i);
            }
        }
        return null;
    }

    public void removeLog(int index) {
        allLogs.remove(index);
    }

    public int findLogIndex(String date) {
        for (int i = 0; i < allLogs.size(); i++) {
            if (allLogs.get(i).getDate().equalsIgnoreCase(date)) {
                return i;
            }
        }
        return -1;
    }

    public void displaySavedDates() {
        if (allLogs.size() == 0) {
            System.out.println("No saved dates yet.");
            return;
        }

        System.out.println("\n----- Saved Dates -----");

        for (int i = 0; i < allLogs.size(); i++) {
            DailyLog log = allLogs.get(i);

            System.out.println((i + 1) + ". " + log.getDate()
                    + " | Foods: " + log.getFoodList().size()
                    + " | Calories: " + log.getTotalCalories());
        }

        System.out.println("Total saved days: " + allLogs.size());
    }

    public void displayAllLogs() {
        if (allLogs.size() == 0) {
            System.out.println("No logs saved.");
            return;
        }

        for (int i = 0; i < allLogs.size(); i++) {
            allLogs.get(i).displayLog();
        }
    }

    public void searchFood(String name) {
        boolean found = false;

        for (int i = 0; i < allLogs.size(); i++) {
            DailyLog oneLog = allLogs.get(i);
            ArrayList<FoodItem> foods = oneLog.getFoodList();

            for (int j = 0; j < foods.size(); j++) {
                String foodName = foods.get(j).getFoodName().toLowerCase();
                String category = foods.get(j).getCategory().toLowerCase();
                String search = name.toLowerCase();

                if (foodName.contains(search) || category.contains(search)) {
                    System.out.println("\nDate: " + oneLog.getDate());
                    foods.get(j).displayFood();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Food not found.");
        }
    }
}
