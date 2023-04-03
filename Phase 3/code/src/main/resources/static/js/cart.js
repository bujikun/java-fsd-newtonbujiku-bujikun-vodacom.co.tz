let cart;
let cartString = window.localStorage.getItem("cart");
let cartItemsCount = Number(0);
if(cartString == null || cartString == undefined){
    //no saved cart
    //initialize
    cart = {};
}else{
    //the cart exists
    //parse it
    console.log("cartString "+cartString);
    console.log("cart  "+ cart);
    cart = JSON.parse(cartString);
    console.log("cart  "+ cart);
    //find total items in cart
    for(let key in cart){
        let product = cart[key];
        console.log("prod  "+ product);
        cartItemsCount += Number(product["count"]);
    }
    let cartNotification = document.getElementById("cartNotification");
    cartNotification.textContent = cartItemsCount;
}

const addToCart = btn => {
    let cartNotification = document.getElementById("cartNotification");
    let productId = btn.id;
    let productObject = cart[productId];
    if (productObject !== undefined) {
        let productCount = productObject["count"];
        cart[productId] = {productId, "count": ++productCount}
    }else {
        productObject = {productId, "count": 1};
        cart[productId] = productObject;
    }
   ++cartItemsCount;
    cartNotification.textContent = cartItemsCount;
    window.localStorage.setItem("cart",JSON.stringify(cart));
    console.log(cart);
}

// onbeforeunload = event=>{
//     window.localStorage.setItem("cart",JSON.stringify(cart));
//     console.log("STRINGIFIED: "+JSON.stringify(cart));
//     //window.localStorage.clear();
// }
