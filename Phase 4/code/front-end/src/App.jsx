import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route } from "react-router-dom";
import Home from "./components/home/Home";
import FoodItems from "./components/food_items/FoodItems";
import Cart from "./components/cart/Cart.jsx";
import CustomerForm from "./components/customer/CustomerForm";
import OrderDetails from "./components/order/OrderDetails";
import ProgressBar from "./components/progressbar/ProgressBar";
import AdminRoutes from "./components/admin/AdminRoutes";
import Login from "./components/admin/Login";
import Dashboard from "./components/admin/Dashboard";
import PublicLayout from "./components/public/PublicLayout";
import AdminLayout from "./components/admin/AdminLayout";
import FoodStock from "./components/admin/FoodStock";
function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<PublicLayout />}>
          <Route index element={<Home />} />
          <Route path="/food-items" element={<FoodItems />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/foods/:id" element={<div>Book</div>} />
          <Route path="/register-customer" element={<CustomerForm />} />
          <Route path="/order-details" element={<OrderDetails />} />
          <Route path="/payment" element={<ProgressBar />} />
        </Route>
        <Route element={<AdminRoutes />} path="/admin">
          <Route element={<AdminLayout/>} path="">
          <Route element={<Dashboard />} index />
          <Route element={<FoodStock />} path="food-stock" />

          </Route>
        </Route>
        <Route element={<Login />} path="/login" />
      </Routes>
    </>
  );
}

export default App;
