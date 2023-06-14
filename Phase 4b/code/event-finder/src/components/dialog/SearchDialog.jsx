import { Close, HighlightOff, Search } from "@mui/icons-material";
import {
  TextField,
  Dialog,
  InputBase,
  IconButton,
  DialogContent,
  InputAdornment,
  Box,
  DialogTitle,
  Typography,
  Paper,
  List,
  ListItem,
  ListItemButton,
  ListItemAvatar,
  Avatar,
  ListItemText,
  Divider,
} from "@mui/material";

const SearchDialog = ({ isOpen }) => {
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
          {/* <Typography variant="inherit">
            Search for events
          </Typography> */}
          <IconButton size="large" color="error" sx={{mr:2,height:64}}>
            <HighlightOff size="large"/>
          </IconButton>
        </Box>
        <DialogContent>
          <Box component="form" sx={{ display: "flex" }}>
            {/* <TextField
            autoComplete="on"
            name="name"
            required
            fullWidth
            id="name"
            value=""
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">
                  <Search />
                </InputAdornment>
              ),
            }}
            variant="standard"
          /> */}
            {/* <IconButton
            type="button"
            sx={{ p: "10px", minHeight: 24 }}
            aria-label="search"
            size="large"
          >
            <Search />
          </IconButton> */}
            {/* <InputBase
            sx={{ ml: 1, flex: 1, py: 1, fontSize: 24 }}
            inputProps={{ "aria-label": "search for events" }}
            autoFocus
          /> */}
            <TextField
              autoComplete="on"
              name="name"
              required
              fullWidth
              id="name"
                          value=""
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
                      <SearchResultList/>
                  </Box>
        </DialogContent>
      </Dialog>
    </Paper>
  );
};

const SearchResultList = ({ list }) => {
  return (
    <List>
      <ListItem sx={{ width: "100%",cursor:"pointer" }}>
        <ListItemButton>
          <ListItemAvatar>
            <Avatar
              alt=""
              src="https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg"
            />
          </ListItemAvatar>
          <ListItemText
            primary={
              <Typography
                              sx={{
                                  display: "block" }}
                component="span"
                variant="h6"
                color="text.primary"
              >
                Ali Connors
              </Typography>
            }
            secondary={
              <Typography
                sx={{ display: "block" }}
                component="span"
                variant="p"
                color="text.primary"
              >
                Ali Connors
              </Typography>
            }
          />
        </ListItemButton>
      </ListItem>
      <ListItem sx={{ width: "100%" }}>
        <ListItemButton>
          <ListItemAvatar>
            <Avatar
              alt=""
              src="https://cdn.punchng.com/wp-content/uploads/2022/02/25122124/UEFA-Champions-League.jpg"
            />
          </ListItemAvatar>
          <ListItemText
            primary={
              <Typography
                sx={{ display: "block" }}
                component="span"
                variant="button"
                color="text.primary"
              >
                Ali Connors
              </Typography>
            }
            secondary={
              <Typography
                sx={{ display: "block" }}
                component="span"
                variant="p"
                color="text.primary"
              >
                Ali Connors
              </Typography>
            }
          />
        </ListItemButton>
      </ListItem>
    </List>
  );
};

export default SearchDialog;
