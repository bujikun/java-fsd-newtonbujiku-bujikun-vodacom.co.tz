import axios from "axios";
import { useEffect, useRef, useState } from "react";


const CustomerList = () => {
  const URL = "http://localhost:8080/api/customers";
  const [customers, setCustomers] = useState([]);
  const effectRanRef = useRef(false);

  const fetchCustomers = async () => {
    try {
      const { data } = await axios.get(URL);
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

                <td>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default CustomerList;
