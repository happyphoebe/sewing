/**
 * Created by meng06.li on 2016/7/28.
 */

var webpack = require('webpack');

var config = {
    entry: ['./index.js'],
    resolve: {alias: {}},
    devtool: false,
    output: {
        path: './build',
        filename: 'app.js'
    },
    module: {
        noParse: [],
        loaders: [
            {test: /\.js$/, loader: 'jsx-loader'},
            {test: /\.css$/, loader: 'style-loader!css-loader'},
            {test: /\.(woff)$/, loader: 'url-loader?limit=100000'}
        ]
    },
    plugins: [
        new webpack.ProvidePlugin({
            $: "jquery"
        })
    ],
    devServer: {
        port: 80,
        host: '0.0.0.0',
        proxy: {
            '/elastic': {
                target: 'http://@host@:10080'
            }
        }
    }
};

module.exports = config;
