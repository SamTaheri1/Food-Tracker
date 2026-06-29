class Nutrients {
    private double protein;
    private double carbs;
    private double fat;
    private double fiber;
    private double sugar;

    public Nutrients(double protein, double carbs, double fat, double fiber, double sugar) {
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.fiber = fiber;
        this.sugar = sugar;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    public double getFiber() {
        return fiber;
    }

    public double getSugar() {
        return sugar;
    }

    public double getProteinCalories() {
        return protein * 4;
    }

    public double getCarbCalories() {
        return carbs * 4;
    }

    public double getFatCalories() {
        return fat * 9;
    }

    public double getMacroCalories() {
        return getProteinCalories() + getCarbCalories() + getFatCalories();
    }

    public void displayMacroBreakdown() {
        double total = getMacroCalories();

        System.out.println("Protein calories: " + String.format("%.1f", getProteinCalories()));
        System.out.println("Carb calories: " + String.format("%.1f", getCarbCalories()));
        System.out.println("Fat calories: " + String.format("%.1f", getFatCalories()));

        if (total == 0) {
            System.out.println("Macro percentage cannot be calculated.");
            return;
        }

        System.out.println("Protein percent: " + String.format("%.1f", (getProteinCalories() / total) * 100) + "%");
        System.out.println("Carb percent: " + String.format("%.1f", (getCarbCalories() / total) * 100) + "%");
        System.out.println("Fat percent: " + String.format("%.1f", (getFatCalories() / total) * 100) + "%");
    }

    public String getNutritionRating() {
        int score = 0;

        if (protein >= 10) {
            score++;
        }

        if (fiber >= 3) {
            score++;
        }

        if (sugar <= 10) {
            score++;
        }

        if (fat <= 20) {
            score++;
        }

        if (score >= 4) {
            return "Very balanced";
        }
        else if (score == 3) {
            return "Good";
        }
        else if (score == 2) {
            return "Okay";
        }
        else {
            return "Needs improvement";
        }
    }

    public void displayNutrients() {
        System.out.println("Protein: " + protein + " g");
        System.out.println("Carbs: " + carbs + " g");
        System.out.println("Fat: " + fat + " g");
        System.out.println("Fiber: " + fiber + " g");
        System.out.println("Sugar: " + sugar + " g");
        System.out.println("Nutrition rating: " + getNutritionRating());
        displayMacroBreakdown();
    }
}
