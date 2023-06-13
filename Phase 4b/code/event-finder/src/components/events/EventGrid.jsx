import Grid from "@mui/material/Unstable_Grid2/Grid2"
import { events } from "../../store/store"
import { Box, Typography } from "@mui/material"
import Event from "./Event"


const EventGrid = () => {
    return (

        <Box sx={{ flexGrow: 1 }}>
            <Typography component="h3" variant="h3" sx={{my:2}}>
                Upcoming events 
            </Typography>
          <Grid container spacing={2} sx={{mx:"auto"}}>
                {events.map(event => (
                    <Grid key={event.id} xs={12} sm={12} md={6} lg={4} xl={3}>
                        <Event event={ event} />
                  </Grid>
              ))}
          </Grid>
    </Box>
  )
}
export default EventGrid