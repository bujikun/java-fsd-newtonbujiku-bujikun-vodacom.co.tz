import { Container, Box, Typography, TextField, Button } from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";
import { useState } from "react";
const initialUser = {
  firstName: "",
  lastName: "",
  username: "",
  password: "",
  confirmPassword: "",
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
  confirmPassword: {
    isError: false,
    errorMessage: "",
  },
};

const RegistrationForm = () => {
  const [user, setUser] = useState(initialUser);
  const [error, setError] = useState(initialError);
  const handleSubmit = (e) => {
    e.preventDefault();
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

  const validatePassword = (inputName, value) => {
    if (inputName === "confirmPassword") {
      if (user.password !== value) {
        setError({
          ...error,
          [inputName]: {
            ...error.inputName,
            isError: true,
            errorMessage: "Passwords do not match",
          },
        });
        console.log(user.password, user.confirmPassword);
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
    }
  };

  const handleChange = (e, saneName, length) => {
    const value = String(e.target.value).trim();
    const inputName = e.target.name;
    validateInput(inputName, value, saneName, length);
    validatePassword(inputName, value);
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
            <Grid xs={12}>
              <TextField
                required
                fullWidth
                name="confirmPassword"
                label="Confirm Password"
                type="password"
                id="confirmPassword"
                autoComplete="new-password"
                value={user.confirmPassword}
                onChange={(e) => handleChange(e, "Password", 8)}
                error={error.confirmPassword.isError}
                helperText={error.confirmPassword.errorMessage}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2, p: 1.5 }}
          >
            Register
          </Button>
        </Box>
      </Box>
    </Container>
  );
};
export default RegistrationForm;
