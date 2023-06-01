import FoodList from "../food_list/FoodList";
import SearchBar from "../search/SearchBar";
import "./home.css";

const Home = () => {
  return (
    <section className="home">
      <div className="row">
        <div className="col-sm-12 col-md-10 col-lg-10 col-xl-10 offset-md-1 offset-lg-1 offset-xl-1">
          <div className="header">
            <h1>Kitchen Stories</h1>
          </div>
          <SearchBar />
          <FoodList />
        </div>
      </div>
    </section>
  );
};
export default Home;
