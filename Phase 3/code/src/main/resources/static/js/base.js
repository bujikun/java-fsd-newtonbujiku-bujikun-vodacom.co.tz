$(document).ready(() => {

});
const setActiveNavLink =navLinkId=>{
    $(navLinkId).addClass("active");
};
// const cartForm = document.getElementById("cart-form");
// const totalSpan = document.getElementById("total");

let total = Number(0);
//
// cartForm.addEventListener("submit",event=>{
//     event.preventDefault();
//     const cartItems = [];
//     let ids = "";
//
//     for (let child of cartForm.children) {
//         if (child.getAttribute("class").toLowerCase().includes("cart-item")) {
//             cartItems.push(child);
//         }
//     }
//     for (let formInput of cartItems){
//         console.log(formInput);
//         ids+= formInput.children[1].getAttribute("id")+",";
//         cartForm.removeChild(formInput);
//     }
//     let combinedInput = document.createElement("input");
//     combinedInput.setAttribute("name","cart");
//     combinedInput.setAttribute("value",ids);
//     combinedInput.setAttribute("class","d-none");
//     cartForm.appendChild(combinedInput);
//     console.log(combinedInput);
//     cartForm.submit();
//
// })
//
// let itemIList = [];
// function addToCart  (child){
//     let parent = child.parentNode;
//     let id;
//     let price;
//     let name;
//     for (let child of parent.children) {
//         if (child.tagName.toLowerCase() === "span") {
//             id = child.textContent;
//             if (itemIList.includes(id)) {
//                 return;
//             }
//             itemIList.push(id);
//             continue;
//         }
//         if (child.tagName.toLowerCase() === "h6") {
//             name = child.textContent;
//             continue;
//         }
//         if (child.tagName.toLowerCase() === "p") {
//             price = child.textContent;
//         }
//     }
//     // <div className="mb-3">
//     //     <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
//     //     <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
//     //         <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
//     // </div>
//     const itemDiv = document.createElement("div");
//     itemDiv.setAttribute("class", "mb-1 cart-item")
//
//     const itemLabel = document.createElement("label");
//     itemLabel.setAttribute("for", id);
//     //itemLabel.setAttribute("class","form-label")
//     itemDiv.appendChild(itemLabel);
//     const itemInput = document.createElement("input");
//     itemInput.setAttribute("type", "text");
//     itemInput.setAttribute("class", "form-control");
//     itemInput.setAttribute("disabled", "disabled")
//     itemInput.setAttribute("id", id);
//     itemInput.setAttribute("value", name + " --  " + price);
//     itemDiv.appendChild(itemInput);
//     //cartForm.insertBefore()
//     price = price.substring(1);
//     total += Number(price);
//     console.log(total);
//
//     //total=total.toFixed(2);
//     //total.parseFtoFixed(2)
//     cartForm.appendChild(itemDiv);
//     totalSpan.textContent = "Total: $"+total.toFixed(2);
//     console.log({id,name,price})
// }
//
//
// function clearCart() {
//     const cartItems = [];
//
//     for (let child of cartForm.children) {
//         if (child.getAttribute("class").toLowerCase().includes("cart-item")) {
//             cartItems.push(child);
//         }
//     }
//     for (let child of cartItems) {
//         cartForm.removeChild(child)
//     }
//     itemIList =[];
//     total = Number(0);
//     totalSpan.textContent = "Total: $0.00";
//
// }
//


