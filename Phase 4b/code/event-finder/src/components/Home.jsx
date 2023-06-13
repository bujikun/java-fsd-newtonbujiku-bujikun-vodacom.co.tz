import { Container, CssBaseline } from "@mui/material";
import EventGrid from "../components/events/EventGrid";

const Home = () => {
  return (
      <Container fixed sx={{ mt: 4 }} component="main">
          <EventGrid />
      </Container>
  );
};
export default Home;
