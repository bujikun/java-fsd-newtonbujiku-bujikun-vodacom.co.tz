import FoodList from "../food_list/FoodList";
import SearchBar from "../search/SearchBar";
import "./home.css";

const Home = () => {
  return (
    <section className="home">
      <div className="row">
        <div className="col-sm-12 col-md-8 col-lg-8 col-xl-8 offset-md-2 offset-lg-2 offset-xl-2">
          <h1>Kitchen Stories</h1>
                  <SearchBar />
                  <FoodList/>
        </div>
      </div>
    </section>
  );
};
export default Home;
