import { createSlice } from "@reduxjs/toolkit"

const initialState = {
  auth: {
    isLoggedIn: false,
    user: {},
    token: "",
    config: {
      
    }
  },
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    isLoggedIn(state, action) {
      state.auth.isLoggedIn = action.payload;
    },
    tokenIsReceived(state, action) {
      state.auth.token = action.payload;
    },
    configIsCreated(state, action){
  state.auth.config = action.payload;
    }
  },
});

export const authReducer = authSlice.reducer;
export const {isLoggedIn,tokenIsReceived,configIsCreated} = authSlice.actions;
export const selectAuth = state=>state.auth.auth