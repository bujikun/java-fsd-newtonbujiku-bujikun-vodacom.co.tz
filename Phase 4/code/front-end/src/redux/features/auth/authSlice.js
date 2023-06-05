import { createSlice } from "@reduxjs/toolkit"

const initialState = {
  auth: {
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
    userIsLoggedIn(state, action) {
      state.auth.user = action.payload;
    },
    tokenIsReceived(state, action) {
      state.auth.token = action.payload;
    },
    configIsCreated(state, action){
  state.auth.config = action.payload;
    },
    userHasLoggedOut(state, action) {
      state.auth = action.payload;
    }
  },
});

export const authReducer = authSlice.reducer;
export const {userIsLoggedIn,tokenIsReceived,configIsCreated,userHasLoggedOut} = authSlice.actions;
export const selectAuth = state=>state.auth.auth