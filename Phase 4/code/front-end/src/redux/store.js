import { configureStore } from "@reduxjs/toolkit";
import { foodReducer } from "./features/foods/foodSlice";
import { cartReducer } from "./features/cart/cartSlice";
import { customerReducer } from "./features/customer/customerSlice";

const store = configureStore({
    reducer: {
        foods: foodReducer,
        cart: cartReducer,
        customers:customerReducer
    }
});

export {store}
