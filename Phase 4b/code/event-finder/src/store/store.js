import { configureStore } from "@reduxjs/toolkit";
import eventsReducer from '../features/events/eventsSlice'
import authReducer from '../features/auth/authSlice'
const store = configureStore({
    reducer: {
        events: eventsReducer,
        auth:authReducer,
    }
})

export default store;

const arr = [
  {
    id: 1,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 2,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 3,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 4,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 5,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 6,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 7,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
  {
    id: 8,
    name: "UEFA Champions League Final",
    description:
      "The 2023 UCL final which climaxes a football season in Europe",
    location: "Ataturk, Turkey",
    date: "10 May 2023",
    created_by: "admin",
    img: "https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg",
  },
]