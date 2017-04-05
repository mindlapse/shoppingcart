import interceptor from '../svc/requestInterceptor'

export default ["$httpProvider", "$routeProvider", function($httpProvider, $routeProvider) {

    $httpProvider.interceptors.push(interceptor)

    const login = {
        templateUrl : './pages/login.html'
    }
    const cart = {
        templateUrl : './pages/cart.html',
        controller : 'CartCtrl'
    }
    const products = {
        templateUrl : './pages/products.html',
        controller : 'ProductCtrl'
    }


    $routeProvider
        .when('/login', login)
        .when('/cart', cart)
        .when('/products', products)
        .otherwise(products);

}]