export default ["$http", function ($http) {

    let cartItems = [];

    return {


        getCartCount : function() {
            return cartItems.reduce((sum, item) => item.quantity + sum, 0)  // i.e. Sum up the quantities of each item
        },

        addCartItem : function(productId) {
            let found = false;
            cartItems.forEach((item) => {
                if (item.productId == productId) {
                    item.quantity = item.quantity + 1;
                    found = true;
                }
            });
            if (!found) {
                cartItems.push({ productId, quantity : 1})
            }
            console.log(cartItems)
        },

        fetchCart : function() {
            return $http.get("/cart")
        }
    }
}]
