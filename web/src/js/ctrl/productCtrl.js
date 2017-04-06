

export default ["$location", "ProductSvc", "NavSvc", "CartSvc", function ($location, productSvc, navSvc, cartSvc) {

    navSvc.setActivePage(navSvc.PRODUCT_PAGE);

    const self = this;
    console.log("In productCtrl")

    productSvc.loadProducts().then(results => {
        self.products = results.data;
    });

    this.addToCart = function(product) {
        cartSvc.addCartItem(product.id)
    }


}]