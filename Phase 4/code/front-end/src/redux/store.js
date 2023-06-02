import { configureStore } from "@reduxjs/toolkit";
import { foodReducer } from "./features/foods/foodSlice";
import { cartReducer } from "./features/cart/cartSlice";

const store = configureStore({
    reducer: {
        foods: foodReducer,
        cart:cartReducer
    }
});

export {store}
