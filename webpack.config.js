const path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
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
    publicPath: '/dist',
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
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin({
      title: 'Blog',
      filename: 'index.html',
      meta: {
        viewport: 'minimum-scale=1, initial-scale=1, width=device-width',
      },
    }),
    new HtmlWebpackRootPlugin(),
  ],
  devtool: 'eval',
  mode: 'development',
};
