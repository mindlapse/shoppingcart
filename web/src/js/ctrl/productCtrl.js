
export default ["$location", "ProductSvc", function ($location, productSvc) {

    console.log("In productCtrl")
    this.products = (async () => await productSvc.loadProducts())()
    // console.log(this.products);

}]