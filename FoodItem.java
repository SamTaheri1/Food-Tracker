class FoodItem {
    private String foodName;
    private int calories;
    private Nutrients nutrients;
    private String category;

    public FoodItem(String foodName, int calories, Nutrients nutrients, String category) {
        this.foodName = foodName;
        this.calories = calories;
        this.nutrients = nutrients;
        this.category = category;
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

    public String getCategory() {
        return category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void displayFood() {
        System.out.println("Food name: " + foodName);
        System.out.println("Category: " + category);
        System.out.println("Calories: " + calories);
        nutrients.displayNutrients();
    }

    @Override
    public String toString() {
        return foodName + " (" + calories + " cal)";
    }
}