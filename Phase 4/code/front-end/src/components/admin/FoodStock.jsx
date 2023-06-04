import { useSelector, useDispatch } from "react-redux";
import {
  selectAvailableFoods,
  addFoodItems,
  removeFoodItem,
} from "../../redux/features/foods/foodSlice";
import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";
const FoodStock = () => {
  const URL = "http://localhost:8080/api/foods";
    const foodStock = useSelector(selectAvailableFoods);
    const dispatch = useDispatch();
    const [isFoodRemove, setIsFoodRemove] = useState(false);
    const idRef = useRef(null);
  const fetchFoodItems = async () => {
    try {
      const { data } = await axios.get(URL);
      dispatch(addFoodItems(data));
    } catch (error) {
      console.error(error);
    }
  };
    const deleteFoodFromDB = async () => {
         console.log(`${URL}/${idRef.current}`);
       try {
         const { data } = await axios.delete(`${URL}/${idRef.current}`);
        // dispatch(addFoodItems(data));
           console.log(data);
           setIsFoodRemove(false);
       } catch (error) {
         console.error(error);
       }
     };
  useEffect(() => {
    fetchFoodItems();
  }, []);
    
    useEffect(() => {
        console.log(Number(idRef.current));
        if (isFoodRemove && Number(idRef.current)) {
          deleteFoodFromDB();
        }
    }, [isFoodRemove]);
    
    const handleRemoveFoodItem = (id) => {
        idRef.current = id;
        dispatch(removeFoodItem(id));
        setIsFoodRemove(true);
    }
  return (
    <div>
      <div className="mb-5">
        <span className="display-6">Available food items in stock</span>
      </div>
      <div>
        <div className="mt-5">
          <Link className="btn btn-primary me-3" to="/admin/food-stock/add">
    
            Add Food Item
          </Link>
          {/* <button className="btn btn-danger"> Remove All </button> */}
        </div>
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
                    onClick={() => handleRemoveFoodItem(item.id)}
                  >
                    X
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default FoodStock;
