import { Link, useNavigate } from "react-router-dom"
import './style.css'
import { useDispatch } from "react-redux"
import {userHasLoggedOut } from "../../redux/features/auth/authSlice"
const AdminNavBar = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const doLogOut = () => {
    dispatch(
      userHasLoggedOut({
        user: {},
        token: "",
        config: {},
      })
    );
navigate("/admin");
  }
  return (
    <nav className="navbar bg-light">
      <div className="navbar-content">
        <div className="brand">Admin Console</div>
        <div className="navbar-items">
          <div className="navbar-item">
            <Link to={"/admin/orders"}>Orders</Link>
          </div>
          <div className="navbar-item">
            <Link to={"/admin/customers"}>Customers</Link>
          </div>
          <div className="navbar-item">
            <Link to={"/admin/food-stock"}>Food Stock</Link>
          </div>
          <div className="navbar-item">
            <Link to={"/admin/change-password"}>Change Password</Link>
          </div>
          <div className="navbar-item-logout">
            <Link onClick={doLogOut}>Log Out</Link>
          </div>
        </div>
      </div>
    </nav>
  );
}
export default AdminNavBar