import { useSelector } from "react-redux";
import { selectAllCartItems } from "../../redux/features/cart/cartSlice";
const OrderItems = () => {
    const cartItems = useSelector(selectAllCartItems);
     let totalPrice = 0;
     cartItems.forEach((item) => {
       const itemTotal = item.quantity * item.price;
       totalPrice += itemTotal;
     });
    return (
      <>
        <div
          className="d-flex justify-content-between align-items-center"
          style={{ width: "80%" }}
        >
          <div className="my-3">
            <span className="h5">Order Items</span>
          </div>
        </div>
        <div className="col-sm-12 col-md-10 col-lg-10 col-xl-10 offset-md-1 offset-lg-1 offset-xl-1">
          <div>
            <table className="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th></th>
                  <th>Food Name</th>
                  <th>Quantity</th>
                </tr>
              </thead>
              <tbody>
                {cartItems.map((item) => (
                  <tr key={item.id}>
                    <td>
                      <img
                        src={`${item.img_url}`}
                        width={50}
                        height={50}
                        alt={item.name}
                        style={{ borderRadius: "50px" }}
                      />
                    </td>
                    <td>{item.name}</td>
                    <td>{item.quantity}</td>
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
      </>
    );
};
export default OrderItems