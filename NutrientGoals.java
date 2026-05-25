class NutrientGoals {
    private int calorieGoal;
    private double proteinGoal;
    private double carbsGoal;
    private double fatGoal;
    private double fiberGoal;
    private double sugarGoal;

    public NutrientGoals() {
        calorieGoal = 2000;
        proteinGoal = 100;
        carbsGoal = 250;
        fatGoal = 70;
        fiberGoal = 25;
        sugarGoal = 50;
    }

    public NutrientGoals(int calorieGoal, double proteinGoal, double carbsGoal,
                         double fatGoal, double fiberGoal, double sugarGoal) {
        this.calorieGoal = calorieGoal;
        this.proteinGoal = proteinGoal;
        this.carbsGoal = carbsGoal;
        this.fatGoal = fatGoal;
        this.fiberGoal = fiberGoal;
        this.sugarGoal = sugarGoal;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public double getProteinGoal() {
        return proteinGoal;
    }

    public double getCarbsGoal() {
        return carbsGoal;
    }

    public double getFatGoal() {
        return fatGoal;
    }

    public double getFiberGoal() {
        return fiberGoal;
    }

    public double getSugarGoal() {
        return sugarGoal;
    }

    public void displayGoals() {
        System.out.println("\n----- Daily Nutrient Goals -----");
        System.out.println("Calorie goal: " + calorieGoal + " cal");
        System.out.println("Protein goal: " + proteinGoal + " g");
        System.out.println("Carbs goal: " + carbsGoal + " g");
        System.out.println("Fat goal: " + fatGoal + " g");
        System.out.println("Fiber goal: " + fiberGoal + " g");
        System.out.println("Sugar goal: " + sugarGoal + " g");
    }
}
