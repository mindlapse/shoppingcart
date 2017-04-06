
export default ["$location", "NavSvc", "CartSvc", function ($location, navSvc, cartSvc) {



    this.loadProductPage = function() {
        $location.path("/page/products")
    }

    this.loadCartPage = function() {
        $location.path("/page/cart")
    }

    function getPageClass(page) {
        return navSvc.isPageActive(page) ? "active" : ""
    }

    this.getProductPageClass = function() {
        return getPageClass(navSvc.PRODUCT_PAGE)
    }

    this.getCartPageClass = function() {
        return getPageClass(navSvc.CART_PAGE)
    }

    this.getCartCount = function() {
        return cartSvc.getCartCount();
    }

}]