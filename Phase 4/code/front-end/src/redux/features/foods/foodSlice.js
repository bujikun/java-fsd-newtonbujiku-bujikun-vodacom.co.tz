import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  foodItems: [],
};
const foodSlice = createSlice({
  name: "foods",
  initialState,
  reducers: {
    addFoodItems(state, action) {
      state.foodItems = action.payload;
    },
    clearFoodItems(state, action) {
      state.foodItems = action.payload;
    },
    removeFoodItem(state, action) {
      state.foodItems = state.foodItems
        .filter(food => food.id !== action.payload);
    },
  },
});

export const { addFoodItems, clearFoodItems,removeFoodItem } = foodSlice.actions;
export const foodReducer = foodSlice.reducer;
export const selectAvailableFoods = (state) => state.foods.foodItems;
