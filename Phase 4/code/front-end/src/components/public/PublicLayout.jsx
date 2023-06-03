import { Outlet } from "react-router-dom"
import NavBar from "../navbar/NavBar"

const PublicLayout = () => {
  return (
    <>
      <NavBar />
      <Outlet />
    </>
  );
}
export default PublicLayout