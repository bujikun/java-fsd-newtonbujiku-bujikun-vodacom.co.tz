import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { useSelector } from "react-redux";

const BASE_URL = "http://localhost:4000";

const initialState = {
  items: [],
  status: "idle",
    error: null,
    deleteStatus:null
};

const fetchEvents = createAsyncThunk("events/fetchEvents", async () => {
  try {
      const {data} = await axios.get(`${BASE_URL}/events`);
    return data;
  } catch (error) {
    console.log(error);
  }
});

const deleteEventById = createAsyncThunk("events/deleteEventById", async (id) => {
     try {
         const {data } = await axios.delete(`${BASE_URL}/events/${id}`);
          console.log(data);
     } catch (error) {
       console.log(error);
     }
});

const createEvent = createAsyncThunk(
  "events/createEvent",
    async (event) => {
      console.log(event);
    try {
        const { data } = await axios.post(`${BASE_URL}/events`, event,
            {
                headers: {
                "Content-Type":"application/json"
            }
        });
        console.log(data);
    } catch (error) {
      console.log(error);
    }
  }
);



const eventsSlice = createSlice({
  name: "events",
  initialState,
  reducers: {},
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
      });
  },
});



export const selectEventStatus = () =>
    useSelector((state) => state.events.status);
  export const selectDeleteStatus = () =>
    useSelector((state) => state.events.deleteStatus);
export const selectAllEvents = () => useSelector((state) => state.events.items);
export const selectCurrentItem = ()=>useSelector(state=>state.events.currentItem)
export default eventsSlice.reducer;
export { createEvent,fetchEvents, deleteEventById,BASE_URL};


