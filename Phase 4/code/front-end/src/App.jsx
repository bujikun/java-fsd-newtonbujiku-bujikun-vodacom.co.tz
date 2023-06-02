import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes,Route } from "react-router-dom";
import Home from "./components/home/Home";
import FoodItems from "./components/food_items/FoodItems";
import NavBar from "./components/navbar/NavBar";
import Cart from "./components/cart/Cart.jsx";
import CustomerForm from "./components/customer/CustomerForm";
import OrderDetails from "./components/order/OrderDetails";
function App() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/food-items" element={<FoodItems />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/foods/:id" element={<div>Book</div>} />
        <Route path="/register-customer" element={<CustomerForm />} />
        <Route path="/order-details" element={<OrderDetails />} />
      </Routes>
    </>
  );
}

export default App;
