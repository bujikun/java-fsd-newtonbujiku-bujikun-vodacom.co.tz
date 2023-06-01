import { useSelector } from "react-redux";
import "./food_list.css";
import { selectAvailableFoods } from "../../redux/features/foods/foodSlice";
import { Link } from "react-router-dom";

const FoodList = () => {
  const foods = useSelector(selectAvailableFoods);
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
          <Link
            className="list-group-item list-group-item-action"
            key={food.id}
            to={`/foods/${food.id}`}
            onMouseEnter={(e) => handleMouseEnter(e)}
            onMouseLeave={(e) => handleMouseLeave(e)}
          >{`${food.name} --- $${food.price}`}</Link>
        ))}
      </div>
    </div>
  );
};
export default FoodList;
