export default ["$location", "CartSvc", "NavSvc", function ($location, cartSvc, navSvc) {

    navSvc.setActivePage(navSvc.CART_PAGE);

    console.log("In cart svc")
}]