
const ActionFailedAlert = ({ message, isShown, setIsShown }) => {
    return (
        isShown ? (
      <div className="alert alert-danger" role="alert">
        <div className="d-inline-block">
          <strong>Holy Moly!</strong> {message}
        </div>
        <div className="d-inline-block">
          <div
            type="button"
            className="close-alert-btn mx-2 ms-5"
            aria-label="Close"
            onClick={() => setIsShown(false)}
          >
            X
          </div>
        </div>
      </div>
    ) : (
                <>
                </>
        )
    );
};

export default ActionFailedAlert;