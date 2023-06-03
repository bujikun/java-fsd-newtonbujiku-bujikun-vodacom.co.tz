import { Navigate, Outlet } from "react-router-dom";

const AdminRoutes = () => {
    const isLoggedIn = false;
  return (
    (isLoggedIn)?<Outlet/>:<Navigate to="/login" replace/>
  )
}
export default AdminRoutes