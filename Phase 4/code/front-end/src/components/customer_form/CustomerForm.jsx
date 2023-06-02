import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { v4 as uuid } from "uuid";
import { addCustomer } from "../../redux/features/customer/customerSlice";
const initialCustomer = {
  first_name: "",
  last_name: "",
  email: "",
  account_number: uuid().slice(0, 23).toLocaleUpperCase(),
};
const CustomerForm = () => {
  const dispatch = useDispatch();
  const [customer, setCustomer] = useState(initialCustomer);

  const isValidCustomer =
    Boolean(customer.first_name) &&
    Boolean(customer.last_name) &&
    Boolean(customer.email);

  const handleChange = (e) => {
    setCustomer({
      ...customer,
      [e.target.name]: String(e.target.value).trim(),
    });
  };
  const handleRegisterClick = () => {
    dispatch(addCustomer(customer));
    setCustomer({
      first_name: "",
      last_name: "",
      email: "",
      account_number: "",
    });
  };
  return (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-center"
          style={{ width: "100%" }}
        >
          <form
            onSubmit={(e) => {
              e.preventDefault();
            }}
          >
            <div className="my-2">
              <span className="display-6">Register Customer</span>
            </div>
            <div className="form-floating mb-3">
              <input
                type="text"
                className="form-control"
                id="first_name"
                name="first_name"
                value={customer.first_name}
                onChange={handleChange}
              />
              <label htmlFor="first_name">First Name</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="text"
                className="form-control"
                id="last_name"
                name="last_name"
                value={customer.last_name}
                onChange={handleChange}
              />
              <label htmlFor="last_name">Last Name</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="email"
                className="form-control"
                id="email"
                name="email"
                value={customer.email}
                onChange={handleChange}
              />
              <label htmlFor="email">E-mail</label>
            </div>
            <div className="form-floating mb-3">
              <input
                type="text"
                className="form-control"
                id="account_number"
                name="account_number"
                value={customer.account_number}
                disabled
              />
              <label htmlFor="account_number">Account Number</label>
            </div>
            <div className="d-flex justify-content-end mb-3">
              <button
                className="btn btn-lg btn-success"
                onClick={() => handleRegisterClick}
                disabled={!isValidCustomer}
              >
                Register
              </button>
            </div>
          </form>
        </div>
      </section>
    </main>
  );
};
export default CustomerForm;
