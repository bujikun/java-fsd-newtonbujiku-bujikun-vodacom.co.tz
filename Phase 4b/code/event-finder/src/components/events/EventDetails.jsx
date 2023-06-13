import { useParams } from "react-router-dom"
import { events } from "../../store/store";
import { Box, Container,Card,CardActionArea,Typography,CardMedia,CardActions,Button, Stack, Paper } from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";

const EventDetails = () => {
    const { id } = useParams();
    const event = events.find((item) => item.id === Number(id));
    console.log(id);
  return (
      <Container sx={{
          mx: 4, display: "flex",
          justifyContent: "center", flexDirection: "column"
      }}>
      <Box sx={{ mt: 6, mx: 4, textAlign:"center"}}>
        <Typography variant="h4" component="h4">Event Number: {event.id}</Typography>
      </Box>
      <Grid container sx={{ mt: 6, mx: 4 }} spacing={3}>
        <Grid xs="12" sm="12" md="6" lg="6">
          <EventSummary event={event} />
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

const EventSummary = ({event}) => {
    return (
      <Stack spacing={2}>
        <Box>
          <Paper sx={{ px: 4, py: 2 }} elevation={10}>
            <Typography component="h5" variant="h5">
              {event.name}
            </Typography>
          </Paper>
          <Paper sx={{ px: 4, py: 2, my: 3 }} elevation={10}>
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
               Added by:  {event.created_by}
              </Typography>
            </Box>
          </Paper>
        </Box>
      </Stack>
    );
}
export default EventDetails