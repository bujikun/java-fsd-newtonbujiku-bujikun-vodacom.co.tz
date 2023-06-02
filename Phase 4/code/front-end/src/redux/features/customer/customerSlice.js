import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    customers: [
        
    ]
}
const customerSlice = createSlice({
    name: "customers",
    initialState,
    reducers: {
        addCustomer(state, action) {
            state.customers.push(action.payload)
        }
    }
    
});

export const {addCustomer} = customerSlice.actions;
export const customerReducer = customerSlice.reducer;
export const selectCustomers = state=> state.customers.customers