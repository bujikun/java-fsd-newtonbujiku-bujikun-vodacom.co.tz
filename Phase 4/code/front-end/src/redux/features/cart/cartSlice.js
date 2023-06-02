import { createSlice } from "@reduxjs/toolkit";
const initialState = {
  cartItems: [],
};
const cartSlice = createSlice({
  name: "cart",
  initialState,
  reducers: {
    addToCart(state, action) {
      const { id } = action.payload;
      const food = state.cartItems.find((food) => food.id === id);
      if (food) {
        food.quantity += 1;
        const index = state.cartItems.indexOf(food);
        state.cartItems[index] = food;
        return;
      }
      state.cartItems.push({ ...action.payload, quantity: 1 });
    },
    removeCartItem(state, action) {
      const filteredItems = state.cartItems.filter(
        (item) => item.id !== action.payload
      );
        state.cartItems = filteredItems;
      },
        clearCart(state){
        state.cartItems = [];
    },
  },
});

export const { addToCart, removeCartItem, clearCart } = cartSlice.actions;
export const selectAllCartItems = (state) => state.cart.cartItems;
export const cartReducer = cartSlice.reducer;
