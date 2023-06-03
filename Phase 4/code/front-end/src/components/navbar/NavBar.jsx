import { Link } from "react-router-dom";
import "./navbar.css";
import { useSelector } from "react-redux";
import { selectAllCartItems } from "../../redux/features/cart/cartSlice";
const NavBar = () => {
    const cartItems = useSelector(selectAllCartItems);
    let total = 0;
    cartItems.forEach(item => {
        total += item.quantity;
    });
  return (
    <nav className="navbar bg-light">
      <div className="navbar-content">
        <div className="brand">Kitchen Stories</div>
        <div className="navbar-items">
          <div className="navbar-item">
            <Link to={"/"}>Home</Link>
          </div>
          <div className="navbar-item">
            <Link to={"/food-items"}>Food Items</Link>
          </div>
          <div className="navbar-item">
            <Link to={"/cart"}>
                          Cart <span className="badge bg-danger">{ total}</span>
            </Link>
          </div>
          
        </div>
      </div>
    </nav>
  );
};
export default NavBar;
