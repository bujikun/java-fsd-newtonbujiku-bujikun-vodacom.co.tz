import { Link } from 'react-router-dom';
import './navbar.css'
const NavBar = () => {
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
        </div>
      </div>
    </nav>
  );
};
export default NavBar;
