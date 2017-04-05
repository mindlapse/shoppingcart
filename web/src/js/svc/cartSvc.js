export default ["$http", function ($http) {

    return {
        fetchCart : function() {
            return $http.get("/cart")
        }
    }
}]
