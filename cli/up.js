const inFolder = require('in-folder')
const exec = require('executive')
const memLimit = "256m"

module.exports = class Up {

    static web() {
        return exec([
            "docker rm -f cart-web",
            "docker run -p 7080:8080 -m " + memLimit + " -d --name cart-web cart-web"
        ])
    }

    static db() {
        return exec([
           "docker rm -f mongo",
           "docker run -p 27017:27017 -m " + memLimit + " -d --name mongo mongo:3.4"
        ])
    }

    static zoo() {
        // This image includes EXPOSE 2181 2888 3888 (the zookeeper client port, follower port, election port respectively),
        // so standard container linking will make it automatically available to the linked containers
        return inFolder("zoo", () => exec(
            "docker-compose up -d"
        ))
    }

    static go(opts) {

        if (opts.web) {
            return Up.web()

        } else if (opts.db) {
            return Up.db()

        } else  if (opts.zoo) {
            return Up.zoo()

        } else {

            return Promise.all([
                Up.web(),
                Up.db(),
                Up.zoo()
            ])

        }
    }

}