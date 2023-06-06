import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import {
  configIsCreated,
  tokenIsReceived,
  userIsLoggedIn,
} from "../../redux/features/auth/authSlice";

const URL = "http://localhost:8080/auth/login";
const initialUser = {
  username: "",
  password: "",
};
const Login = () => {
  const [user, setUser] = useState(initialUser);
  const [isValid, setIsValid] = useState(false);
  const [isLoginAttempt, setIsLoginAttempt] = useState(false);
  const [isFailedLoginAttempt, setIsFailedLoginAttempt] = useState(false);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  useEffect(() => {
    if (isLoginAttempt && isValid) {
      doLogin();
    }
  }, [isLoginAttempt]);
  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value});
    setIsValid(user.username.length > 1 && user.password.length > 1);
  };

  const handleLogin = (e) => {
    console.log(isValid, user);
    setUser({ ...user });
        setIsValid(user.username.length > 1 && user.password.length > 1);

    setIsLoginAttempt(!isLoginAttempt);
  };

  const doLogin = async () => {
    try {
      console.log(user);
      const { status, data } = await axios.post(
        URL,
        {},
        {
          auth: user,
        }
      );
      if (status === Number(202)) {
        dispatch(tokenIsReceived(data));
        dispatch(
          configIsCreated({
            headers: {
              Authorization: `Bearer ${data}`,
            },
          })
        );
        dispatch(userIsLoggedIn({ username: user.username }));
        navigate("/admin");
        return;
      }
    } catch (error) {
      setIsFailedLoginAttempt(true);
      setIsLoginAttempt(false);
    }
  };
  return (
    <main className="container">
      {isFailedLoginAttempt && (
       <AuthFailedAlert setIsFailedLoginAttempt={setIsFailedLoginAttempt}/>
      )}
      <div className="login">
        <div className="inner-container card">
          <div className="p-2 text-success">
            <h3>Admin Login</h3>
          </div>
          <form onSubmit={(e) => e.preventDefault()}>
            <div className="form-floating my-3">
              <input
                type="text"
                className="form-control"
                id="username"
                name="username"
                value={user.username}
                onChange={handleChange}
                autoComplete="on"
              />
              <label htmlFor="username">Username</label>
            </div>
            <div className="form-floating my-3">
              <input
                type="password"
                className="form-control"
                id="password"
                name="password"
                value={user.password}
                onChange={handleChange}
                autoComplete="on"
              />
              <label htmlFor="password">Password</label>
            </div>
            <div className="my-3 d-grid">
              <button
                className="btn btn-lg btn-outline-success px-4"
                onClick={handleLogin}
                // disabled={!isValid}
              >
                Login
              </button>
            </div>
          </form>
        </div>
        <div></div>
      </div>
    </main>
  );
};

export default Login;

const AuthFailedAlert = ({setIsFailedLoginAttempt}) => {
  return (
    <div className="alert alert-danger" role="alert">
      <div className="d-inline-block">
        <strong>Holy Moly!</strong> Invalid username or password
      </div>
      <div className="d-inline-block">
        <div
          type="button"
          className="close-alert-btn mx-2 ms-5"
          aria-label="Close"
          onClick={() => setIsFailedLoginAttempt(false)}
        >
          X
        </div>
      </div>
    </div>
  );
}
