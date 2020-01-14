import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import rootReducer from './store/modules';
import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';

const store = createStore(
  rootReducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
);

const theme = createMuiTheme({
  palette: {
    background: {
      default: '#fff',
    },
  },
});

ReactDOM.render(
  <BrowserRouter>
    <ThemeProvider theme={theme}>
      <Provider store={store}>
        <App />
      </Provider>
    </ThemeProvider>
  </BrowserRouter>,
  document.getElementById('root'),
);
