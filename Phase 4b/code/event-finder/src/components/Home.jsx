import { Container, CssBaseline } from "@mui/material";
import EventGrid from "../components/events/EventGrid";

const Home = () => {
  return (
    <main>
      <Container fixed sx={{ mt: 4 }}>
          <EventGrid />
      </Container>
    </main>
  );
};
export default Home;
