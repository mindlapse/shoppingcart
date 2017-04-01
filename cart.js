const docopt = require('docopt').docopt
const Build = require('./cli/build.js')
const Up = require('./cli/up.js')

doc = `Usage:
    cart go [(web|db|zoo)]
    cart build [(web|db|zoo)]
    cart up [(web|db|zoo)]
    cart -h | --help | --version
`

const opts = docopt(doc, {argv:Array.from(process.argv.slice(2))})


if (opts.go) {
    Build.go(opts).then(
        () => Up.go(opts))
}

if (opts.build) {
    Build.go(opts)
}

if (opts.up) {
    Up.go(opts)
}