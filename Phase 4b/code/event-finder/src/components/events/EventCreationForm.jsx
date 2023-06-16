import { Container, Box, Typography, TextField, Button } from "@mui/material";
import Grid from "@mui/material/Unstable_Grid2/Grid2";
import { DatePicker } from "@mui/x-date-pickers";
import dayjs from "dayjs";
import { useEffect, useRef, useState } from "react";
import { useDispatch } from "react-redux";
import { createEvent } from "../../features/events/eventsSlice";
import { useNavigate } from "react-router-dom";
import { selectIsLoggedIn, selectUser } from "../../features/auth/authSlice";
const initialEvent = {
  name: {
    value: "",
    isError: false,
    errorMessage: "",
  },
  description: {
    value: "",
    isError: false,
    errorMessage: "",
  },
  location: {
    value: "",
    isError: false,
    errorMessage: "",
  },
  date: dayjs(Date.now()),
  created_by: {
    value: "",
    isError: false,
    errorMessage: "",
  },
  img: {
    value: "",
    isError: false,
    errorMessage: "",
  },
};

const EventCreationForm = () => {
  const [event, setEvent] = useState(initialEvent);
  const [isCreating, setIsCreating] = useState(false);
  const formDataRef = useRef(null);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const user = selectUser();
  const isLoggedIn = selectIsLoggedIn();
  useEffect(() => {
    if (!isLoggedIn) {
      navigate("/users/login");
      return;
    }
  }, []);

  useEffect(() => {
    if (isCreating) {
      dispatch(createEvent(formDataRef.current));
      navigate("/");
    }
  },[isCreating])
  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const fullName = `${user.firstName} ${user.lastName}`;
    formData.append("created_by", fullName);
    formDataRef.current = formData;
    setIsCreating(true);
  };

  const validateInput = (inputName, value, saneName, length) => {
    if (value.trim().length <= Number(length)) {
      setEvent({
        ...event,
        [inputName]: {
          ...inputName,
          ["value"]: value,
          isError: true,
          errorMessage: `${saneName} length must be greater than ${length}`,
        },
      });
    } else {
      setEvent({
        ...event,
        [inputName]: {
          ...inputName,
          ["value"]: value,
          isError: false,
          errorMessage: "",
        },
      });
    }
  };

  const handleChange = (e, saneName, length) => {
    const value = e.target.value;
    const inputName = e.target.name;
    validateInput(inputName, value, saneName, length);
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
          Create New Event
        </Typography>
        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid xs={12}>
              <Box>
                <DatePicker
                  label="Date"
                  required
                  fullWidth
                  disablePast
                  sx={{ width: "100%" }}
                  value={event.date}
                  onChange={(newValue) =>
                    setEvent({ ...event, date: newValue })
                  }
                  autoFocus
                />
              </Box>
            </Grid>
            <Grid xs={12}>
              <TextField
                autoComplete="on"
                name="name"
                required
                fullWidth
                id="name"
                label="Name"
                value={event.name.value}
                onChange={(e) => handleChange(e, "Name", 5)}
                error={event.name.isError}
                helperText={event.name.errorMessage}
              />
            </Grid>
            <Grid xs={12}>
              <TextField
                autoComplete="on"
                name="description"
                required
                fullWidth
                id="description"
                value={event.description.value}
                onChange={(e) => handleChange(e, "Description", 10)}
                label="Description"
                error={event.description.isError}
                helperText={event.description.errorMessage}
              />
            </Grid>
            <Grid xs={12}>
              <TextField
                name="location"
                required
                fullWidth
                id="location"
                autoComplete="location"
                label="Location"
                value={event.location.value}
                onChange={(e) => handleChange(e, "Location", 5)}
                error={event.location.isError}
                helperText={event.location.errorMessage}
              />
            </Grid>

            <Grid xs={12}>
              <TextField
                required
                fullWidth
                name="img"
                label="Image URL"
                type="text"
                id="img"
                autoComplete="off"
                value={event.img.value}
                onChange={(e) => handleChange(e, "Image URL", 8)}
                error={event.img.isError}
                helperText={event.img.errorMessage}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2, p: 1.5 }}
          >
            CREATE
          </Button>
        </Box>
      </Box>
    </Container>
  );
};
export default EventCreationForm;
