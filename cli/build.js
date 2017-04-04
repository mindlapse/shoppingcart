const exec = require('executive')
const inFolder = require('in-folder')

module.exports = class Build {

    static web() {
        return inFolder("webtier", () => exec("docker build -t cart-web ."))
    }

    static db() {
        return exec("docker pull mongo:3.4")
    }

    static zoo() {
        return exec("docker pull zookeeper:3.4")
    }

    static cart() {
        return inFolder("svc/cart-domain", () => exec([
            "mvn clean package -Dspring.profiles.active=build",
            "docker build -t svc-cart ."
        ], {strict:true}))
    }

    static product() {
        return inFolder("svc/product-domain", () => exec([
            "mvn clean package -Dspring.profiles.active=build",
            "docker build -t svc-product ."
        ], {strict:true}))
    }

    static zuul() {
        return inFolder("zuul", () => exec([
            "mvn clean package -Dspring.profiles.active=build",
            "docker build -t zuul ."
        ], {strict:true}))
    }

    static redis() {
        return exec("docker pull redis:3.2.8-alpine")
    }

    static go(opts) {

        if (opts.web) {
            return Build.web()

        } else  if (opts.db) {
            return Build.db();

        } else if (opts.zoo) {
            return Build.zoo();

        } else if (opts.cart) {
            return Build.cart();

        } else if (opts.product) {
            return Build.product();

        } else if (opts.zuul) {
            return Build.zuul();

        } else if (opts.redis) {
            return Build.redis();

        } else {

            return Promise.all([
                Build.web(),
                Build.db(),
                Build.zoo(),
                Build.cart(),
                Build.product(),
                Build.zuul(),
                Build.redis()
            ])

        }

    }

}