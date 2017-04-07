import _ from 'underscore'

export default ["$http", function ($http) {

    let cartItems = [];

    return {

        // Get the number of items in the cart
        getCartCount : function() {
            return cartItems.reduce((sum, item) => item.quantity + sum, 0)  // i.e. Sum up the quantities of each item
        },


        // Add an item to the cart (and upload it)
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
            $http.post("/cart", { cart : cartItems });
        },


        // Remove an item from the cart (and upload it)
        removeCartItem : function(productId) {
            cartItems.forEach((item) => {
                if (item.productId == productId) {
                    item.quantity = item.quantity - 1;
                }
            });
            cartItems = _.reject(cartItems, item => item.quantity <= 0)
            $http.post("/cart", { cart : cartItems });
        },


        // Get the cart
        getCart : function() {
            return cartItems
        },

        // Download the cart from the server
        downloadCart : function() {
            return $http.get("/cart").then(response => {

                cartItems = response.data.cart;
                return cartItems;
            })
        }
    }
}]
