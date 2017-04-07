export default ["$location", "CartSvc", "ProductSvc", "NavSvc", function ($location, cartSvc, productSvc, navSvc) {

    // Update the active page on the header
    navSvc.setActivePage(navSvc.CART_PAGE);

    const self = this;

    // Download the cart
    cartSvc.downloadCart().then((cartItems) => {
        // cartItems is [{productId, quantity}, ...]
        self.cartItems = cartItems
    })


    // Lookup a product by id from the product service
    this.getProduct = function(productId) {
        return productSvc.getProduct(productId);
    }

    // Add a product to the cart
    this.addItem = function(productId) {
        return cartSvc.addCartItem(productId)
    }

    // Remove a product from the cart
    this.removeItem = function(productId) {
        cartSvc.removeCartItem(productId)
        self.cartItems = cartSvc.getCart()
    }

}]