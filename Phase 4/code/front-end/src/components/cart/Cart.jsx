import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import {
  clearCart,
  removeCartItem,
  selectAllCartItems,
} from "../../redux/features/cart/cartSlice";
const Cart = () => {
  const cartItems = useSelector(selectAllCartItems);
  const dispatch = useDispatch();
  let totalPrice = 0;
  cartItems.forEach((item) => {
    const itemTotal = item.quantity * item.price;
    totalPrice += itemTotal;
  });
  return cartItems.length === 0 ? (
    <div className="my-5">
      <span className="display-6 text-danger">No items in the cart!</span>
    </div>
  ) : (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
          <div
            className="d-flex justify-content-between align-items-center"
            style={{ width: "80%" }}
          >
            <div className="">
              <span className="display-6">Cart Items</span>
            </div>
            <div className="">
              <Link className="btn btn-success me-2 my-1" type="button" to={"/register-customer"}>Checkout</Link>
              <button
                className="btn btn-danger me-2"
                onClick={()=>dispatch(clearCart())}
              >
                Clear Cart
              </button>
            </div>
          </div>
        </div>
        <div className="col-sm-12 col-md-10 col-lg-10 col-xl-10 offset-md-1 offset-lg-1 offset-xl-1">
          <div>
            <table className="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>Index</th>
                  <th>Food Name</th>
                  <th>Quantity</th>
                  <th>Remove</th>
                </tr>
              </thead>
              <tbody>
                {cartItems.map((item, index) => (
                  <tr key={item.id}>
                    <td>{index + 1}</td>
                    <td>{item.name}</td>
                    <td>{item.quantity}</td>
                    <td>
                      <div
                        className="d-inline-block me-3 px-2 bg-danger"
                        style={{
                          color: "white",
                          borderRadius: "20px",
                          cursor: "pointer",
                          fontWeight: "600",
                        }}
                        onClick={() => dispatch(removeCartItem(item.id))}
                      >
                        X
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
              <tfoot>
                <tr>
                  <td
                    colSpan={4}
                    className="text-success"
                    style={{ fontWeight: "600", fontSize: "1.5rem" }}
                  >
                    <span>Total: </span>{" "}
                    <span className="px-4">${totalPrice.toFixed(2)}</span>
                  </td>
                </tr>
              </tfoot>
            </table>
          </div>
        </div>
      </section>
    </main>
  );
};
export default Cart;
