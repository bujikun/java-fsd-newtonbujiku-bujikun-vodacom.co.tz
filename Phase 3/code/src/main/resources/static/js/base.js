$(document).ready(() => {

});
let itemIList = [];
function addToCart  (child){
    let parent = child.parentNode;
    let id;
    let price;
    let name;
    for (let child of parent.children) {
        if (child.tagName.toLowerCase() === "span") {
            id = child.textContent;
            if (itemIList.includes(id)) {
                return;
            }
            itemIList.push(id);
            continue;
        }
        if (child.tagName.toLowerCase() === "h6") {
            name = child.textContent;
            continue;
        }
        if (child.tagName.toLowerCase() === "p") {
            price = child.textContent;
        }
    }
    // <div className="mb-3">
    //     <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
    //     <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    //         <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
    // </div>
    const itemDiv = document.createElement("div");
    itemDiv.setAttribute("class", "mb-1 cart-item")

    const itemLabel = document.createElement("label");
    itemLabel.setAttribute("for", id);
    //itemLabel.setAttribute("class","form-label")
    itemDiv.appendChild(itemLabel);
    const itemInput = document.createElement("input");
    itemInput.setAttribute("type", "text");
    itemInput.setAttribute("class", "form-control");
    itemInput.setAttribute("disabled", "disabled")
    itemInput.setAttribute("id", id);
    itemInput.setAttribute("value", name + " ---  " + price);
    itemDiv.appendChild(itemInput);
    const cartForm = document.getElementById("cart-form");
    //cartForm.insertBefore()
    cartForm.appendChild(itemDiv);

    console.log({id,name,price})
}

function clearCart() {
    const cartForm = document.getElementById("cart-form");
    const cartItems = [];

    for (let child of cartForm.children) {
        if (child.getAttribute("class").toLowerCase().includes("cart-item")) {
            cartItems.push(child);
        }
    }
    for (let child of cartItems) {
        cartForm.removeChild(child)
    }
    itemIList =[];
};

