import { Card, CardActionArea, CardContent, CardMedia,Typography,CardActions,Button, Box } from "@mui/material"
import { useNavigate } from "react-router-dom";

const Event = ({ event }) => {
    const navigate = useNavigate();
    const handleViewClick = (id) => {
        navigate(`/events/view/${id}`);
    }
  return (
    <Box sx={{display:"flex",justifyContent:"center"}}>
      <Card sx={{ maxWidth: 400,mt:3 }} raised={true}>
        <CardActionArea>
          <CardMedia component="img" height={200} image={event.img} />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              {event.name}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              {event.description}
            </Typography>
          </CardContent>
        </CardActionArea>
        <CardActions>
          <Button size="small" color="primary" onClick={()=>handleViewClick(event.id)}>
            View
          </Button>
          <Button size="small" color="error">
            Delete
          </Button>
        </CardActions>
      </Card>
    </Box>
  );
}
export default Event