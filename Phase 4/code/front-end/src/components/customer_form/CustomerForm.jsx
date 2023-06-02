import { useState } from "react"
import {v4 as uuid} from 'uuid'
const initialUser = {
    first_name : "",
    last_name : "",
    email : "",
    account_number : uuid().slice(0,23).toLocaleUpperCase(),
  }
const UserForm = () => {
  const [user, setUser] = useState(initialUser);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value })
    console.log(user);
  }
  return (
      <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
          <form onSubmit={(e) => {e.preventDefault() }}>
            <div className="my-2">
              <span className="display-6">Register Customer</span>
    
            </div>
            <div className="form-floating mb-3">
              <input type="text" className="form-control" id="first_name" name="first_name"
                value={user.first_name}
                onChange={handleChange} />
              <label htmlFor="first_name">First Name</label>
            </div>
            <div className="form-floating mb-3">
              <input type="text" className="form-control" id="last_name" name="last_name"
                value={user.last_name}
                onChange={handleChange} />
              <label htmlFor="last_name">Last Name</label>
            </div>
            <div className="form-floating mb-3">
              <input type="text" className="form-control" id="email" name="email"
                value={user.email}
                onChange={handleChange} />
              <label htmlFor="email">E-mail</label>
            </div>
            <div className="form-floating mb-3">
              <input type="text" className="form-control" id="account_number" name="account_number"
                value={user.account_number}
                 disabled/>
              <label htmlFor="account_number">Account Number</label>
            </div>
            <div className="d-flex justify-content-end mb-3">
              <button className="btn btn-lg btn-success"
              onClick={()=>{}}>Register</button>
            </div>
          </form>
              </div>
          </section>
          </main>
  )
}
export default UserForm