export default [function() {


    // pages = ["productPage", "cartPage", "loginPage"]
    let activePage;

    return {

        PRODUCT_PAGE : "productPage",
        LOGIN_PAGE : "loginPage",
        CART_PAGE : "cartPage",

        setActivePage : function(newPage) {
            activePage = newPage
        },

        isPageActive : function(page) {
            return activePage == page;
        }

    }



}]
