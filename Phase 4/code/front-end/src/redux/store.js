import { configureStore } from "@reduxjs/toolkit";
import { foodReducer } from "./features/foods/foodSlice";

const store = configureStore({
    reducer: {
        foods:foodReducer
    }
});

export {store}
