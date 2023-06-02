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
          const food = state.cartItems.find(food => food.id === id);
          if (food) {
              food.quantity += 1;
              const index = state.cartItems.indexOf(food);
              state.cartItems[index] = food;
              return;
          } 
          state.cartItems.push({...action.payload,quantity:0});
    //       let isExistingItem = false;
    //   const { id } = action.payload.id;
    //   const food = state.cartItems.forEach((food, index) => {
    //     if (food.id === id) {
    //         food.quantity += 1;
    //         isExistingItem = true;
    //       console.log(index);
    //       return;
    //     }
    //   });
    //       if (isExistingItem) {
    //           return;
    //       }
    //       const 
    //   state.cartItems.push(action.payload);
    },
  },
});

export const { addToCart } = cartSlice.actions;
export const selectAllCartItems = (state) => state.cart.cartItems;
export const cartReducer = cartSlice.reducer;
