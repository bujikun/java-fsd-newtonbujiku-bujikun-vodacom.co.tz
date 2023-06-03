import axios from "axios";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { addFoodItems,clearFoodItems } from "../../redux/features/foods/foodSlice";
const url = "http://localhost:8080/api/foods/search?name=";
const SearchBar = () => {
  const [query, setQuery] = useState("");
  const dispatch = useDispatch();

  useEffect(() => {
    const fetchData = async () => {
      try {
          const {data} = await axios.get(url + query);
        dispatch(addFoodItems(data));
      } catch (error) {
        console.error(error);
      }
    };
      if (query.trim()==="") {
          dispatch(clearFoodItems([]));
          return;
      }
      fetchData();
  }, [query]);

  const handleChange = (e) => {
    setQuery(e.target.value);
  };

  return (
    <div>
      <form onSubmit={(e) => e.preventDefault()}>
        <div className="form-group my-3">
          <label htmlFor="search"></label>
          <input
            style={{ border: "2px solid #333" }}
            type="text"
            className="form-control form-control-lg"
            name="search"
            id="search"
            value={query}
                      onChange={(e) => handleChange(e)}
                      placeholder="Search for  food item(s)"
          />
        </div>
      </form>
    </div>
  );
};
export default SearchBar;
