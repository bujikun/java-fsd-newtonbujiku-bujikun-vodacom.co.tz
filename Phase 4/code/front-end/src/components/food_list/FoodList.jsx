import { useSelector } from "react-redux";
import "./food_list.css";
import { selectAvailableFoods } from "../../redux/features/foods/foodSlice";

const FoodList = () => {
    const foods = useSelector(selectAvailableFoods);
  return (
    <div className="my-2">
      <ol className="list-group">
        {foods.map((food) => (
          <li
            className="list-group-item list-group-item-action 
          list-group-item-success"
            key={food.id}
          >
            {food.name}
          </li>
        ))}
      </ol>
    </div>
  );
};
export default FoodList;
