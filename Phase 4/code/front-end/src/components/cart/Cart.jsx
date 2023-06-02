import { useSelector } from "react-redux";
import { selectAllCartItems } from "../../redux/features/cart/cartSlice";

const Cart = () => {
  const cartItems = useSelector(selectAllCartItems);
  console.log(cartItems);
  return (
    <div
      className="my-4 d-flex flex-column justify-content- align-items-center"
      style={{ width: "100%" }}
    >
      <span className="display-6">Items</span>
      <div className="list-group my-3">
        {cartItems.map((item, index) => (
          <div
            key={item.id}
            className={
              "list-group-item " +
              (index % 2 === 0 ? "" : "list-group-item-success")
            }
          >
            <span className="d-inline-block me-3 px-3">{index + 1}.</span>
            <span className="d-inline-block me-3 px-3">{item.name}</span>
            <span className="d-inline-block me-3 px-3">${item.price}</span>
            <span className="d-inline-block me-3 px-3">({item.quantity})</span>
            <div className="d-inline-block me-3 px-2 bg-danger"
              style={{
                "color": "white",
                "borderRadius":"20px"
              }}>X</div>
          </div>
        ))}
      </div>
    </div>
  );
};
export default Cart;
