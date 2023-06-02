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
    e.target.className =
      "list-group-item list-group-item-action list-group-item-success";
  };
  const handleMouseLeave = (e) => {
    e.target.className = "list-group-item list-group-item-action";
  };
  return (
    <div className="my-2">
      <div className="list-group">
        {foods.map((food) => (
          <div
            className="list-group-item list-group-item-action"
            style={{"cursor":"pointer"}}
            key={food.id}
            value={food.id}
            onMouseEnter={(e) => handleMouseEnter(e)}
            onMouseLeave={(e) => handleMouseLeave(e)}
            onClick={() => handleClick(food.id)}
          >{`${food.name} --- $${food.price}`}</div>
        ))}
      </div>
    </div>
  );
};
export default FoodList;
