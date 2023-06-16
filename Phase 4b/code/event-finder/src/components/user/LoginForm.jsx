import { Container, Box, Typography, TextField, Button } from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import {
  authenticateUser,
  selectIsLoggedIn,
  selectUser,
  selectUserStatus,
} from "../../features/auth/authSlice";
import { useEffect, useState } from "react";
const initialUser = {
  username: "",
  password: "",
};
const LoginForm = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [user, setUser] = useState(initialUser);
  const [isLoggingIn,setIsLoggingIn] = useState(false);
  const isLoggedIn = selectIsLoggedIn();
  const status = selectUserStatus();
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(isLoggedIn);
    setIsLoggingIn(true);
  };

  useEffect(() => {
    if (isLoggedIn) {
      navigate("/");
      return;
    }
    if (isLoggingIn) {
      //navigate("/");
  dispatch(authenticateUser(user));
    }
  }, [isLoggingIn,isLoggedIn]);
  return (
    <Container maxWidth="xs" component="main">
      <Box
        sx={{
          mt: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Typography component="h1" variant="h5">
          User Authentication
        </Typography>
        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid xs={12}>
              <TextField
                name="username"
                type="text"
                required
                fullWidth
                id="username"
                label="Username"
                autoComplete="username"
                value={user.username}
                onChange={(e) =>
                  setUser({ ...user, [e.target.name]: e.target.value })
                }
              />
            </Grid>
            <Grid xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="password"
                value={user.password}
                onChange={(e) =>
                  setUser({ ...user, [e.target.name]: e.target.value })
                }
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2, p: 1.5 }}
          >
            Log In
          </Button>
        </Box>
      </Box>
    </Container>
  );
};
export default LoginForm;
