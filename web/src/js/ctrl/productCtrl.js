

export default ["$location", "ProductSvc", "NavSvc", "CartSvc", "$rootScope", function ($location, productSvc, navSvc, cartSvc, $rootScope) {

    // Update the header to show the Product page as the current page.
    navSvc.setActivePage(navSvc.PRODUCT_PAGE);

    const self = this;

    // Load the products from the server
    productSvc.loadProducts().then((products) => {
        $rootScope.$apply(function() {
            self.products = products
        })
    });

    // Add an item to the cart
    this.addToCart = function(product) {
        cartSvc.addCartItem(product.id)
    }


}]