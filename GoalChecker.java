class GoalChecker {

    public static void checkGoals(DailyLog log, NutrientGoals goals) {
        System.out.println("\n----- Goal Check for " + log.getDate() + " -----");

        checkValue("Calories", log.getTotalCalories(), goals.getCalorieGoal(), "cal");
        checkValue("Protein",  log.getTotalProtein(),  goals.getProteinGoal(),  "g");
        checkValue("Carbs",    log.getTotalCarbs(),    goals.getCarbsGoal(),    "g");
        checkValue("Fat",      log.getTotalFat(),      goals.getFatGoal(),      "g");
        checkValue("Fiber",    log.getTotalFiber(),    goals.getFiberGoal(),    "g");
        checkValue("Sugar",    log.getTotalSugar(),    goals.getSugarGoal(),    "g");
    }

    private static void checkValue(String label, double actual, double goal, String unit) {
        double diff = actual - goal;
        String status;
        if (diff > 0) {
            status = "OVER by " + String.format("%.1f", diff) + " " + unit;
        } else if (diff < 0) {
            status = "UNDER by " + String.format("%.1f", Math.abs(diff)) + " " + unit;
        } else {
            status = "RIGHT ON TARGET";
        }
        System.out.printf("%-10s %6.1f / %.1f %s  ->  %s%n", label, actual, goal, unit, status);
    }
}
