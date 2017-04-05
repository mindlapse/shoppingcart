export default ["$http", function ($http) {

    return {

        loadProducts : function() {
            return $http.get("/products")
        }
    };
}]
