import {
  Container,
  Box,
  Typography,
  TextField,
  Button,
} from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";

const RegistrationForm = () => {
    const handleSubmit = (e) => {
      e.preventDefault();
    };
  return (
    <Container maxWidth="xs" component="main">
      <Box
        sx={{
          mt: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          //   textAlign:"center"
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
              />
            </Grid>
            <Grid xs={12} sm={6}>
              <TextField
                autoComplete="family-name"
                name="lastName"
                required
                fullWidth
                id="lastName"
                label="Last Name"
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
                autoComplete="new-password"
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
