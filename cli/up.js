const inFolder = require('in-folder')
const exec = require('executive')
const MEM_LIMIT_SMALL = "128m"
const MEM_LIMIT_BIG = "384m"

module.exports = class Up {

    static web() {
        return exec([
            "docker rm -f cart-web",
            "docker run -p 7080:8080 -m " + MEM_LIMIT_SMALL + " -d --name cart-web cart-web"
        ])
    }

    static db() {
        return exec([
           "docker rm -f mongo",
           "docker run -p 27017:27017 -m " + MEM_LIMIT_SMALL + " -d --name mongo mongo:3.4"
        ])
    }

    static redis() {
        return exec([
            "docker rm -f redis",
            "docker run -p 6379:6379 -m " + MEM_LIMIT_SMALL + " -d --name redis redis:3.2.8-alpine redis-server --requirepass 3RgN4ThM"
        ])
    }

    static zoo() {
        return inFolder("zoo", () => exec(
            "docker-compose up -d"
        ))
    }

    static cart() {
        return exec([
            "docker rm -f svc-cart",
            "docker run -p 7100:8080 -m " + MEM_LIMIT_BIG + " -d --link mongo --name svc-cart svc-cart"
        ])
    }

    static product() {
        return exec([
            "docker rm -f svc-product",
            "docker run -p 7101:8080 -m " + MEM_LIMIT_BIG + " -d --link mongo --name svc-product svc-product"
        ])
    }

    static zuul() {
        return exec([
            "docker rm -f zuul",
            "docker run -p 7200:8080 -m " + MEM_LIMIT_BIG + " -d " +
                "--link mongo " +
                "--link redis " +
                "--link svc-cart " +
                "--link svc-product " +
                "--name zuul zuul"
        ])
    }

    static go(opts) {

        if (opts.web) {
            return Up.web()

        } else if (opts.db) {
            return Up.db()

        } else  if (opts.zoo) {
            return Up.zoo()

        } else if (opts.cart) {
            return Up.cart()

        } else if (opts.product) {
            return Up.product()

        } else if (opts.zuul) {
            return Up.zuul()

        } else if (opts.redis) {
            return Up.redis()

        } else {

            return Promise.all([
                Up.web(),
                Up.db(),
                Up.redis(),
                Up.zoo(),
                Up.cart(),
                Up.products(),
                Up.zuul()
            ])

        }
    }

}