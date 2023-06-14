import "./App.css";
import "@fontsource/roboto/300.css";
import "@fontsource/roboto/400.css";
import "@fontsource/roboto/500.css";
import "@fontsource/roboto/700.css";

import { Routes, Route, BrowserRouter } from "react-router-dom";
import Home from "./components/Home";
import EventDetails from "./components/events/EventDetails";
import AppLayout from "./components/layout/AppLayout";
import RegistrationForm from "./components/user/RegistrationForm";
import LoginForm from "./components/user/LoginForm";
import EventCreationForm from "./components/events/EventCreationForm";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AppLayout />}>
          <Route index element={<Home />} />
          <Route path="users/register" element={<RegistrationForm />} />
          <Route path="events/create" element={<EventCreationForm />} />
          <Route path="events/view/:id" element={<EventDetails />} />
          <Route path="users/login" element={<LoginForm />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
