package io.muic.ooc.fab;

public enum FoodValue {
    RABBIT_FOOD_VALUE(9),
    FOX_FOOD_VALUE(18);

    private int foodValue;


    FoodValue(int foodValue) {
        this.foodValue = foodValue;
    }

    public int getFoodValue() {
        return foodValue;
    }


}
