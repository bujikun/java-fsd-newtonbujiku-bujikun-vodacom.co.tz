import { useSelector, useDispatch } from "react-redux";
import {
  selectAvailableFoods,
  addFoodItems,
} from "../../redux/features/foods/foodSlice";
import axios from "axios";
import { useEffect } from "react";
const FoodStock = () => {
  const URL = "http://localhost:8080/api/foods";
  const foodStock = useSelector(selectAvailableFoods);
  const dispatch = useDispatch();
  const fetchFoodItems = async () => {
    try {
      const { data } = await axios.get(URL);
      dispatch(addFoodItems(data));
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    fetchFoodItems();
  }, []);
  return (
    <div>
      <div>
        <span className="display-6">Available food items in stock</span>
      </div>
      <div>
        <table className="table table-striped table-bordeless table-hover">
          <thead>
            <tr>
              <th>Image</th>
              <th>Name</th>
              <th>Price</th>
              <th>Added On</th>
              <th>Remove</th>
            </tr>
          </thead>
          <tbody>
            {foodStock.map((item) => (
              <tr key={item.id}>
                <td>
                  <img
                    src={"https://placehold.co/600x400"}
                    className="card-img-top"
                    width={75}
                    height={50}
                    alt={item.name}
                  />
                </td>
                <td>{item.name}</td>
                <td>${item.price}</td>
                <td>{item.created_on}</td>

                <td>
                  <div
                    className="d-inline-block me-3 px-2 bg-danger"
                    style={{
                      color: "white",
                      borderRadius: "20px",
                      cursor: "pointer",
                      fontWeight: "600",
                    }}
                    // onClick={() => dispatch(removeCartItem(item.id))}
                  >
                    X
                  </div>
                </td>
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
              </td>
            </tr>
          </tfoot>
        </table>
      </div>
    </div>
  );
};
export default FoodStock;
