const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  context: path.resolve(__dirname, 'src/main/views'),
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  entry: {
    app: './src/app',
    admin: './src/admin',
  },
  output: {
    path: path.resolve(__dirname, 'src/main/webapp/dist'),
    filename: '[name].bundle.js',
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
            plugins: ['@babel/plugin-proposal-class-properties'],
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
      filename: 'app.html',
      chunks: ['app'],
    }),
    new HtmlWebpackPlugin({
      title: 'Admin for blog',
      filename: 'admin.html',
      chunks: ['admin'],
    }),
  ],
  devtool: 'eval',
  cache: true,
  mode: 'development',
};
