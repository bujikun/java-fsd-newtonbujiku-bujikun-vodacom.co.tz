import { useDispatch, useSelector } from "react-redux";
import { addFoodItems, selectAvailableFoods } from "../../redux/features/foods/foodSlice";
import axios from "axios";
import { addToCart } from "../../redux/features/cart/cartSlice";
import { useEffect } from "react";
import './style.css'

const URL = "http://localhost:8080/api/foods";
const FoodItems = () => {
  const foodItems = useSelector(selectAvailableFoods);
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
    <main className="container">
      <section className="home">
        <div className="row">
          <div className="">
            <div className="my-4">
              <h1>Available Food Items in the Kitchen</h1>
            </div>
            <div className="row">
              <div className="mx-3">
                {foodItems.map((food) => (
                  <div
                    className="card d-inline-block m-2"
                    style={{ maxWidth: "300px" }}
                    key={food.id}
                  >
                    <img
                      src={"https://placehold.co/600x400"}
                            className="card-img-top"
                            width={300}
                            height={200}
                      alt={food.name}
                    />
                    <div className="card-body">
                      <h5 className="card-title">{food.name}</h5>
                      <p className="card-text">
                        <span style={{fontWeight:900}}>{`$${food.price}`}</span>
                      </p>
                            <button href="#" className="btn btn-outline-success"
                            onClick={()=>dispatch(addToCart(food))}
                            >
                        Add to Cart
                      </button>
                    </div>
                  </div>
                ))}
              </div>
              {/* <div className="col-sm-10 col-md-3  ms-2 my-2 bg-primary">2</div>
              <div className="col-sm-10 col-md-3  ms-2 my-2 bg-info">3</div> */}
            </div>
          </div>
        </div>
      </section>
    </main>
  );
};
export default FoodItems;
