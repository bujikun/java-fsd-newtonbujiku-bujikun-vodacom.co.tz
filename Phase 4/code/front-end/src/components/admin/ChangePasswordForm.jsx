import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { selectAuth } from "../../redux/features/auth/authSlice";

const URL = "http://localhost:8080/api/users/change-password";

const ChangePasswordForm = () => {
    const auth = useSelector(selectAuth);
  const [data, setData] = useState({
    old_password: "",
    new_password: "",
    confirm_new_password: "",
    username: auth.user.username,
  });
  const[isChangingPassword, setIsChangingPassword] = useState(false);
  const navigate = useNavigate();
  const [errorMessage, setErrorMessage] = useState("");
  const handleChange = (e) => {
    setData({
      ...data,
      [e.target.name]: String(e.target.value).trim(),
    });
  };

  const changePassword = async () => {
    try {
      const { status,data:resBody } = await axios.post(URL, data, {
        ...auth.config,
        "Content-Type": "application/json",
      });

      if (status == 202) {
        navigate("/admin");
      }
      console.log(resBody);
    } catch (error) {
      console.error(error);
      setIsChangingPassword(false);
      setErrorMessage("Password Change Failed");
    }
  };

  const handleAddClick = () => {
        console.log(data);

    if (data.new_password.length < 6) {
      setErrorMessage("Old password too short!");
      return;
    }
    if (data.confirm_new_password.length < 6) {
      setErrorMessage("New password too short!");
    return;
    }
    
    if (data.new_password.length !== data.confirm_new_password.length) {
      setErrorMessage("Passwords do not match!");
      return;
    }
    setIsChangingPassword(true);
    console.log(data);
    //navigate("/admin");
  };

  useEffect(() => {
     if (isChangingPassword) {
       changePassword();
     }
  },[isChangingPassword]);
  return (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
          {errorMessage && (
            <PasswordErrorAlert
              errorMessage={errorMessage}
              setErrorMessage={setErrorMessage}
            />
          )}
          <form
            onSubmit={(e) => {
              e.preventDefault();
            }}
          >
            <div className="my-2">
              <span className="display-6">Change Password</span>
            </div>
            <div className="form-floating mb-3">
              <input
                type="text"
                className="form-control"
                id="username"
                name="username"
                value={data.username}
                disabled={true}
              />
              <label htmlFor="img_url">Username</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="password"
                className="form-control"
                id="old_password"
                name="old_password"
                value={data.old_password}
                onChange={handleChange}
              />
              <label htmlFor="name">Old Password</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="password"
                className="form-control"
                id="new_password"
                name="new_password"
                step={0.01}
                value={data.new_password}
                onChange={handleChange}
              />
              <label htmlFor="price">New Password</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="password"
                className="form-control"
                id="confirm_new_password"
                name="confirm_new_password"
                step={0.01}
                value={data.confirm_new_password}
                onChange={handleChange}
              />
              <label htmlFor="price">Confirm New Password</label>
            </div>

            <div className="d-flex justify-content-end mb-3">
              <button
                className="btn btn-lg btn-success"
                onClick={handleAddClick}
              >
                Change Password
              </button>
            </div>
          </form>
        </div>
      </section>
    </main>
  );
};

const PasswordErrorAlert = ({errorMessage,setErrorMessage}) => {
      return (
        <div className="alert alert-danger" role="alert">
          <div className="d-inline-block">
            <strong>Holy Moly!</strong> {errorMessage}
          </div>
          <div className="d-inline-block">
            <div
              type="button"
              className="close-alert-btn mx-2 ms-5"
              aria-label="Close"
              onClick={() => setErrorMessage("")}
            >
              X
            </div>
          </div>
        </div>
      );
}

export default ChangePasswordForm;
