import { createSlice } from "@reduxjs/toolkit"

const initialState = {
  auth: {
    isLoggedIn: false,
    user: {},
    token: {},
  },
};

const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        isLoggedIn(state, action) {
            state.auth.isLoggedIn = action.payload;
        }
    }
})

export const authReducer = authSlice.reducer;
export const {isLoggedIn} = authSlice.actions;
export const selectAuth = state=>state.auth.auth