import angular from 'angular'
import 'angular-route'
import 'bootstrap/dist/js/bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery'

import productSvc from './svc/productSvc'
import groundCtrl from './ctrl/groundCtrl'
import productCtrl from './ctrl/productCtrl'
import cartCtrl from './ctrl/cartCtrl'
import config from './config/config'

const app = angular.module("ShopCart", ["ngRoute"]);


app.
    config(config).
    factory("ProductSvc", productSvc).
    controller("GroundCtrl", groundCtrl).
    controller("ProductCtrl", productCtrl).
    controller("CartCtrl", cartCtrl).
    run([function() {


        // console.log(productSvc.loadProducts());


    }]);