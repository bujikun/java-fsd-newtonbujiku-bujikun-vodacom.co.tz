import { HowToRegOutlined, LoginOutlined, Search } from "@mui/icons-material";
import { AppBar, Box, Button, Toolbar,Typography } from "@mui/material"
import { useNavigate } from "react-router-dom";

const AppSearchBar = () => {
    const navigate = useNavigate();
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
          >
            Search...
          </Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
export default AppSearchBar