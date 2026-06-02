class FoodItem {
    private String foodName;
    private int calories;
    private Nutrients nutrients;
    private String category;
    private String note;
    private boolean favorite;

    public FoodItem(String foodName, int calories, Nutrients nutrients, String category) {
        this.foodName = foodName;
        this.calories = calories;
        this.nutrients = nutrients;
        this.category = category;
        note = "No note";
        favorite = false;
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

    public String getNote() {
        return note;
    }

    public boolean isFavorite() {
        return favorite;
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

    public void setNote(String note) {
        if (note == null || note.trim().length() == 0) {
            this.note = "No note";
        }
        else {
            this.note = note;
        }
    }

    public void markFavorite() {
        favorite = true;
    }

    public void unmarkFavorite() {
        favorite = false;
    }

    public void displayFood() {
        System.out.println("Food name: " + foodName);
        System.out.println("Category: " + category);
        System.out.println("Calories: " + calories);
        System.out.println("Favorite: " + favorite);
        System.out.println("Note: " + note);
        nutrients.displayNutrients();
    }

    @Override
    public String toString() {
        return foodName + " (" + calories + " cal)";
    }
}
