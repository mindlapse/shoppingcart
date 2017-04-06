import interceptor from '../svc/requestInterceptor'

export default ["$httpProvider", "$routeProvider", function($httpProvider, $routeProvider) {

    $httpProvider.interceptors.push(interceptor)

    const login = {
        templateUrl : './pages/login.html'
    }
    const cart = {
        templateUrl : './pages/cart.html',
        controller : 'CartCtrl as cartCtrl'
    }
    const products = {
        templateUrl : './pages/products.html',
        controller : 'ProductCtrl as productCtrl'
    }


    $routeProvider
        .when('/page/login', login)
        .when('/page/cart', cart)
        .when('/page/products', products)
        .otherwise(cart);

}]