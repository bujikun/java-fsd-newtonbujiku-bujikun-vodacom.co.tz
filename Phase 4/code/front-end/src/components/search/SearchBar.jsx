import { useState } from "react"

const SearchBar = () => {
    const [queryText, setQueryText] = useState("");
    
    const handleChange = e => {
        
    }
  return (
      <div>
          <form >
              <div className="form-group my-3">
                  <label htmlFor="search"></label>
                  <input
                      type="text"
                      className="form-control form-control-lg"
                      name="search"
                      id="search"
                      value={queryText}
                      onChange={e=>handleChange(e)}

                  />
              </div>
          </form>
    </div>
  )
}
export default SearchBar