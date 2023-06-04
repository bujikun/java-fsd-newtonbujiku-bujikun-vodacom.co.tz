import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    customer: {
        
    }
}
const customerSlice = createSlice({
  name: "customers",
  initialState,
  reducers: {
    addCustomer(state, action) {
      state.customer = action.payload;
    },
    clearCustomer(state, action) {
      state.customer = {}
    },
  },
});

export const {addCustomer,clearCustomer} = customerSlice.actions;
export const customerReducer = customerSlice.reducer;
export const selectCustomer = state=> state.customer.customer