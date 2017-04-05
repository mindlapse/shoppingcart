const path = require('path');
const webpack = require('webpack')
const CopyWebpackPlugin = require('copy-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const common = {
    entry : "./src/js/app.js",
    watch : false,
    module: {
        rules: [
            {
                test: /\.js$/,
                include: path.resolve(__dirname, 'js'),
                use: [
                    "babel-loader",
                    'eslint-loader'
                ]
            },
            // { test: /\.css$/, loader: "style-loader!css-loader" },
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract("css-loader")
            },
            { test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000' }
        ]
    },
    devtool : 'cheap-eval-source-map',      // TODO cannot use this in production
    plugins: [
        new webpack.optimize.UglifyJsPlugin(),
        new ExtractTextPlugin("styles.css"),
        new CopyWebpackPlugin([
            {from : "src/index.html", to : "index.html"},
            {from : "src/pages", to : "pages"}
        ]),
        new webpack.ProvidePlugin({
            $: "jquery",
            jQuery: "jquery"
        })
    ]
}

module.exports = [
    Object.assign({}, common, {
        output : {
            path : path.resolve(__dirname, '../zuul/src/main/resources/static'),
            filename : "bundle.js"      // TODO hash
        }
    }),

    Object.assign({}, common, {
        output : {
            path : path.resolve(__dirname, 'dist'),
            filename : "bundle.js"      // TODO hash
        }
    })
];
