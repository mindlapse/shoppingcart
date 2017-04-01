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

    static zoo() {
        return inFolder("zoo", () => exec(
            "docker-compose up -d"
        ))
    }

    static cart() {
        return exec([
            "docker rm -f svc-cart",
            "docker run -p 7100:8080 -m " + MEM_LIMIT_BIG + " -d --name svc-cart svc-cart"
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

        } else {

            return Promise.all([
                Up.web(),
                Up.db(),
                Up.zoo(),
                Up.cart()
            ])

        }
    }

}