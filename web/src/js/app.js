import angular from 'angular'
import 'angular-route'
import 'bootstrap/dist/js/bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery'
import 'font-awesome/css/font-awesome.min.css'
import '../css/shopcart.css'

import productSvc from './svc/productSvc'
import cartSvc from './svc/cartSvc'
import navSvc from './svc/navSvc'
import navCtrl from './ctrl/navCtrl'
import productCtrl from './ctrl/productCtrl'
import cartCtrl from './ctrl/cartCtrl'
import config from './config/config'

const app = angular.module("ShopCart", ["ngRoute"]);


app.
    config(config).
    factory("ProductSvc", productSvc).
    factory("CartSvc", cartSvc).
    factory("NavSvc", navSvc).
    controller("NavCtrl", navCtrl).
    controller("ProductCtrl", productCtrl).
    controller("CartCtrl", cartCtrl).
    run([function() {

        // :)

    }]);
