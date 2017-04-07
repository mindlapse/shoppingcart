import _ from "underscore"

export default ["$http", "CartSvc", function ($http, cartSvc) {

    // products is [{id, image, name}, ...]
    let products = [];

    const svc = {

        // Download the list of products from the server
        loadProducts : async function() {
            return $http.get("/products").then(response => {
                products = response.data;
                return products
            })
        },

        // Get a product by the productId
        getProduct : function(productId) {
            return _.find(products, item => parseInt(item.id) == productId)
        }
    };

    // Load the initial list of products now that the server has loaded
    svc.loadProducts()
    return svc;
}]
