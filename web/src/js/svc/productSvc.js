export default ["$http", "CartSvc", function ($http, cartSvc) {

    return {

        loadProducts : function() {
            return $http.get("/products")
        }
    };
}]
