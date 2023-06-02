import { useDispatch, useSelector } from "react-redux";
import { removeCartItem, selectAllCartItems } from "../../redux/features/cart/cartSlice";
const Cart = () => {
  const cartItems = useSelector(selectAllCartItems);
  const dispatch = useDispatch();
  return (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
          <span className="display-6">Cart Items</span>
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
                        onClick={()=>dispatch(removeCartItem(item.id))}
                      >
                        X
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
              <tfoot></tfoot>
            </table>
          </div>
        </div>
      </section>
    </main>
  );
};
export default Cart;
