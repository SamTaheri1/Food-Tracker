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
    }
}
