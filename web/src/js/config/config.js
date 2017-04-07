import interceptor from '../svc/requestInterceptor'

export default ["$httpProvider", "$routeProvider", function($httpProvider, $routeProvider) {

    $httpProvider.interceptors.push(interceptor)
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/json'
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


    // Routing logic
    $routeProvider
        .when('/page/login', login)
        .when('/page/cart', cart)
        .when('/page/products', products)
        .otherwise(cart);

}]