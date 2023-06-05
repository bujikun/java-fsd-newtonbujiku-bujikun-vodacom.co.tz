import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { selectAuth } from "../../redux/features/auth/authSlice";
import { useSelector } from "react-redux";
import ActionFailedAlert from "./ActionFailedAlert";


const CustomerList = () => {
  const URL = "http://localhost:8080/api/customers";
  const [customers, setCustomers] = useState([]);
  const auth = useSelector(selectAuth);
  const effectRanRef = useRef(false);

  const fetchCustomers = async () => {
    try {
      const { data } = await axios.get(URL, auth.config);
      setCustomers(data);
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    if (effectRanRef.current) {
          fetchCustomers();
    }
    effectRanRef.current = true;
  }, []);

  if (customers.length <= 0) {
    return (
      <div className="alert alert-danger" role="alert">
        <div className="d-inline-block">
          <strong>Holy Moly!</strong> No one has ordered anything
        </div>
        <div className="d-inline-block">
        </div>
      </div>
    );
  }

  return (
    <div>
      <div className="mb-5">
        <span className="display-6">Customers</span>
      </div>
      <div>
        <table className="table table-striped table-bordeless table-hover">
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Account Number</th>
            </tr>
          </thead>
          <tbody>
            {customers.map((customer) => (
              <tr key={customer.id}>
                <td>{customer.first_name}</td>
                <td>{customer.last_name}</td>
                <td>{customer.email}</td>
                <td>{customer.account_number}</td>

                <td></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default CustomerList;
