import { createSlice } from "@reduxjs/toolkit";

const initialState = [
  {
    id: 1,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 2,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 3,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 4,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 5,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 6,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 7,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
  {
    id: 8,
    name: "Chips",
    quantity: 20,
    price: 20.32,
    imageUrl: "string",
    version: 0,
    createdOn: "2023-06-01T09:24:42.946",
    updatedOn: "2023-06-01T09:24:42.946",
  },
];
const foodSlice = createSlice({
    name: "foods",
    initialState,
    reducers: {
        addFoods(state, action) {
            state.foods = action.payload;
       } 
    } 
});

export const { addFoods } = foodSlice.actions
export const foodReducer = foodSlice.reducer;
export const selectAvailableFoods = state=> state.foods
