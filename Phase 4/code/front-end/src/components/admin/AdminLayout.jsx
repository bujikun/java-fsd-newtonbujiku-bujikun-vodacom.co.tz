import { Outlet } from "react-router-dom";
import AdminNavBar from "./AdminNavBar";

const AdminLayout = () => {
  return (
    <main className="container">
      <header className="mb-5">
        <AdminNavBar />
      </header>
      <div className="row">
        <div className="col-sm-12 col-md-12 col-lg-12 col-xl-12">
          <Outlet />
        </div>
      </div>
    </main>
  );
};
export default AdminLayout;
