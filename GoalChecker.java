class GoalChecker {

    public static void checkGoals(DailyLog log, NutrientGoals goals) {
        System.out.println("\n----- Goal Check for " + log.getDate() + " -----");

        goals.displayGoals();

        checkValue("Calories", log.getTotalCalories(), goals.getCalorieGoal(), "cal");
        checkValue("Protein", log.getTotalProtein(), goals.getProteinGoal(), "g");
        checkValue("Carbs", log.getTotalCarbs(), goals.getCarbsGoal(), "g");
        checkValue("Fat", log.getTotalFat(), goals.getFatGoal(), "g");
        checkValue("Fiber", log.getTotalFiber(), goals.getFiberGoal(), "g");
        checkValue("Sugar", log.getTotalSugar(), goals.getSugarGoal(), "g");

        showGoalScore(log, goals);
        showPercentReport(log, goals);
        showSimpleAdvice(log, goals);
    }

    private static void checkValue(String label, double actual, double goal, String unit) {
        double diff = actual - goal;
        String status;

        if (diff > 0) {
            status = "OVER by " + String.format("%.1f", diff) + " " + unit;
        }
        else if (diff < 0) {
            status = "UNDER by " + String.format("%.1f", Math.abs(diff)) + " " + unit;
        }
        else {
            status = "RIGHT ON TARGET";
        }

        System.out.printf("%-10s %6.1f / %.1f %s  ->  %s%n", label, actual, goal, unit, status);
    }

    private static void showGoalScore(DailyLog log, NutrientGoals goals) {
        int score = 0;

        if (isClose(log.getTotalCalories(), goals.getCalorieGoal())) {
            score++;
        }

        if (isClose(log.getTotalProtein(), goals.getProteinGoal())) {
            score++;
        }

        if (isClose(log.getTotalCarbs(), goals.getCarbsGoal())) {
            score++;
        }

        if (isClose(log.getTotalFat(), goals.getFatGoal())) {
            score++;
        }

        if (isClose(log.getTotalFiber(), goals.getFiberGoal())) {
            score++;
        }

        if (log.getTotalSugar() <= goals.getSugarGoal()) {
            score++;
        }

        System.out.println("\nGoal score: " + score + "/6");

        if (score >= 5) {
            System.out.println("Great day overall.");
        }
        else if (score >= 3) {
            System.out.println("Decent day, but some goals need work.");
        }
        else {
            System.out.println("This day is far from the goals.");
        }
    }

    private static boolean isClose(double actual, double goal) {
        if (goal == 0) {
            return false;
        }

        double difference = Math.abs(actual - goal);
        return difference <= goal * 0.20;
    }

    private static void showPercentReport(DailyLog log, NutrientGoals goals) {
        System.out.println("\n----- Goal Percent Report -----");

        printPercent("Calories", log.getTotalCalories(), goals.getCalorieGoal());
        printPercent("Protein", log.getTotalProtein(), goals.getProteinGoal());
        printPercent("Carbs", log.getTotalCarbs(), goals.getCarbsGoal());
        printPercent("Fat", log.getTotalFat(), goals.getFatGoal());
        printPercent("Fiber", log.getTotalFiber(), goals.getFiberGoal());
        printPercent("Sugar", log.getTotalSugar(), goals.getSugarGoal());
    }

    private static void printPercent(String label, double actual, double goal) {
        if (goal == 0) {
            System.out.println(label + ": No goal set.");
            return;
        }

        double percent = (actual / goal) * 100;
        System.out.println(label + ": " + String.format("%.1f", percent) + "% of goal reached");
    }

    private static void showSimpleAdvice(DailyLog log, NutrientGoals goals) {
        System.out.println("\n----- Simple Advice -----");

        if (log.getTotalCalories() > goals.getCalorieGoal()) {
            System.out.println("Calories are above the goal.");
        }
        else {
            System.out.println("Calories are within or below the goal.");
        }

        if (log.getTotalProtein() < goals.getProteinGoal()) {
            System.out.println("Protein is low compared to the goal.");
        }

        if (log.getTotalFiber() < goals.getFiberGoal()) {
            System.out.println("Fiber is low compared to the goal.");
        }

        if (log.getTotalSugar() > goals.getSugarGoal()) {
            System.out.println("Sugar is above the goal.");
        }

        System.out.println("Goal check finished.");
    }
}
