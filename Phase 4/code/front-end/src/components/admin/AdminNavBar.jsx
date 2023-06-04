import { Link } from "react-router-dom"
import './style.css'
const AdminNavBar = () => {
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
          <div className="navbar-item-logout">
            <Link to={"/admin/food-stock"}>Log Out</Link>
          </div>
        </div>
      </div>
    </nav>
  );
}
export default AdminNavBar