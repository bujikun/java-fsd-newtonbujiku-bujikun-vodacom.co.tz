import FoodList from "../food_list/SearchResultList";
import SearchBar from "../search/SearchBar";
import "./home.css";

const Home = () => {
    return (
      <main className="container">
        <section className="home">
          <div className="row">
            <div className="col-sm-12 col-md-10 col-lg-10 col-xl-10 offset-md-1 offset-lg-1 offset-xl-1">
              <div className="header">
                <span className="display-6">Welcome to Kitchen Stories</span>
                <p className="my-3">
                  We serve a wide range of tasty food items. Use the search box
                  below to search for an item you like or feel free to browse
                  our catalog of Food Items from the navigation bar
                </p>
              </div>
              <SearchBar />
              <FoodList />
            </div>
          </div>
        </section>
      </main>
    );
};
export default Home;
