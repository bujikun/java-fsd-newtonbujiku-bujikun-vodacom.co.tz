import { configureStore } from "@reduxjs/toolkit";
import { foodReducer } from "./features/foods/foodSlice";
import { cartReducer } from "./features/cart/cartSlice";
import { customerReducer } from "./features/customer/customerSlice";
import { authReducer } from "./features/auth/authSlice";

const store = configureStore({
    reducer: {
        foods: foodReducer,
        cart: cartReducer,
        customer: customerReducer,
        auth:authReducer
    }
});

export {store}
