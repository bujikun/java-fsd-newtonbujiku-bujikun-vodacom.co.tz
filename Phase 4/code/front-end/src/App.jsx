import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes,Route } from "react-router-dom";
import Home from "./components/home/Home";
import FoodItems from "./components/food_items/FoodItems";
import NavBar from "./components/navbar/NavBar";
function App() {
  return (
    <>
      <NavBar/>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/food-items" element={<FoodItems />} />
        <Route path="/foods/:id" element={ <div>Book</div> } />
      </Routes>
    </>
  );
}

export default App;
