import { useDispatch, useSelector } from "react-redux";
import "./food_list.css";
import { selectAvailableFoods } from "../../redux/features/foods/foodSlice";
import { addToCart } from "../../redux/features/cart/cartSlice";

const FoodList = () => {
  const foods = useSelector(selectAvailableFoods);
  const dispatch = useDispatch();
  const handleClick = (id) => {
    const food = foods.find((food) => food.id === id);
    dispatch(addToCart(food));
  }
  const handleMouseEnter = (e) => {
    
  };
  const handleMouseLeave = (e) => {
  };
  return (
    <div className="my-2">
      <div className="list-group">
        {foods.map((food) => (
          <div
            className="list-group-item list-group-item-action list-group-item-success"
            style={{ cursor: "pointer" }}
            key={food.id}
            value={food.id}
            onClick={() => handleClick(food.id)}
          >
            <div className="d-flex justify-content-start align-items-center">
              <div className="mx-3 me-5">
                <img
                  src={`${food.img_url}`}
                  width={50}
                  height={50}
                  alt={food.name}
                  style={{borderRadius:"50px"}}
                />
              </div>
              {console.log(food.img_url)}
              <div className="ms-5">{`${food.name} @ $${food.price}`}</div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
export default FoodList;
