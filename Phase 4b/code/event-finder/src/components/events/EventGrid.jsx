import Grid from "@mui/material/Unstable_Grid2/Grid2"
import { Box, Typography } from "@mui/material"
import Event from "./Event"
import { fetchEvents, selectAllEvents } from "../../features/events/eventsSlice"
import { useDispatch } from "react-redux"
import { useEffect,useState } from "react"


const EventGrid = () => {
    const dispatch = useDispatch();
    const events = selectAllEvents();
    const [isEventDeleted, setIsEventDeleted] = useState(false);
    
    useEffect(() => {
        dispatch(fetchEvents());
        setIsEventDeleted(false);
    }, [isEventDeleted])   
    return (

        <Box sx={{ flexGrow: 1 }}>
            <Typography component="h3" variant="h3" sx={{my:2}}>
                Upcoming events 
            </Typography>
          <Grid container spacing={2} sx={{mx:"auto"}}>
                {events.map(event => (
                    <Grid key={event.id} xs={12} sm={12} md={6} lg={4} xl={3}>
                        <Event event={event} setIsEventDeleted={setIsEventDeleted} />
                  </Grid>
              ))}
          </Grid>
    </Box>
  )
}
export default EventGrid