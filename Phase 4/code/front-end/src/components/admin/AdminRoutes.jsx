import { useSelector } from "react-redux";
import { Navigate, Outlet } from "react-router-dom";
import { selectAuth } from "../../redux/features/auth/authSlice";

const AdminRoutes = () => {
  const auth = useSelector(selectAuth);
  return (
    (auth.token)?<Outlet/>:<Navigate to="/login" replace/>
  )
}
export default AdminRoutes