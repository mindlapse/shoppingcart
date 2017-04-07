export default [function() {


    let activePage;

    return {

        PRODUCT_PAGE : "productPage",
        LOGIN_PAGE : "loginPage",
        CART_PAGE : "cartPage",

        // Set the current page
        setActivePage : function(newPage) {
            activePage = newPage
        },

        // Returns true if the page is active.
        // page should be one of the PRODUCT_PAGE, LOGIN_PAGE, or CART_PAGE constants.
        isPageActive : function(page) {
            return activePage == page;
        }

    }



}]
