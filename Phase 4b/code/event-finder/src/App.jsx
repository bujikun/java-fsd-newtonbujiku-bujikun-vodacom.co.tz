import './App.css';
import "@fontsource/roboto/300.css";
import "@fontsource/roboto/400.css";
import "@fontsource/roboto/500.css";
import "@fontsource/roboto/700.css";
import { Container, CssBaseline } from '@mui/material';
import AppSearchBar from './components/bar/AppSearchBar';
import Grid2 from '@mui/material/Unstable_Grid2/Grid2';
import EventGrid from './components/events/EventGrid';


function App() {

  return (
    <CssBaseline>
      <AppSearchBar/>
      <Container maxWidth="sm">
        <main>
       <EventGrid/>
        </main>
      </Container>
    </CssBaseline>
  )
}

export default App;
