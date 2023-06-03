import { Outlet } from "react-router-dom";
import AdminNavBar from "./AdminNavBar";

const AdminLayout = () => {
  return (
    <main className="container">
      <header className="mb-5">
        <AdminNavBar />
      </header>
      <div className="row">
        <div className="col-sm-12 col-md-10 col-lg-8 col-xl-8">
          <Outlet />
        </div>
      </div>
    </main>
  );
};
export default AdminLayout;
