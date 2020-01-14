const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const HtmlWebpackRootPlugin = require('html-webpack-root-plugin');

module.exports = {
  context: path.resolve(__dirname, 'src/main/client'),
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  entry: './src/index.js',
  output: {
    path: path.resolve(__dirname, 'src/main/webapp/dist'),
    filename: 'app.bundle.js',
  },
  module: {
    rules: [
      {
        test: /\.js?$/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: [
              ['@babel/preset-env', { targets: { browsers: ['> 1% in KR'] } }],
              '@babel/preset-react',
            ],
          },
        },
        exclude: /node_modules/,
      },
      {
        test: /\.scss$/,
        use: ['style-loader', 'css-loader', 'sass-loader'],
        exclude: /node_modules/,
      },
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({
      title: 'Blog',
      filename: 'index.html',
    }),
    new HtmlWebpackRootPlugin(),
  ],
  devtool: 'eval',
  cache: true,
  mode: 'development',
};
