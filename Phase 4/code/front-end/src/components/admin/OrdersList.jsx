import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { useSelector } from "react-redux";
import { selectAuth } from "../../redux/features/auth/authSlice";
const OrdersList = () => {
  const URL = "http://localhost:8080/api/orders";
  const [orders, setOrders] = useState([]);
  const auth = useSelector(selectAuth);
  const effectRanRef = useRef(false);

  const fetchOrders = async () => {
    try {
      const { data } = await axios.get(URL,auth.config);
      setOrders(data);
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    if (effectRanRef.current) {
      fetchOrders();
    }
    effectRanRef.current = true;
  }, []);

    if (orders.length <= 0) {
      return (
        <div className="alert alert-danger" role="alert">
          <div className="d-inline-block">
            <strong>Holy Moly!</strong> No orders so far
          </div>
          <div className="d-inline-block"></div>
        </div>
      );
    }

  return (
    <div>
      <div className="mb-5">
        <span className="display-6">Orders</span>
      </div>
      <div>
        <table className="table table-striped table-bordeless table-hover">
          <thead>
            <tr>
              <th>Order No.</th>
              <th>Order Items</th>
              <th>Total Order Items</th>
              <th>Total Price</th>
              <th>Created On</th>
              <th>Customer Name</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => (
              <tr key={order.order_number}>
                <td>{order.order_number}</td>
                <td>
                  {order.order_items.map((item, index, arr) =>
                    arr.length - 1 === index
                      ? item.food_name
                      : item.food_name + " , "
                  )}
                </td>
                <td>
                  {order.order_items.map((item) => Number(item.quantity))
                    .reduce((total, current) => total+current)
                  }
                </td>
                <td>${order.total_price}</td>
                <td>{order.created_on}</td>
                <td>{order.customer_name}</td>

                <td></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default OrdersList;
