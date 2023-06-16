import { Close, HighlightOff, Search } from "@mui/icons-material";
import {
  TextField,
  Dialog,
  IconButton,
  DialogContent,
  InputAdornment,
  Box,
  Typography,
  Paper,
  List,
  ListItem,
  ListItemButton,
  ListItemAvatar,
  Avatar,
  ListItemText,
} from "@mui/material";
import {
    clearSearchResult,
  searchEvent,
  selectSearchResult,
} from "../../features/events/eventsSlice";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";

const SearchDialog = ({ isOpen, setIsSearchDialogIsOpen }) => {
  const [searchString, setSearchString] = useState("");

  const dispatch = useDispatch();
    const handleChange = (e) => {
        const text = e.target.value;
        if (text.slice().trim().length <= 0) {
            setSearchString(text);
            dispatch(clearSearchResult());
            return;
        }
        setSearchString(text);
      dispatch(searchEvent(searchString));
  };

  return (
    <Paper>
      <Dialog
        open={isOpen}
        sx={{
          minWidth: 400,
          mb: 4,
          "& .MuiDialog-container": {
            justifyContent: "center",
            alignItems: "start",
            mt: 10,
          },
        }}
        fullWidth
      >
        <Box
          sx={{
            display: "flex",
            justifyContent: "end",
            alignItems: "center",
          }}
        >
          <IconButton
            size="large"
            color="error"
            sx={{ mr: 2, height: 64 }}
            onClick={() => {
              setSearchString("");
              dispatch(clearSearchResult());
              setIsSearchDialogIsOpen(false);
            }}
          >
            <HighlightOff size="large" />
          </IconButton>
        </Box>
        <DialogContent>
          <Box
            component="form"
            sx={{ display: "flex" }}
            onSubmit={(e) => e.preventDefault()}
          >
            <TextField
                          autoComplete="off"
                          autoFocus
              name="name"
              required
              fullWidth
              id="name"
              value={searchString}
              onChange={handleChange}
              placeholder="Type to search events"
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <Search color="primary" />
                  </InputAdornment>
                ),
              }}
              variant="standard"
              sx={{
                fontSize: 24,
              }}
            />
          </Box>
          <Box>
            <SearchResultList
              setIsSearchDialogIsOpen={setIsSearchDialogIsOpen}
            />
          </Box>
        </DialogContent>
      </Dialog>
    </Paper>
  );
};

const SearchResultList = ({ setIsSearchDialogIsOpen }) => {
  const searchResult = selectSearchResult();
    const navigate = useNavigate();
    const dispatch = useDispatch();
  return (
    <List>
      {searchResult.map((item) => (
        <ListItem key={item.id} sx={{ width: "100%", cursor: "pointer" }}>
              <ListItemButton onClick={() => {
                  dispatch(clearSearchResult());
                  setIsSearchDialogIsOpen(false);
                  navigate(`/events/view/${item.id}`);
              }}>
            <ListItemAvatar>
              <Avatar alt={item.img} src={item.img} />
            </ListItemAvatar>
            <ListItemText
              primary={
                <Typography
                  sx={{
                    display: "block",
                  }}
                  component="span"
                  variant="h6"
                  color="text.primary"
                >
                  {item.name}
                </Typography>
              }
              secondary={
                <Typography
                  sx={{ display: "block" }}
                  component="span"
                  variant="p"
                  color="text.primary"
                >
                  {item.description}
                </Typography>
              }
            />
          </ListItemButton>
        </ListItem>
      ))}
    </List>
  );
};

export default SearchDialog;
