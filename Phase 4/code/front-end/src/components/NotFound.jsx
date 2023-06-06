const NotFound = () => {
    return (
      <main className="container">
        <div
          className="d-flex flex-column justify-content-center 
            align-items-center my-5"
        >
                <h1 className="my-5" style={{fontSize:"10rem"}}>&#128557;</h1>
                <div className="alert alert-danger display-5">
                  <strong >Error 404</strong>  ! You can't do that!
                </div>
        </div>
      </main>
    );
}
export default NotFound