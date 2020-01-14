import React from 'react';
import { Route } from 'react-router-dom';
import { Home, Login } from './pages';

const App = () => {
  return (
    <>
      <Route path='/' exact component={Home}></Route>
      <Route path='/login' component={Login}></Route>
    </>
  );
};

export default App;
