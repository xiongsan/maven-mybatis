var path = require('path')
module.exports = {
    entry: './app/pc.js',
    output: {
        filename: 'index.js',
        path: path.resolve(__dirname, './')
    },
    module: {
        loaders: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            query: {
                presets: ['es2015', 'react']
            }
        }]
    },
    resolve: {
        alias: {
            views: path.join(__dirname, 'views'),
            dist: path.join(__dirname, 'dist'),
            style: path.join(__dirname, 'style'),
            components: path.join(__dirname, 'components'),
            common: path.join(__dirname, 'common'),
            kit: path.join(__dirname, 'kit'),
            actions: path.join(__dirname, "redux/actions"),
            reducers: path.join(__dirname, "redux/reducers"),
            img: path.join(__dirname, "img"),
            font:path.join(__dirname,'font')
        }
    }
}
