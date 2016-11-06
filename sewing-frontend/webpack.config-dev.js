/**
 * Created by meng06.li on 2016/7/28.
 */

var webpack = require('webpack');

var config = {
    entry: ['./index.js'],
    resolve: {alias: {}},
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
        port: 8080,
        host: '127.0.0.1',
        proxy: {
            '/elastic': {
                target: 'http://127.0.0.1:10080',
            }
        }
    }
};

module.exports = config;
