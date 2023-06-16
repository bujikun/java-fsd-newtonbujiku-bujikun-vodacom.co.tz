import {
  Event,
  HowToRegOutlined,
  LoginOutlined,
  LogoutOutlined,
  Search,
} from "@mui/icons-material";
import { AppBar, Box, Button, Toolbar, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";
import SearchDialog from "../dialog/SearchDialog";
import { logout, selectIsLoggedIn } from "../../features/auth/authSlice";
import { useDispatch } from "react-redux";
import { useState } from "react";

const AppSearchBar = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
    const isLoggedIn = selectIsLoggedIn();
    const [isSearchDialogOpen,setIsSearchDialogIsOpen] = useState(false);
  return (
    <Box flexGrow={1}>
      <AppBar position="sticky">
        <Toolbar>
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{
              flexGrow: 1,
              display: { xs: "none", sm: "block" },
              cursor: "pointer",
            }}
            onClick={() => {
              navigate("/");
            }}
          >
            Event Finder
          </Typography>
          <Button
            variant="outlined"
            color="primary"
            startIcon={<Search />}
            sx={{
              textTransform: "capitalize",
              color: "white",
              ml: 2,
              ":hover": {
                bgcolor: "white",
                color: "#333",
              },
            }}
                      onClick={()=>setIsSearchDialogIsOpen(true)}
          >
            Search...
          </Button>
          {!isLoggedIn && (
            <Button
              color="inherit"
              variant="outlined"
              startIcon={<LoginOutlined />}
              sx={{
                textTransform: "capitalize",
                color: "white",
                ml: 2,
                ":hover": {
                  bgcolor: "white",
                  color: "#333",
                },
              }}
              onClick={() => navigate("/users/login")}
            >
              Login
            </Button>
          )}
          {!isLoggedIn && (
            <Button
              color="inherit"
              variant="outlined"
              startIcon={<HowToRegOutlined />}
              sx={{
                textTransform: "capitalize",
                color: "white",
                ml: 2,
                ":hover": {
                  bgcolor: "white",
                  color: "#333",
                },
              }}
              onClick={() => navigate("/users/register")}
            >
              Register
            </Button>
          )}
          {isLoggedIn && (
            <Button
              color="inherit"
              variant="outlined"
              startIcon={<Event />}
              sx={{
                textTransform: "capitalize",
                color: "white",
                ml: 2,
                ":hover": {
                  bgcolor: "white",
                  color: "#333",
                },
              }}
              onClick={() => navigate("/events/create")}
            >
              Create Event
            </Button>
          )}
          {isLoggedIn && (
            <Button
              color="inherit"
              variant="outlined"
              startIcon={<LogoutOutlined />}
              sx={{
                textTransform: "capitalize",
                color: "white",
                ml: 2,
                ":hover": {
                  bgcolor: "white",
                  color: "#333",
                },
              }}
              onClick={() => {
                dispatch(logout());
                navigate("/");
              }}
            >
              Logout
            </Button>
          )}
        </Toolbar>
      </AppBar>
          {isSearchDialogOpen && <SearchDialog isOpen={isSearchDialogOpen} setIsSearchDialogIsOpen={setIsSearchDialogIsOpen} />}
    </Box>
  );
};
export default AppSearchBar;
