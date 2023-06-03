import { useSelector } from "react-redux";
import { Navigate, Outlet } from "react-router-dom";
import { selectAuth } from "../../redux/features/auth/authSlice";

const AdminRoutes = () => {
  const auth = useSelector(selectAuth);
  console.log(auth);
  return (
    (auth.isLoggedIn)?<Outlet/>:<Navigate to="/login" replace/>
  )
}
export default AdminRoutes