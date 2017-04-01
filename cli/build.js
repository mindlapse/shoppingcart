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
        return inFolder("svc/cart-svc", () => exec([
            "mvn clean package",
            "docker build -t svc-cart ."
        ]))
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
        } else {

            return Promise.all([
                Build.web(),
                Build.db(),
                Build.zoo(),
                Build.cart()
            ])

        }

    }

}