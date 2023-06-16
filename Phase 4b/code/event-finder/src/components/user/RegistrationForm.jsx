import { Container, Box, Typography, TextField, Button } from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { registerUser, selectUserStatus } from "../../features/auth/authSlice";
import { useNavigate } from "react-router-dom";
const initialUser = {
  firstName: "",
  lastName: "",
  username: "",
  password: "",
};

const initialError = {
  firstName: {
    isError: false,
    errorMessage: "",
  },
  lastName: {
    isError: false,
    errorMessage: "",
  },
  username: {
    isError: false,
    errorMessage: "",
  },
  password: {
    isError: false,
    errorMessage: "",
  },
};

const RegistrationForm = () => {
  const [user, setUser] = useState(initialUser);
  const [error, setError] = useState(initialError);
  const [isRegistering, setIsRegistering] = useState(false);
  const [isInvalid, setIsInvalid] = useState(true);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  useEffect(() => {
    if (isRegistering) {
      dispatch(registerUser(user));
      navigate("/users/login");
    }
  }, [isRegistering]);

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsRegistering(true);
  };

  const validateInput = (inputName, value, saneName, length) => {
    if (value.trim().length <= Number(length)) {
      setError({
        ...error,
        [inputName]: {
          ...error.inputName,
          isError: true,
          errorMessage: `${saneName} length must be greater than ${length}`,
        },
      });
    } else {
      setError({
        ...error,
        [inputName]: {
          ...error.inputName,
          isError: false,
          errorMessage: "",
        },
      });
    }
  };
  const handleChange = (e, saneName, length) => {
    const value = String(e.target.value).trim();
      const inputName = e.target.name;
      length = Number(length);
      console.log(length);
    if (
      user.firstName.trim().length >= length &&
      user.lastName.trim().length >= length &&
      user.username.trim().length >= length &&
      user.password.trim().length >= length
    ) {
      setIsInvalid(false);
    }
    validateInput(inputName, value, saneName, length);
    setUser({ ...user, [inputName]: value });
  };

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
          User Registration
        </Typography>
        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid xs={12} sm={6}>
              <TextField
                autoComplete="given-name"
                name="firstName"
                required
                fullWidth
                id="firstName"
                label="First Name"
                autoFocus
                value={user.firstName}
                onChange={(e) => handleChange(e, "First Name", 5)}
                error={error.firstName.isError}
                helperText={error.firstName.errorMessage}
              />
            </Grid>
            <Grid xs={12} sm={6}>
              <TextField
                autoComplete="family-name"
                name="lastName"
                required
                fullWidth
                id="lastName"
                value={user.lastName}
                onChange={(e) => handleChange(e, "Last Name", 5)}
                label="Last Name"
                error={error.lastName.isError}
                helperText={error.lastName.errorMessage}
              />
            </Grid>
            <Grid xs={12}>
              <TextField
                name="username"
                required
                fullWidth
                id="username"
                autoComplete="username"
                label="Username"
                value={user.username}
                onChange={(e) => handleChange(e, "Username", 5)}
                error={error.username.isError}
                helperText={error.username.errorMessage}
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
                value={user.password}
                onChange={(e) => handleChange(e, "Password", 8)}
                autoComplete="new-password"
                error={error.password.isError}
                helperText={error.password.errorMessage}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2, p: 1.5 }}
            disabled={isInvalid}
          >
            Register
          </Button>
        </Box>
      </Box>
    </Container>
  );
};
export default RegistrationForm;
