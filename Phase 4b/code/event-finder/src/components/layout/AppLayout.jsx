import { Outlet } from "react-router-dom";
import AppSearchBar from "../bar/AppSearchBar";
import { CssBaseline } from "@mui/material";

const AppLayout = () => {
  return (
    <div>
      <CssBaseline>
        <AppSearchBar />
        <Outlet />
      </CssBaseline>
    </div>
  );
};
export default AppLayout;
