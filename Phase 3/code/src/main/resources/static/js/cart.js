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
    let id = btn.id;
    let productObject = cart[id];
    if (productObject !== undefined) {
        let productCount = productObject["count"];
        cart[id] = {id, "count": ++productCount}
    }else {
        productObject = {id, "count": 1};
        cart[id] = productObject;
    }
   ++cartItemsCount;
    cartNotification.textContent = cartItemsCount;
    let stringifiedCart = JSON.stringify(cart);
    window.localStorage.setItem("cart",stringifiedCart);
    let cartInput = document.getElementById("cart-input");
    cartInput.value = stringifiedCart;
    console.log(cart);
}

$(document).ready(function(){
    $(document).on("click","#submitCart",function(){
        let form = $(this).closest("form");
        let itemArr = [];
        for(key in cart){
            itemArr.push(cart[key]);
        }
        if(itemArr.length <= 0){
            //show error
            return;
        }
        $("#cart-input").val(JSON.stringify(itemArr));
        form.submit();
    });
});

// onbeforeunload = event=>{
//     window.localStorage.setItem("cart",JSON.stringify(cart));
//     console.log("STRINGIFIED: "+JSON.stringify(cart));
//     //window.localStorage.clear();
// }
