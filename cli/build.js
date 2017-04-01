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

    static go(opts) {
        if (opts.web) {
            return Build.web()
        }
        if (opts.db) {
            return Build.db();
        }
        if (opts.zoo) {
            return Build.zoo();
        }
    }

}