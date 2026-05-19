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
                if (foods.get(j).getFoodName().toLowerCase().contains(name.toLowerCase())) {
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