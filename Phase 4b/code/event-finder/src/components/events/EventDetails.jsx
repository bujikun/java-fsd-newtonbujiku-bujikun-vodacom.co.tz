import { useNavigate, useParams } from "react-router-dom"
import { Box, Container,Card,CardActionArea,Typography,CardMedia,Button, Stack, Paper } from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";
import { deleteEventById, selectDeleteStatus} from "../../features/events/eventsSlice";
import { useEffect, useState } from "react";
import axios from "axios";
import { useDispatch } from "react-redux";
import { BASE_URL } from "../../features/constants";

const EventDetails = () => {
  const { id } = useParams();
  const [event, setEvent] = useState({});
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const status = selectDeleteStatus();
  useEffect(() => {
    const fetchEvent = async () => {
       try {
         const { data } = await axios.get(`${BASE_URL}/events/${id}`);
         setEvent(data);
       } catch (error) {
        console.log(error);
       }
    }
    fetchEvent();
  },[])

  const handleDelete = (id) => {
    dispatch(deleteEventById(id));
    console.log(status);
    navigate("/");
  }
   
  return (
    <Container
      sx={{
        mx: "auto",
        display: "flex",
        justifyContent: "center",
        flexDirection: "column",
      }}
    >
      <Box sx={{ mt: 6, mx: "auto", textAlign: "center" }}>
              <Typography variant="h4" component="h4"
                  sx={{ textTransform: "uppercase" }}>
          Event Number {event.id}
        </Typography>
      </Box>
      <Grid
        container
        sx={{ mt: 6, mx: 4, display: "flex", justifyContent: "center" }}
        spacing={3}
      >
        <Grid xs="12" sm="12" md="6" lg="6">
          <EventSummary event={event} onDelete={ ()=>handleDelete(id)} />
        </Grid>
        <Grid xs="12" sm="12" md="6" lg="6">
          <EventImage image={event.img} />
        </Grid>
      </Grid>
    </Container>
  );
}

 const EventImage = ({image}) => {
  return (
    <Box>
      <Card sx={{ minWidth:300,maxWidth: 500 }} raised={true}>
        <CardActionArea>
          <CardMedia
            component="img"
            height={400}
            image={image}
            sx={{ display: "flex", justifyContent: "center" }}
          />
          </CardActionArea>
      </Card>
    </Box>
  );
}

const EventSummary = ({event,onDelete}) => {
    return (
      <Stack spacing={2}>
        <Box>
          <Paper sx={{ px: 4, py: 2 }} elevation={10}>
            <Typography component="h5" variant="h5">
              {event.name}
            </Typography>
          </Paper>
          <Paper sx={{ px: 4, pb: 6, pt: 6, my: 3 }} elevation={10}>
            <Box sx={{ my: 1 }}>
              <Typography component="p" variant="body1">
                {event.description}
              </Typography>
            </Box>
            <Box sx={{ my: 1 }}>
              <Typography component="p" variant="body2">
                {event.location}
              </Typography>
            </Box>
            <Box sx={{ my: 1 }}>
              <Typography component="p" variant="body2">
                {event.date}
              </Typography>
            </Box>
            <Box sx={{ my: 1 }}>
              <Typography component="p" variant="button">
                Added by: {event.created_by}
              </Typography>
            </Box>
            <Box sx={{ mt: 4 }} elevation={10}>
              <Button size="large" color="error" variant="outlined"
            onClick={onDelete}
              >
                Delete event
              </Button>
            </Box>
          </Paper>
        </Box>
      </Stack>
    );
}
export default EventDetails