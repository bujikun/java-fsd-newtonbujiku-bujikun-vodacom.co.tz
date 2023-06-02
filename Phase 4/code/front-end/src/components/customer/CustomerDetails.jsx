import { useSelector } from "react-redux";
import { selectCustomer } from "../../redux/features/customer/customerSlice";

const CustomerDetails = () => {
  const customer = useSelector(selectCustomer);const tdTextLeftAlign = {textAlign:"left"};
  return (
    <main className="container">
      <section className="row">
        <div
          className="my-4 d-flex flex-column justify-content- align-items-start"
          style={{ width: "100%" }}
        >
          <div className="my-3">
            <span className="h4 text-align-left">Customer Details</span>
          </div>
          <table className="table table-borderless">
            <thead>
              {/* <tr>
                <th>Food Name</th>
                <th>Quantity</th>
              </tr> */}
            </thead>
            <tbody>
              <tr>
                <td style={tdTextLeftAlign}>
                  <span className="badge bg-secondary me-2">Name</span>
                  {`${customer.first_name} ${customer.last_name}`}
                </td>
              </tr>
              <tr>
                <td style={tdTextLeftAlign}>
                  <span className="badge bg-secondary me-2">E-Mail</span>
                  {`${customer.email}`}
                </td>
              </tr>
              <tr>
                <td style={tdTextLeftAlign}>
                  <span className="badge bg-secondary me-2">
                    Account Number
                  </span>
                  {`${customer.account_number}`}
                </td>
              </tr>
            </tbody>
            <tfoot></tfoot>
          </table>
        </div>
      </section>
    </main>
  );
}
export default CustomerDetails