import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { BASE_URL } from "../constants";
import { useSelector } from "react-redux";
const initialState = {
    user: {
    },
    status:"idle",
    error: null,
    isLoggedIn: false,
    loginFailed:false
}

const registerUser = createAsyncThunk("users/registerUser", async (formData) => {
    try {
        const { data } = axios.post(`${BASE_URL}/users`, formData, {
            headers: {
                "Content-Type":"application/json"
            }
        })
        
        return data;
    } catch (error) {
        console.log(error);
    }
});


const authenticateUser = createAsyncThunk(
  "users/authenticateUsers",
    async (formData) => {
    try {
      const  {data}  = await axios.get(
        `${BASE_URL}/users?username=${formData.username}&password=${formData.password}`
      );
      return data[0];
    } catch (error) {
      console.log(error);
    }
  }
);

const authSlice = createSlice({
    name: "users",
    initialState,
    reducers: {
        
    },
    extraReducers: builder => {
        builder
            .addCase(registerUser.fulfilled, (state, action) => {
                state.user = action.payload;
                state.status = "fulfilled";

            }).addCase(authenticateUser.fulfilled, (state, action) => {
                if (action.payload) {
                                     console.log("PAYLOAD", action.payload);
                  state.user = action.payload;
                  state.status = "fulfilled";
                  state.isLoggedIn = true;
                }
            }).addCase(authenticateUser.rejected, (state, action) => {
                state.status = "rejected";
                state.loginFailed = true;

            })
    }
});


export default authSlice.reducer

export { registerUser,authenticateUser }

export const selectUser = () => useSelector((state) => state.auth.user);
export const selectUserStatus = () => useSelector((state) => state.auth.status);
export const selectIsLoggedIn = () => useSelector((state) => state.auth.isLoggedIn);
