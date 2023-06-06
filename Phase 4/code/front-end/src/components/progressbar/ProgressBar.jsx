import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { clearCustomer, selectCustomer } from "../../redux/features/customer/customerSlice";
import { clearCart, selectAllCartItems } from "../../redux/features/cart/cartSlice";
import axios from "axios";
import { v4 as uuid } from "uuid";
import { useRef } from "react";
import { selectAuth } from "../../redux/features/auth/authSlice";
const ProgressBar = () => {
  const [progress, setProgress] = useState(0);
  const customer = useSelector(selectCustomer);
  const cartItems = useSelector(selectAllCartItems);
  const effectRanRef = useRef(false);
      const auth = useSelector(selectAuth);

    const navigate = useNavigate();
  const dispatch = useDispatch();
  

  const createOrder = async () => {
    const URL = "http://localhost:8080/api/orders";
    const order = {
      order_number: uuid(),
      customer: customer,
      order_items: [
        ...cartItems.map((item) => {
          return {
            food_name: item.name,
            unit_price: item.price,
            quantity: item.quantity,
          };
        }),
      ],
    };
    try {
      const { data } = await axios.post(URL, order, {
        ...auth.config, "Content-Type":"application/json"
      });
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    if (!effectRanRef.current) {
      createOrder();
    }
      effectRanRef.current=true;
  }, []);

  useEffect(() => {
    const intervalId = setInterval(() => {
      if (progress !== 100) {
        setProgress(progress + 20);
      }
      if (progress > 99) {
         
          dispatch(clearCart());
        dispatch(clearCustomer())
        navigate("/");
      }
    }, 800);
    return () => clearInterval(intervalId);
  }, [progress]);

  return (
    <main className="container">
      <section className="row">
        <div className="col-sm-12 col-md-10 col-lg-10 col-xl-10 offset-md-1 offset-lg-1 offset-xl-1">
          <div className="row gx-1">
            {progress !== 100 ? (
              <>
                <h3 className="my-5">Dummy Payment Gateway</h3>
                <label htmlFor="progress" className="d-block">
                  Processing payment from account number :
                  <span className="badge bg-warning">{customer.account_number}</span>
                </label>
                <progress
                  id="progress"
                  value={progress}
                  max={100}
                  className="py-3 px-5"
                >
                  20%
                </progress>
              </>
            ) : (
              <>
                <h3 className="my-5 text-success">
                  Order Successfully Placed!
                </h3>
                <label htmlFor="progress" className="d-block">
                  Redirecting you to homepage...
                </label>
              </>
            )}
          </div>
        </div>
      </section>
    </main>
  );
};
export default ProgressBar;
