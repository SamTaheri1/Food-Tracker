class FoodItem {
    private String foodName;
    private int calories;
    private Nutrients nutrients;

    public FoodItem(String foodName, int calories, Nutrients nutrients) {
        this.foodName = foodName;
        this.calories = calories;
        this.nutrients = nutrients;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCalories() {
        return calories;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public void displayFood() {
        System.out.println("Food name: " + foodName);
        System.out.println("Calories: " + calories);
        nutrients.displayNutrients();
    }

    @Override
    public String toString() {
        return foodName + " (" + calories + " cal)";
    }
}