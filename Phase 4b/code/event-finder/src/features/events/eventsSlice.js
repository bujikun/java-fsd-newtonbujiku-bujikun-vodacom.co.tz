import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { useSelector } from "react-redux";
import { BASE_URL } from "../constants";

const initialState = {
  items: [],
  status: "idle",
  error: null,
    deleteStatus: null,
    searchResult: [],
  searchStatus:"idle"
};


const fetchEvents = createAsyncThunk("events/fetchEvents", async () => {
  try {
    const { data } = await axios.get(`${BASE_URL}/events`);
    return data;
  } catch (error) {
    console.log(error);
  }
});

const deleteEventById = createAsyncThunk(
  "events/deleteEventById",
  async (id) => {
    try {
      const { data } = await axios.delete(`${BASE_URL}/events/${id}`);
      console.log(data);
    } catch (error) {
      console.log(error);
    }
  }
);

const createEvent = createAsyncThunk("events/createEvent", async (event) => {
  try {
    const { data } = await axios.post(`${BASE_URL}/events`, event, {
      headers: {
        "Content-Type": "application/json",
      },
    });
      return data;
  } catch (error) {
    console.log(error);
  }
});

const searchEvent = createAsyncThunk("events/searchEvent", async (queryString) => {
    try {

      const { data } = await axios.get(`${BASE_URL}/events?q=${queryString}`);
      return data;
  } catch (error) {
    console.log(error);
  }
});

const eventsSlice = createSlice({
  name: "events",
  initialState,
    reducers: {
        clearSearchResult: (state, action) => {
            state.searchResult = []
      }
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchEvents.pending, (state, action) => {
        state.status = "loading";
      })
      .addCase(fetchEvents.fulfilled, (state, action) => {
        state.status = "succeeded";
        state.items = action.payload;
      })
      .addCase(fetchEvents.rejected, (state, action) => {
        state.status = "failed";
        state.error = action.error.message;
      })
      .addCase(deleteEventById.pending, (state, action) => {
        state.deleteStatus = "loading";
      })
      .addCase(deleteEventById.fulfilled, (state, action) => {
        state.deleteStatus = "succeeded";
      })
      .addCase(deleteEventById.rejected, (state, action) => {
        state.deleteStatus = "failed";
        state.error = action.error.message;
      })
      .addCase(searchEvent.fulfilled, (state, action) => {
          state.searchStatus = "fulfilled";
          state.searchResult = action.payload;
          console.log("SEARCHING", action.payload);

      })
  },
});
const eventsReducer = eventsSlice.reducer;
export default eventsReducer;
export const selectEventStatus = () =>
  useSelector((state) => state.events.status);
export const selectDeleteStatus = () =>
    useSelector((state) => state.events.deleteStatus);
  export const selectSearchStatus = () =>
    useSelector((state) => state.events.searchStatus);
export const selectAllEvents = () => useSelector((state) => state.events.items);
export const selectCurrentItem = () =>
    useSelector((state) => state.events.currentItem);
  export const selectSearchResult = ()=>useSelector(state=>state.events.searchResult)
export { createEvent, fetchEvents, deleteEventById, searchEvent };
    
    export const{clearSearchResult} = eventsSlice.actions;
    
