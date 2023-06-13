import {
  Container,
  Box,
  Typography,
  TextField,
  Button,
} from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";

const LoginForm = () => {
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
