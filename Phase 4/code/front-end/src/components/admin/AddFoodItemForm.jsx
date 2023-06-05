import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {  useNavigate } from "react-router-dom";
import { selectAuth } from "../../redux/features/auth/authSlice";

const URL = "http://localhost:8080/api/foods"

const initialFoodItem = {
  name: "",
  price: 0,
  img_url: "",  
};


const AddFoodItemForm = () => {
  const [isAddingNewItem, setIsAddingNewItem] = useState(false);
  const [foodItem, setFoodItem] = useState(initialFoodItem);
  const auth = useSelector(selectAuth)
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const isValidFoodItem =
    Boolean(foodItem.name) && Boolean(foodItem.price)
    && Boolean(foodItem.img_url);

  useEffect(() => {
    if (isAddingNewItem) {
      createFoodItem();
    }
  }, [isAddingNewItem]);
  
  const handleChange = (e) => {
    setFoodItem({
      ...foodItem,
      [e.target.name]:(e.target.name === "price")?e.target.value: String(e.target.value).trim(),
    });
  };

  const createFoodItem = async() => {
    try {
      const { status } = await axios.post(URL, foodItem, {
        ...auth.config,
        "Content-Type": "application/json",
      });
      if (status == 201) {
     }
    } catch (error) {
      console.error(error);
    }
  }

  const handleAddClick = () => {
    //sendtoserver
    setIsAddingNewItem(true);
    navigate(-1);

  };

  return (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
          <form
            onSubmit={(e) => {
              e.preventDefault();
            }}
          >
            <div className="my-2">
              <span className="display-6">Add Food Item</span>
            </div>
            <div className="form-floating mb-3">
              <input
                type="text"
                className="form-control"
                id="name"
                name="name"
                value={foodItem.name}
                onChange={handleChange}
              />
              <label htmlFor="name">Name</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="number"
                className="form-control"
                id="price"
                name="price"
                step={0.01}
                value={foodItem.price}
                onChange={handleChange}
              />
              <label htmlFor="price">Price($)</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="text"
                className="form-control"
                id="img_url"
                name="img_url"
                value={foodItem.img_url}
                onChange={handleChange}
              />
              <label htmlFor="img_url">Image (absolute url)</label>
            </div>
            <div className="d-flex justify-content-end mb-3">
              <button
                className="btn btn-lg btn-success"
                onClick={handleAddClick}
                disabled={!isValidFoodItem}
              >
                Add
              </button>
            </div>
          </form>
        </div>
      </section>
    </main>
  );
};
export default AddFoodItemForm;
