import "./App.css";
import "@fontsource/roboto/300.css";
import "@fontsource/roboto/400.css";
import "@fontsource/roboto/500.css";
import "@fontsource/roboto/700.css";

import { Routes, Route, BrowserRouter } from "react-router-dom";
import Home from "./components/Home";
import EventDetails from "./components/events/EventDetails";
import AppLayout from "./components/layout/AppLayout";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AppLayout/>}>
          <Route index element={<Home />} />
          <Route path="events/view/:id" element={<EventDetails />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
