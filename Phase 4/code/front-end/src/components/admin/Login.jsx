import { useState } from 'react';
import './style.css'
const initialUser = {
  username: "",
  password:""
}
const Login = () => {
  const [user, setUser] = useState(initialUser);
  const[isValid,setIsValid] = useState(false);
  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: String(e.target.value).trim() });
    setIsValid(user.username.length>1&&user.password.length>1);
    console.log(isValid);
  }

  const handleLogin = () => {
    
  }

  return (
    <main className='container'>
      <div className='login'>
        <div className='inner-container card'>
          <div className='bg-success p-2 login-header'>
          <h3>Admin Login</h3>
          </div>
          <form onSubmit={(e) => e.preventDefault()}>
            <div className='form-floating my-3'>
              <input type="text"
                className='form-control'
                id='username'
                name='username'
                value={user.username}
                onChange={handleChange}
              />
              <label htmlFor="username">Username</label>
            </div>
            <div className='form-floating my-3'>
              <input type="password"
                className='form-control'
                id='password'
                name='password'
                value={user.password}
                onChange={handleChange}
              />
              <label htmlFor="password">Password</label>
            </div>
            <div className='my-3 d-grid'> 
              <button className='btn btn-lg btn-outline-success px-4' onClick={handleLogin}
              disabled={!isValid}
              >Login</button>
            </div>
          </form>
      </div>
      <div >
      </div>
      </div>
    </main>
  );
}
export default Login