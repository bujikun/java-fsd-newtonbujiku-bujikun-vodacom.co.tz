import { useSelector } from "react-redux";
import CustomerDetails from "../customer/CustomerDetails";
import OrderItems from "./OrderItems";
import { selectCustomer } from "../../redux/features/customer/customerSlice";
import { selectAllCartItems } from "../../redux/features/cart/cartSlice";
import { Link } from "react-router-dom";

const OrderDetails = () => {
    const customer = useSelector(selectCustomer);
    const cartItems = useSelector(selectAllCartItems);

    if (!customer || cartItems.length <= 0) {
        return <div className="my-5">
            <span className="display-6 text-danger">No Order to Be Made !!!</span>
        </div>
    }
  return (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
                 <CustomerDetails />
                  <OrderItems />
                  <div>
                      <Link to={""} className="btn btn-lg btn-primary">Make Payment</Link >
                  </div>
        </div>
      </section>
    </main>
  );
};
export default OrderDetails;
